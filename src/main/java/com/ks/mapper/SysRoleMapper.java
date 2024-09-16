package com.ks.mapper;

import com.ks.domain.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author kosal
* @description 针对表【sys_role】的数据库操作Mapper
* @createDate 2024-09-12 11:00:40
* @Entity com.ks.domain.entity.SysRole
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT r.* \n" +
            "FROM sys_user_role ur \n" +
            "JOIN sys_role r ON  ur.`role_id` = r.`role_id` \n" +
            "WHERE ur.`user_id` = #{id} AND r.`deleted` = 0")
    List<SysRole> findRolesByUserId(@Param("id") Long id);
}




