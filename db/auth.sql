/* 用户表 */
CREATE TABLE `tb_user` (
    `id` BIGINT NOT NULL,
    -- 用户名
    `username` VARCHAR(255) NOT NULL,
    -- 密码
    `password` VARCHAR(255) NOT NULL,
    -- 顺序
    `order` INT DEFAULT 100,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
);

/* 角色表 */
CREATE TABLE `tb_role` (
    `id` BIGINT NOT NULL,
    -- 角色名
    `name` VARCHAR(255) NOT NULL,
    -- 顺序
    `order` INT DEFAULT 100,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
);

/* 用户角色关联表 */
CREATE TABLE `tb_user_role` (
    `user_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
);

/* 菜单表 */
CREATE TABLE `tb_menu` (
    `id` BIGINT NOT NULL,
    -- 菜单名
    `name` VARCHAR(255) NOT NULL,
    -- 父菜单 id
    `parent_id` BIGINT DEFAULT 0,
    -- 权限标识
    `permission` VARCHAR(255),
    -- 顺序
    `order` INT DEFAULT 100,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
);

/* 角色菜单关联表 */
CREATE TABLE `tb_role_menu` (
    `role_id` BIGINT NOT NULL,
    `menu_id` BIGINT NOT NULL,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`role_id`, `menu_id`)
);

/* 部门表 */
CREATE TABLE `tb_department` (
    `id` BIGINT NOT NULL,
    -- 部门名字
    `name` VARCHAR(255) NOT NULL,
    -- 上级部门 id
    `parent_id` INT NOT NULL DEFAULT 0,
    -- 顺序
    `order` INT DEFAULT 100,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`id`)
);

/* 用户部门关联表 */
CREATE TABLE `tb_user_department` (
    `user_id` BIGINT NOT NULL,
    `department_id` BIGINT NOT NULL,
    `create_by` VARCHAR(255),
    `create_time` DATETIME,
    `update_by` VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`user_id`, `department_id`)
);