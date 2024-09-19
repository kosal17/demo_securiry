package com.ks.controller;

import com.ks.domain.entity.SysMenu;
import com.ks.domain.response.Result;
import com.ks.domain.vo.MenuVO;
import com.ks.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys_menu")
@RequiredArgsConstructor
public class SysMenuController {

    private final SysMenuService sysMenuService;

    @GetMapping()
    @PreAuthorize("hasAuthority('system:menu:list')")
    public Result getSysMenu(String name) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuName(name);
        return Result.success(sysMenuService.findMenus(sysMenu));
    }

    @GetMapping("my_menu.do")
    public Result getMyMenu() {
        return Result.success(sysMenuService.findMyMenus());
    }
}
