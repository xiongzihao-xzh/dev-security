CREATE TABLE `tb_user`
(
    `id`          BIGINT       NOT NULL,
    `username`    VARCHAR(255) NOT NULL,
    `password`    VARCHAR(255) NOT NULL,
    `create_by`   VARCHAR(255),
    `create_time` DATETIME,
    `update_by`   VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT      NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `tb_role`
(
    `id`          BIGINT       NOT NULL,
    `role_name`   VARCHAR(255) NOT NULL,
    `create_by`   VARCHAR(255),
    `create_time` DATETIME,
    `update_by`   VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT      NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `tb_user_role`
(
    `user_id`     BIGINT  NOT NULL,
    `role_id`     BIGINT  NOT NULL,
    `create_by`   VARCHAR(255),
    `create_time` DATETIME,
    `update_by`   VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
);

CREATE TABLE `tb_menu`
(
    `id`          BIGINT       NOT NULL,
    `menu_name`   VARCHAR(255) NOT NULL,
    `parent_id`   BIGINT,
    `permission`  VARCHAR(255),
    `create_by`   VARCHAR(255),
    `create_time` DATETIME,
    `update_by`   VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT      NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `tb_role_menu`
(
    `role_id`     BIGINT  NOT NULL,
    `menu_id`     BIGINT  NOT NULL,
    `create_by`   VARCHAR(255),
    `create_time` DATETIME,
    `update_by`   VARCHAR(255),
    `update_time` DATETIME,
    `delete_flag` TINYINT NOT NULL,
    PRIMARY KEY (`role_id`, `menu_id`)
);
