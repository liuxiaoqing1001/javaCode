
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` char(32) DEFAULT NULL,
  `regdatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '0-注册，未激活，1-激活，2-禁用',
  `status` tinyint(4) DEFAULT NULL,
  `photourl` varchar(60) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `activecode` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张三', '202cb962ac59075b964b07152d234b70', '2020-09-24 09:43:00', '0', null, null, '13890900909', '3809ed36f71a4bc3b335d72095ecf26e');
INSERT INTO `tb_user` VALUES ('2', '李四', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('3', 'joe', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('4', 'rose', '202cb962ac59075b964b07152d234b70', '2020-09-25 08:26:41', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('5', 'mike', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('6', 'wangwu', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('7', '赵六', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('8', '王小妞', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('9', '李小虎', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);




-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', '时事');
INSERT INTO `tb_type` VALUES ('2', '娱乐');
INSERT INTO `tb_type` VALUES ('3', '国际');
INSERT INTO `tb_type` VALUES ('4', '电影');
INSERT INTO `tb_type` VALUES ('5', '综艺');


-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `pubdatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布日期时间',
  `comefrom` varchar(255) DEFAULT NULL COMMENT '新闻来源',
  PRIMARY KEY (`id`),
  KEY `typeid` (`typeid`),
  CONSTRAINT `tb_news_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `tb_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES ('1', '1', '纵观CBA', '80岁蒋兴权还在场边', '2020-07-21 11:24:38', '运动家');
INSERT INTO `tb_news` VALUES ('2', '2', '浪姐', '姐姐们很努力，姐姐们的表现来看待职场反馈', '2020-07-10 11:31:36', '芒果新闻');
INSERT INTO `tb_news` VALUES ('3', '2', '赌王遗产', 'u咱们美关系', '2020-07-11 14:32:52', '天天新鲜娱乐');
INSERT INTO `tb_news` VALUES ('4', '2', '妹妹张子枫', '高考结束，准大学生了', '2020-07-10 19:34:15', '头条');
INSERT INTO `tb_news` VALUES ('5', '3', '美国疫情', '不带口罩，失控了！', '2020-07-09 09:35:17', '凤凰卫视');
INSERT INTO `tb_news` VALUES ('6', '2', '哈萨克斯坦国防部副部长', '哈萨克斯坦国防部副部长因感染新冠状病毒逝世', '2020-07-20 03:52:59', '中国网');
INSERT INTO `tb_news` VALUES ('7', '4', '千与千寻', '你看懂了么', '2020-06-30 11:37:58', '头条');
INSERT INTO `tb_news` VALUES ('8', '4', '长城', '景甜表现很不错！', '2020-07-03 09:38:45', '头条');
INSERT INTO `tb_news` VALUES ('9', '4', '狩猎', '孩童之恶源于无知，承认之恶始于偏见', '2020-07-09 09:40:07', '头条');
INSERT INTO `tb_news` VALUES ('10', '2', '说唱听我的', '太好看了！', '2020-07-16 23:26:16', '芒果TV');
