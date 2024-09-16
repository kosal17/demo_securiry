package com.ks.mapper;

import com.ks.domain.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author kosal
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2024-09-12 11:00:40
* @Entity com.ks.domain.entity.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("<script>" +
            "SELECT m.*,rm.`role_id`\n" +
            "FROM sys_role_menu rm JOIN sys_menu m ON rm.`menu_id` = m.`id`\n" +
            "WHERE rm.`role_id` IN " +
            "<foreach item='item' index='index' collection='list' open='(' separator=',' close=')'>" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    List<SysMenu> findMenusByRoleIds(List<Long> list);
}




