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
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class SysMenu implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String menuName;

    private Integer sort;

    private Integer menuType;

    private String path;

    private String componentPath;

    private String perms;

    private String icon;

    private Integer deleted;

    private String remark;

    private Integer status;

    private String creator;

    private String updater;

    private Date createTime;

    private Date updateTime;

    @Serial
    private static final long serialVersionUID = 1L;


}