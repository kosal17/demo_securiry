package com.ks.domain;

import cn.hutool.core.util.ObjectUtil;
import com.ks.constants.UserStatus;
import com.ks.domain.entity.SysMenu;
import com.ks.domain.entity.SysRole;
import com.ks.domain.entity.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class MyUserDetail implements UserDetails {

    private Long id;
    private String token;
    private SysUser sysUser;
    private Long loginTime;

    private List<SysRole> roles;
    private List<SysMenu> menus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (ObjectUtil.isNotEmpty(menus)) {
            List<String> perms = menus.stream().map(SysMenu::getPerms).toList();
            if (ObjectUtil.isNotEmpty(perms)) {
                return perms.stream().map(SimpleGrantedAuthority::new).toList();
            }
        }
        return null;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return sysUser.getStatus() != UserStatus.EXPIRED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getStatus() != UserStatus.LOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return sysUser.getStatus() != UserStatus.CRE_EXPIRED;
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getStatus() != UserStatus.ENABLE;
    }
}
