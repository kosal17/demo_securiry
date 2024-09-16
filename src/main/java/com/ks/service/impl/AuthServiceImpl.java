package com.ks.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ks.domain.MyUserDetail;
import com.ks.domain.dto.LoginUserDto;
import com.ks.exception.ServiceException;
import com.ks.service.AuthService;
import com.ks.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public String login(LoginUserDto loginUserDto) {
        MyUserDetail myUserDetail = null;

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUserDto.getUserName(), loginUserDto.getPassword());
        Authentication result = authenticationManager.authenticate(authentication);
        myUserDetail = (MyUserDetail) result.getPrincipal();

        if (ObjectUtil.isEmpty(myUserDetail)) {
            throw new ServiceException(401, "username or password is incorrect");
        }
        return jwtUtils.createToken(myUserDetail);

    }
}
