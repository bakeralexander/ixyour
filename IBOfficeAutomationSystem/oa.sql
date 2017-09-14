/*
Navicat MySQL Data Transfer

Source Server         : LOCALHOST
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2017-09-14 15:41:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `oa_user`
-- ----------------------------
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '用户密码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `error_num` int(11) DEFAULT NULL COMMENT '输入密码错误次数',
  `is_delete` int(1) NOT NULL COMMENT '标记',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `head_portrait` varchar(200) DEFAULT NULL COMMENT '头像',
  `status` varchar(50) NOT NULL COMMENT '帐号状态',
  `user_type` varchar(50) NOT NULL COMMENT '用户类型',
  `phone` varchar(50) DEFAULT NULL,
  `age` int(150) DEFAULT NULL COMMENT '年龄',
  `gender` int(1) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `real_name` varchar(50) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_user
-- ----------------------------
