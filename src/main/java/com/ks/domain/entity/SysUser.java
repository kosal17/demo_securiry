package com.ks.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String nickname;

    private String email;

    private String mobile;

    private Integer sex;

    private String avatar;

    private String password;

    private Integer status;

    private String creator;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private String remark;

    private Integer deleted;

    @Serial
    private static final long serialVersionUID = 1L;


}