create database zblog;

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL COMMENT '分类Id',
  `title` varchar(40) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '内容',
  `description` varchar(500) NOT NULL COMMENT '文章简介  用于列表显示',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0：正常  1：不可用',
  `author` varchar(15) DEFAULT 'Coriger' COMMENT '作者',
  `createTime` datetime NOT NULL COMMENT '发表时间',
  `updateTime` datetime DEFAULT NULL COMMENT '发表时间',
  `showCount` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='文章表';

--
-- Table structure for table `articletag`
--
DROP TABLE IF EXISTS `articletag`;
CREATE TABLE `articletag` (
  `articleId` int(11) NOT NULL COMMENT '文章Id',
  `tagId` int(11) NOT NULL COMMENT '标签Id',
  `tagName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签中间表';

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(20) NOT NULL COMMENT '分类名称  唯一',
  `aliasName` varchar(20) NOT NULL COMMENT '别名  唯一  比如新闻 就用News 代替  栏目Id不显示在url中',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序 （0-10）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `aliasName_UNIQUE` (`aliasName`),
  UNIQUE KEY `categoryName_UNIQUE` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='分类表  只支持一级分类  如果需要分多个层次 用标签来协助实现';

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `url` varchar(1024) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `args` varchar(255) DEFAULT NULL,
  `classMethod` varchar(255) DEFAULT NULL,
  `exception` varchar(2000) DEFAULT NULL,
  `operateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `partner`
--
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `siteName` varchar(15) NOT NULL COMMENT '站点名',
  `siteUrl` varchar(45) NOT NULL COMMENT '站点地址',
  `siteDesc` varchar(45) NOT NULL COMMENT '站点描述  简单备注 ',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='合作伙伴';

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(25) NOT NULL COMMENT '标签名称  唯一',
  `aliasName` varchar(20) NOT NULL COMMENT '标签别名 唯一',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tagName_UNIQUE` (`tagName`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='标签表';

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `enabled` varchar(5) DEFAULT '0' COMMENT '是否被禁用',
  `credential` varchar(5) DEFAULT '0' COMMENT '凭证是否过期',
  `locked` varchar(5) DEFAULT '0' COMMENT '是否被锁',
  `expired` varchar(5) DEFAULT '0' COMMENT '是否过期',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user_info`;
create table `user_info`
(
  username varchar(20) null,
  avatar varchar(255) null,
  nickname varchar(20) default null comment '昵称',
  phone char(11) null comment '电话号码',
  email varchar(50) default null comment '邮箱',
  signature varchar(2000) null comment '个性签名',
  address varchar(50) null comment '地址',
  announcement varchar(2000) null comment '公告',
  telegram varchar(20) default  null comment 'telegram账号',
  wechart varchar(20) default  null comment '微信账号',
  constraint user_info_username_uindex
  unique (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
  comment '用户信息表'
;

--
-- Dumping data for table `user`
--
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'admin','C9BB6724EB9AC8BBFD1A01AE3143B16D','false','false','false','false','2017-05-17 14:32:13');
UNLOCK TABLES;

-- Dump completed on 2017-05-25  9:07:35