CREATE TABLE `tb_user` (
    `id` BIGINT NOT NULL,
    `username` VARCHAR(255) NOT NULL COMMENT '用户名',
    `password` VARCHAR(255) NOT NULL COMMENT '密码',
    `order` INT DEFAULT 100 COMMENT '顺序',
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT '用户表';

CREATE TABLE `tb_role` (
    `id` BIGINT NOT NULL,
    `name` VARCHAR(255) NOT NULL COMMENT '角色名',
    `order` INT DEFAULT 100 COMMENT '顺序',
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT '角色表';

CREATE TABLE `tb_user_role` (
    `user_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
) COMMENT '用户角色关联表';

CREATE TABLE `tb_menu` (
    `id` BIGINT NOT NULL,
    `name` VARCHAR(255) NOT NULL COMMENT '菜单名',
    `type` INT NOT NULL DEFAULT 0 COMMENT '菜单类型',
    `permission` VARCHAR(255) COMMENT '权限标识',
    `order` INT DEFAULT 100 COMMENT '顺序',
    `parent_id` BIGINT DEFAULT 0 COMMENT '父菜单 id',
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT '菜单表';

CREATE TABLE `tb_role_menu` (
    `role_id` BIGINT NOT NULL,
    `menu_id` BIGINT NOT NULL,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`role_id`, `menu_id`)
) COMMENT '角色菜单关联表';

CREATE TABLE `tb_department` (
    `id` BIGINT NOT NULL,
    `name` VARCHAR(255) NOT NULL COMMENT '部门名字',
    `order` INT DEFAULT 100 COMMENT '顺序',
    `parent_id` BIGINT NOT NULL DEFAULT 0 COMMENT '上级部门 id',
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT '部门表';

CREATE TABLE `tb_user_department` (
    `user_id` BIGINT NOT NULL,
    `department_id` BIGINT NOT NULL,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`user_id`, `department_id`)
) COMMENT '用户部门关联表';