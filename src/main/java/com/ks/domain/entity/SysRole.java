package com.ks.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long roleId;

    private String roleLabel;

    private String roleName;

    private Integer sort;

    private Integer status;

    private Integer deleted;

    private String remark;

    private String creator;

    private String updater;

    private Date createTime;

    private Date updateTime;

    @Serial
    private static final long serialVersionUID = 1L;

}