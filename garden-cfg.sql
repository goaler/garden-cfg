/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : garden-cfg

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-07-31 21:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cfg_app
-- ----------------------------
DROP TABLE IF EXISTS `cfg_app`;
CREATE TABLE `cfg_app` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_name` varchar(45) NOT NULL COMMENT 'app名称',
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='应用';

-- ----------------------------
-- Table structure for cfg_cluster
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cluster`;
CREATE TABLE `cfg_cluster` (
  `cluster_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cluster_name` varchar(45) NOT NULL COMMENT '集群名称',
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='集群';

-- ----------------------------
-- Table structure for cfg_doc
-- ----------------------------
DROP TABLE IF EXISTS `cfg_doc`;
CREATE TABLE `cfg_doc` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` int(11) NOT NULL COMMENT '应用',
  `env_id` int(11) NOT NULL COMMENT '所属环境',
  `cluster_id` int(11) NOT NULL COMMENT '所属集群',
  `group_id` int(11) DEFAULT NULL COMMENT '配置组id',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置文档';

-- ----------------------------
-- Table structure for cfg_env
-- ----------------------------
DROP TABLE IF EXISTS `cfg_env`;
CREATE TABLE `cfg_env` (
  `env_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `env_name` varchar(45) NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`env_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for cfg_group
-- ----------------------------
DROP TABLE IF EXISTS `cfg_group`;
CREATE TABLE `cfg_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置组id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='一组配置项';

-- ----------------------------
-- Table structure for cfg_item
-- ----------------------------
DROP TABLE IF EXISTS `cfg_item`;
CREATE TABLE `cfg_item` (
  `item_id` int(11) NOT NULL COMMENT '配置项id',
  `group_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属组id',
  `key` varchar(45) DEFAULT NULL COMMENT '键',
  `value` varchar(45) DEFAULT NULL COMMENT '值',
  `comment` varchar(255) DEFAULT NULL COMMENT '注释',
  `position` int(11) NOT NULL COMMENT '位置',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '类型：0-配置项；1-配置组',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置项';
