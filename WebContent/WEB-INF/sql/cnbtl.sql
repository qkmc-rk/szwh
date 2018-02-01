/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.7.19-log : Database - cnbtl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cnbtl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cnbtl`;

/*Table structure for table `t_case` */

DROP TABLE IF EXISTS `t_case`;

CREATE TABLE `t_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `editor` int(11) NOT NULL,
  `origin` varchar(45) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `click` int(11) NOT NULL,
  `content` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `f_case_user_idx` (`editor`),
  CONSTRAINT `f_case_user` FOREIGN KEY (`editor`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_case` */

insert  into `t_case`(`id`,`type`,`title`,`editor`,`origin`,`date`,`click`,`content`) values (1,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:35:38',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(2,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:37:44',1,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(3,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:35:38',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(4,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:35:38',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(5,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:35:38',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(6,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:37:44',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(7,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:37:44',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(8,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:37:44',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(9,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:37:44',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>'),(10,'','昨日小傻瓜',2,'rk个人中心','2018-01-26 04:37:44',0,'<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`name`,`account`,`password`) values (2,'阮坤','mrruan','b206e95a4384298962649e58dc7b39d4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
