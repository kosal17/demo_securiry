package com.ks;

import com.ks.domain.entity.SysMenu;
import com.ks.domain.entity.SysRole;
import com.ks.mapper.SysMenuMapper;
import com.ks.mapper.SysRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class TestAuth {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testFindRoleByUserId() {
        List<SysRole> rolesByUserId = sysRoleMapper.findRolesByUserId(1L);
        log.info("rolesByUserId ===>{}", rolesByUserId);

    }
    @Test
    public void testFindMenusByRoleIds() {
        List<SysMenu> menusByRoleIds = sysMenuMapper.findMenusByRoleIds(List.of(1L, 2L));
        log.info("menusByRoleIds ===> {}", menusByRoleIds);
    }
}
