/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.18-log : Database - socket_project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`socket_project` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `socket_project`;

/*Table structure for table `number` */

DROP TABLE IF EXISTS `number`;

CREATE TABLE `number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `odd_number` int(11) DEFAULT NULL,
  `even_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `number` */

insert  into `number`(`id`,`odd_number`,`even_number`) values (1,0,22),(2,0,12),(3,0,84),(4,13,0),(5,547,0),(6,0,86),(7,79,0),(8,45,0),(9,0,898),(10,0,78),(11,0,98),(12,0,100),(13,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
