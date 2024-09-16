package com.ks.service;

import com.ks.domain.dto.LoginUserDto;

public interface AuthService {
    String login(LoginUserDto loginUserDto);
}
