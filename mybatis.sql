/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-11-23 17:00:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `attachment_id` bigint(20) NOT NULL,
  `attachment_type` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`attachment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addfield` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `editfield` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `queryfield` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', null, '2018-11-20 17:49:35', 'url,sort', 'clothes', '衣服', 'url,isshow', null, null);
INSERT INTO `category` VALUES ('2', null, null, 'title,groupid,url,target,openmode,isshow,sort,content,photourl', 'goods', '裤子', 'title,groupid,url,target,openmode,isshow,sort,content,photourl', null, null);

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province_id` bigint(20) DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '北京', '一线大城市');
INSERT INTO `city` VALUES ('2', '1', '重庆', '二线大城市');

-- ----------------------------
-- Table structure for city_1
-- ----------------------------
DROP TABLE IF EXISTS `city_1`;
CREATE TABLE `city_1` (
  `city_id` int(11) NOT NULL,
  `city_introduce` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city_1
-- ----------------------------
INSERT INTO `city_1` VALUES ('1', '中国首都', '北京');
INSERT INTO `city_1` VALUES ('3', '辽宁省省会', '沈阳');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `id` bigint(20) NOT NULL,
  `above_img_url` varchar(255) DEFAULT NULL,
  `behind_img_url` varchar(255) DEFAULT NULL,
  `below_img_url` varchar(255) DEFAULT NULL,
  `categoryid` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `front_img_url` varchar(255) DEFAULT NULL,
  `groupid` varchar(255) DEFAULT NULL,
  `isshow` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `side_img_url` varchar(255) DEFAULT NULL,
  `sort` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yardage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL,
  `above_img_url` varchar(255) DEFAULT NULL,
  `behind_img_url` varchar(255) DEFAULT NULL,
  `below_img_url` varchar(255) DEFAULT NULL,
  `categoryid` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `front_img_url` varchar(255) DEFAULT NULL,
  `groupid` varchar(255) DEFAULT NULL,
  `isshow` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `side_img_url` varchar(255) DEFAULT NULL,
  `sort` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yardage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', '男', '我一个男孩', '0');
INSERT INTO `student` VALUES ('2', '小红', '女', '我是一个女孩', '0');
INSERT INTO `student` VALUES ('3', '莱恩', '男', '走着走着就老了', '0');
INSERT INTO `student` VALUES ('4', '善恩', '男', '走着走着就老了', '0');
INSERT INTO `student` VALUES ('5', '善恩', '男', '走着走着就老了', '1');
INSERT INTO `student` VALUES ('6', '基恩', '男', '走着走着就老了', '0');
INSERT INTO `student` VALUES ('7', null, null, null, '1');
INSERT INTO `student` VALUES ('8', null, null, null, '1');
INSERT INTO `student` VALUES ('9', '234234', '男', '234234', null);
INSERT INTO `student` VALUES ('10', '234234', '男', '234234', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'dalaoyang', '13');
INSERT INTO `user` VALUES ('2', 'xiaoli', '123');
INSERT INTO `user` VALUES ('3', 'xiaoxiongmao', '123');
