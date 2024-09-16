package com.ks.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ks.domain.entity.SysUser;
import com.ks.service.SysUserService;
import com.ks.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author kosal
* @description 针对表【sys_user(后台用户表)】的数据库操作Service实现
* @createDate 2024-09-12 11:00:40
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




