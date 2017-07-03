/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : quicksort

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-04 00:56:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` varchar(100) NOT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '��������',
  `size` varchar(100) DEFAULT NULL COMMENT '���ݴ�С',
  `time` varchar(100) NOT NULL COMMENT '��ʱ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
