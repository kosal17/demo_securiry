package com.ks.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ks.domain.entity.SysMenu;
import com.ks.domain.vo.MenuVO;
import com.ks.exception.ServiceException;
import com.ks.service.SysMenuService;
import com.ks.mapper.SysMenuMapper;
import com.ks.utils.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author kosal
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2024-09-12 11:00:40
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

    @Override
    public List<MenuVO> findMenus(SysMenu sysMenu) {
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenu::getDeleted,0);
        if (ObjectUtil.isNotEmpty(sysMenu.getMenuName())){
            wrapper.like(SysMenu::getMenuName, sysMenu.getMenuName());
        }
        List<SysMenu> menus = getBaseMapper().selectList(wrapper);
        return MenuVO.getMenuVoList(menus);
    }

    @Override
    public List<MenuVO> findMyMenus() {
        List<SysMenu> menus;
        try {
            menus = SecurityUtil.getMenus();
        }catch (Exception e){
            throw new ServiceException(401,"You are not logged in or your account has expired.");
        }
        return MenuVO.getMenuVoList(menus);
    }
}




