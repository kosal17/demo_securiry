package com.ks.utils;


import cn.hutool.core.util.ObjectUtil;
import com.ks.constants.HttpStatus;
import com.ks.domain.MyUserDetail;
import com.ks.domain.entity.SysMenu;
import com.ks.exception.ServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class SecurityUtil {

    /**
     * get Authentication
     * @return Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * get Login user
     * @return LoginUserVO
     */
    public static MyUserDetail getLoginUser() {
        return (MyUserDetail) getAuthentication().getPrincipal();
    }

    /**
     * get Login User Id
     * @return id
     */
    public static Long getUserId() {
        Long id = getLoginUser().getId();
        if (ObjectUtil.isNull(id)){
            throw new ServiceException(HttpStatus.FORBIDDEN,"");
        }
        return id;
    }
    /**
     * getUserName
     */
    public static  String  getUserName() {
        String username = getLoginUser().getUsername();
        if (ObjectUtil.isNull(username)){
            throw new ServiceException(HttpStatus.FORBIDDEN,"");
        }
        return username;
    }
    /**
     * getMenus
     */
    public static List<SysMenu> getMenus(){
        List<SysMenu> menus = getLoginUser().getMenus();
        if (ObjectUtil.isNull(menus)){
            throw new ServiceException(HttpStatus.FORBIDDEN,"");
        }
        return menus;
    }
}
