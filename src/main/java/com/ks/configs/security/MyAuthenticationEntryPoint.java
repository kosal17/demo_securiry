package com.ks.configs.security;

import com.alibaba.fastjson2.JSON;
import com.ks.constants.HttpStatus;
import com.ks.domain.response.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.SUCCESS);
        response.getWriter().write(JSON.toJSONString(Result.error(HttpStatus.UNAUTHORIZED,"You are not logged in or your account has expired.")));

    }
}
