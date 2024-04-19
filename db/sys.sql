CREATE TABLE `tb_user` (
	`id` BIGINT NOT NULL UNIQUE,
	`password` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `tb_role` (
	`id` BIGINT NOT NULL UNIQUE,
	`role_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `tb_user_role` (
	`user_id` BIGINT NOT NULL UNIQUE,
	`role_id` BIGINT NOT NULL UNIQUE,
	PRIMARY KEY(`user_id`, `role_id`)
);

CREATE TABLE `tb_menu` (
	`id` BIGINT NOT NULL UNIQUE,
	`menu_name` VARCHAR(255) NOT NULL,
	`parent_id` BIGINT,
	`permission` VARCHAR(255),
	PRIMARY KEY(`id`)
);

CREATE TABLE `tb_role_menu` (
	`role_id` BIGINT NOT NULL UNIQUE,
	`menu_id` BIGINT NOT NULL UNIQUE,
	PRIMARY KEY(`role_id`, `menu_id`)
);
