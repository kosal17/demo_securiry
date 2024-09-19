package com.ks.filter;

import cn.hutool.core.util.ObjectUtil;
import com.ks.domain.MyUserDetail;
import com.ks.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MyUserDetail myUserDetail = (MyUserDetail) jwtUtils.getLoginUser(request);
        if(ObjectUtil.isNotNull(myUserDetail)) {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(myUserDetail, null, myUserDetail.getAuthorities());
            // 将用户信息存储到SecurityContext中，SecurityContext存储到SecurityContextHolder中
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // 放行，交由后边的过滤器执行，如果没有登录，就会被登录拦截器[UsernamePasswordAuthenticationFilter]拦截到
        // /auth/sys接口就不需要任何权限

        filterChain.doFilter(request,response);
    }
}
