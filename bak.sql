ALTER TABLE `cfg_cluster`
ADD COLUMN `create_user_code`  varchar(255) NOT NULL COMMENT '创建人' AFTER `status`,
ADD COLUMN `create_time`  datetime NOT NULL COMMENT '创建时间' AFTER `create_user_code`,
ADD COLUMN `update_user_code`  varchar(255) NOT NULL COMMENT '修改人' AFTER `create_time`,
ADD COLUMN `update_time`  datetime NOT NULL COMMENT '修改时间' AFTER `update_user_code`;