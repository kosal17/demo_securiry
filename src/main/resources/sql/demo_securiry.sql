/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.38 : Database - demo_security
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo_security` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `demo_security`;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父id',
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单名',
  `sort` int DEFAULT '0' COMMENT '排序',
  `menu_type` int DEFAULT NULL COMMENT '类型：0，目录，1菜单，2：按钮',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '路由路径   umsUser',
  `component_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组件路径  如：ums/user/index',
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `deleted` int DEFAULT NULL COMMENT '是否删除',
  `remark` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '状态：0：可用，1：不可用',
  `creator` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `updater` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`menu_name`,`sort`,`menu_type`,`path`,`component_path`,`perms`,`icon`,`deleted`,`remark`,`status`,`creator`,`updater`,`create_time`,`update_time`) values (1,0,'Home',0,0,'/index','index','index','home',0,NULL,0,'admin','admin','2023-12-11 18:57:19','2023-12-11 18:57:21'),(2,0,'System Manage',1,0,'/system','system','system','system',0,NULL,0,'admin','admin','2023-12-11 18:58:23','2023-12-11 18:58:25'),(3,0,'System Tool',2,0,'/tools','tools','tools','tool',0,NULL,0,'admin','admin','2023-12-11 18:58:53','2023-12-11 18:58:55'),(4,0,'Payment Manage',3,0,'/pay','pay','pay','pay',1,NULL,0,'admin','admin','2023-12-11 18:59:30','2023-12-11 18:59:32'),(5,2,'User Manage',4,1,'/system/user/index','sysUser','system:user:list','peoples',0,NULL,0,'admin','admin','2023-12-11 19:01:16','2023-12-11 19:01:18'),(6,2,'Role Manage',5,1,'/system/role/index','sysRole','system:role:list','role',0,NULL,0,'admin','admin','2023-12-11 19:02:05','2023-12-11 19:02:08'),(7,2,'Menu Manage',6,1,'/system/menu/index','sysMenu','system:menu:list','menu',0,NULL,0,'admin','admin','2023-12-11 19:02:52','2023-12-11 19:02:55'),(8,3,'Generate Code',7,1,'/tools/gen/index','toolsGen','tools:gen:list','code',0,NULL,0,'admin','admin','2023-12-11 19:03:57','2023-12-11 19:04:00'),(9,5,'Add User',8,2,NULL,NULL,'sysem:user:add','',0,NULL,0,'admin','admin','2023-12-11 19:04:50','2023-12-11 19:04:52');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色标识',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名字',
  `sort` int DEFAULT NULL COMMENT '排序',
  `status` int DEFAULT NULL COMMENT '状态：0：可用，1：不可用',
  `deleted` int DEFAULT NULL COMMENT '是否删除：0: 未删除，1：已删除',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `creator` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `updater` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_label`,`role_name`,`sort`,`status`,`deleted`,`remark`,`creator`,`updater`,`create_time`,`update_time`) values (1,'admin','admin',0,0,0,NULL,'admin','admin','2023-12-11 19:08:39','2023-12-11 19:08:42'),(2,'developer','开发者',1,0,0,NULL,'admin','admin','2023-12-11 19:08:45','2023-12-11 19:08:47');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `menu_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (1,2,5),(2,2,6),(3,2,7),(4,2,8),(5,2,9),(6,2,1),(7,2,2),(8,2,3),(9,2,4),(10,1,1),(11,1,7);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '用户邮箱',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '手机号码',
  `sex` int DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '密码',
  `status` int DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `creator` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1732769264547377165 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='后台用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`nickname`,`email`,`mobile`,`sex`,`avatar`,`password`,`status`,`creator`,`create_time`,`updater`,`update_time`,`remark`,`deleted`) values (1,'admin','admin','xiaoli@feidao.com','123456789',0,'avatarurl','$2a$10$pRwnzWnbVnhAhR8DBzvfrujFzguinBp13siEApFgasTbvqJxi3nrq',5,'admin','2023-12-07 22:29:21','admin','2023-12-07 22:29:21','备注',0),(2,'zs','zs','zhangsan@123.com','16632156458',0,'https://himg.bdimg.com/sys/portraitn/item/public.1.fc4cce31.XtVbJS1kKdVpCfCbNXODUw','$2a$10$pRwnzWnbVnhAhR8DBzvfrujFzguinBp13siEApFgasTbvqJxi3nrq',0,'admin','2023-12-11 19:06:41','admin','2023-12-11 19:06:46',NULL,0),(3,'test','nickname','email','mobile',1,'avatar','password',1,'creator','2024-07-11 16:41:43','updater',NULL,NULL,0),(4,'ks','kosal','','',0,'','$2a$10$pRwnzWnbVnhAhR8DBzvfrujFzguinBp13siEApFgasTbvqJxi3nrq',0,'admin',NULL,'admin',NULL,NULL,0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(2,1,2),(3,2,2),(4,4,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
