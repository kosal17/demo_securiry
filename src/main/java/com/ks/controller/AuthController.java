package com.ks.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ks.domain.dto.LoginUserDto;
import com.ks.domain.response.Result;

import com.ks.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("login.do")
    public Result login(@RequestBody LoginUserDto loginUserDto) {
        String token = authService.login(loginUserDto);
        return Result.success().put("token",token);
    }
}
