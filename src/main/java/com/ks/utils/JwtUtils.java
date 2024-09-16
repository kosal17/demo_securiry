package com.ks.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.ks.constants.CacheConstants;
import com.ks.domain.MyUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * create refresh token
 */
@Slf4j
@Component
public class JwtUtils {

    private final String secret = "jsdfsdfsjdsyksjeeeecxv";
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    /**
     * create token and save to redid
     */
    public String createToken(MyUserDetail myUserDetail) {
        // 创建一个map
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        // 将UUID存储到登录用户中，可以在后台系统中根据token值获取redis中数据
        myUserDetail.setToken(token);
        Map<String, Object> claims = new HashMap<>();
        claims.put("token", token);
        // refresh token
        refreshToken(myUserDetail);
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    /**
     * parse token
     */
    public Claims parseToken(String token) {
        // 解析token
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    /**
     * get login user
     */
    public Object getLoginUser(HttpServletRequest request) {
        // 通过jwt加密过的
        String token = request.getHeader("Authorization");
        if(StrUtil.isNotEmpty(token)) {
            // 解析token
            Claims claims = parseToken(token);
            String parseToken = (String) claims.get("token");
            // 从redis中获取数据
            MyUserDetail myUserDetail =  redisCacheUtil.getCacheObject(CacheConstants.LOGIN_USER_KEY + parseToken);
            if (ObjectUtil.isNull(myUserDetail)){
                return null;
            }
            // 获取登录时间
            long loginTime = myUserDetail.getLoginTime();
            // 获取当前时间
            long currentTimeMillis = System.currentTimeMillis();
            // 判断是否相差20分钟
            long millis = currentTimeMillis / 1000 / 60 - loginTime/ 1000 / 60;
            if(millis >= 20) {
                refreshToken(myUserDetail);
            }
            return myUserDetail;
        }
        return null;
    }
    // 刷新token
    private void refreshToken(MyUserDetail myUserDetail) {
        // 设置登录时间
        myUserDetail.setLoginTime(System.currentTimeMillis());
        // 将用户数据缓存到redis中
        redisCacheUtil.setCacheObject(CacheConstants.LOGIN_USER_KEY + myUserDetail.getToken(),myUserDetail,30, TimeUnit.MINUTES);
        log.info("key ===> {}",CacheConstants.LOGIN_USER_KEY + myUserDetail.getToken());
        log.info("user detail ===> {}",myUserDetail);
    }
}
