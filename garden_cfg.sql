/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : garden_cfg

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-07 18:01:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cfg_app
-- ----------------------------
DROP TABLE IF EXISTS `cfg_app`;
CREATE TABLE `cfg_app` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '应用编号',
  `app_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '应用名称',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`app_id`),
  UNIQUE KEY `un_idx_app_code` (`app_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='应用';

-- ----------------------------
-- Records of cfg_app
-- ----------------------------
INSERT INTO `cfg_app` VALUES ('0', 'app_all', '所有应用', '所有应用', '1');
INSERT INTO `cfg_app` VALUES ('1', 'test', '测试应用', '测试应用', '1');
INSERT INTO `cfg_app` VALUES ('2', 'test2', '测试应用2', null, '1');
INSERT INTO `cfg_app` VALUES ('5', 'test3', '测试应用3', '测试应用3', '1');
INSERT INTO `cfg_app` VALUES ('6', 'test4', '测试应用4', '测试应用4', '1');
INSERT INTO `cfg_app` VALUES ('7', 'test5', '测试应用5', '测试应用5', '1');

-- ----------------------------
-- Table structure for cfg_cluster
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cluster`;
CREATE TABLE `cfg_cluster` (
  `cluster_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cluster_code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '集群编号',
  `cluster_name` varchar(45) NOT NULL COMMENT '集群名称',
  `comment` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`cluster_id`),
  UNIQUE KEY `un_idx_cluster_code` (`cluster_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='集群';

-- ----------------------------
-- Records of cfg_cluster
-- ----------------------------
INSERT INTO `cfg_cluster` VALUES ('0', 'cluster_all', '所有', '代表所有集群', '1');
INSERT INTO `cfg_cluster` VALUES ('1', 'default', '默认集群', '默认集群', '1');

-- ----------------------------
-- Table structure for cfg_doc
-- ----------------------------
DROP TABLE IF EXISTS `cfg_doc`;
CREATE TABLE `cfg_doc` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_code` varchar(45) NOT NULL COMMENT '应用',
  `env_code` varchar(45) NOT NULL COMMENT '所属环境',
  `cluster_code` varchar(45) NOT NULL COMMENT '所属集群',
  `group_id` int(11) DEFAULT NULL COMMENT '配置组id',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`doc_id`),
  KEY `foreign_app_code` (`app_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置文档';

-- ----------------------------
-- Records of cfg_doc
-- ----------------------------
INSERT INTO `cfg_doc` VALUES ('1', 'test', 'dev', 'dev', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('2', 'test2', 'dev', 'dev', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('3', 'test3', 'test', 'test', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('4', 'test4', 'test', 'default', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('5', 'test5', 'test', 'default', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('6', 'test5', 'dev', 'default', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('7', 'test4', 'dev', 'default', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('8', 'test3', 'dev', 'default', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('9', 'test2', 'dev', 'default', null, null, '1');
INSERT INTO `cfg_doc` VALUES ('10', 'test9', 'dev', 'default', null, null, '1');

-- ----------------------------
-- Table structure for cfg_env
-- ----------------------------
DROP TABLE IF EXISTS `cfg_env`;
CREATE TABLE `cfg_env` (
  `env_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `env_code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '环境编号',
  `env_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '环境名称',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`env_id`),
  UNIQUE KEY `un_idx_env_code` (`env_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='环境';

-- ----------------------------
-- Records of cfg_env
-- ----------------------------
INSERT INTO `cfg_env` VALUES ('0', 'env_all', 'all', '全部环境', '1');
INSERT INTO `cfg_env` VALUES ('1', 'dev', '开发环境', '开发环境', '1');
INSERT INTO `cfg_env` VALUES ('2', 'test', '测试环境', '测试环境', '1');
INSERT INTO `cfg_env` VALUES ('3', 'formal', '正式环境', '正式环境', '1');

-- ----------------------------
-- Table structure for cfg_group
-- ----------------------------
DROP TABLE IF EXISTS `cfg_group`;
CREATE TABLE `cfg_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置组id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组描述',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='一组配置项';

-- ----------------------------
-- Records of cfg_group
-- ----------------------------

-- ----------------------------
-- Table structure for cfg_item
-- ----------------------------
DROP TABLE IF EXISTS `cfg_item`;
CREATE TABLE `cfg_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置项id',
  `group_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属组id',
  `key` varchar(45) DEFAULT NULL COMMENT '键',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '值',
  `comment` varchar(255) DEFAULT NULL COMMENT '注释',
  `position` int(11) NOT NULL COMMENT '位置',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '类型：0-配置项；1-配置组',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置项';

-- ----------------------------
-- Records of cfg_item
-- ----------------------------

-- ----------------------------
-- Table structure for cfg_user
-- ----------------------------
DROP TABLE IF EXISTS `cfg_user`;
CREATE TABLE `cfg_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

-- ----------------------------
-- Records of cfg_user
-- ----------------------------
INSERT INTO `cfg_user` VALUES ('0', 'admin', 'admin', 'admin', '1');
INSERT INTO `cfg_user` VALUES ('2', 'u001', '用户1', '123', '1');

-- ----------------------------
-- Table structure for cfg_user_hold
-- ----------------------------
DROP TABLE IF EXISTS `cfg_user_hold`;
CREATE TABLE `cfg_user_hold` (
  `hold_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户编码',
  `doc_id` int(11) NOT NULL COMMENT '拥有',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态:0-删除,1-正常',
  PRIMARY KEY (`hold_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cfg_user_hold
-- ----------------------------
INSERT INTO `cfg_user_hold` VALUES ('0', 'admin', '1', '1');
INSERT INTO `cfg_user_hold` VALUES ('2', 'u001', '2', '1');
INSERT INTO `cfg_user_hold` VALUES ('3', 'u001', '3', '1');
INSERT INTO `cfg_user_hold` VALUES ('4', 'u001', '4', '1');
INSERT INTO `cfg_user_hold` VALUES ('5', 'u001', '5', '1');
INSERT INTO `cfg_user_hold` VALUES ('6', 'u001', '10', '1');
