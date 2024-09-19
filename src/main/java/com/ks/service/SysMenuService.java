package com.ks.service;

import com.ks.domain.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ks.domain.vo.MenuVO;

import java.util.List;

/**
* @author kosal
* @description 针对表【sys_menu】的数据库操作Service
* @createDate 2024-09-12 11:00:40
*/
public interface SysMenuService extends IService<SysMenu> {

    List<MenuVO> findMenus(SysMenu sysMenu);

    List<MenuVO> findMyMenus();
}
