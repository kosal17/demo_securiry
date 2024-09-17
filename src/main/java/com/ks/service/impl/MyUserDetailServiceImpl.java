package com.ks.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ks.domain.MyUserDetail;
import com.ks.domain.entity.SysMenu;
import com.ks.domain.entity.SysRole;
import com.ks.domain.entity.SysUser;
import com.ks.exception.ServiceException;
import com.ks.mapper.SysMenuMapper;
import com.ks.mapper.SysRoleMapper;
import com.ks.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;
    private final SysRoleMapper sysRoleMapper;
    private final SysMenuMapper sysMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        List<SysRole> roles = sysRoleMapper.findRolesByUserId(user.getId());
        List<SysMenu> menus = sysMenuMapper.findMenusByRoleIds(roles.stream().map(SysRole::getRoleId).toList());
        if (ObjectUtil.isEmpty(user)){
//            throw new UsernameNotFoundException(username);
            throw new ServiceException(401,"xxx");
        }
        MyUserDetail myUserDetail = new MyUserDetail();
        myUserDetail.setSysUser(user);
        myUserDetail.setRoles(roles);
        myUserDetail.setMenus(menus);
        return myUserDetail;
    }
}
