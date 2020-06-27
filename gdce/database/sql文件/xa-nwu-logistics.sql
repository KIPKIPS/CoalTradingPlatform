/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.24 : Database - xa-nwu-logistics
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xa-nwu-logistics` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xa-nwu-logistics`;

/*Table structure for table `tb_bank_finance` */

DROP TABLE IF EXISTS `tb_bank_finance`;

CREATE TABLE `tb_bank_finance` (
  `bankAcount` varchar(57) DEFAULT NULL,
  `bankPassword` varchar(96) DEFAULT NULL,
  `cName` varchar(150) DEFAULT NULL,
  `cRealName` varchar(60) DEFAULT NULL,
  `cLegalPerson` varchar(54) DEFAULT NULL,
  `uRealName` varchar(60) DEFAULT NULL,
  `uTeleNum` varchar(42) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `usableMoney` double DEFAULT NULL,
  `frozenMoney` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_bank_finance` */

insert  into `tb_bank_finance`(`bankAcount`,`bankPassword`,`cName`,`cRealName`,`cLegalPerson`,`uRealName`,`uTeleNum`,`balance`,`usableMoney`,`frozenMoney`) values ('aaa','E10ADC3949BA59ABBE56E057F20F883E','wdwqd','scqc','wcwqc','wcwq','cwqcwq',100,84,16);

/*Table structure for table `tb_distance` */

DROP TABLE IF EXISTS `tb_distance`;

CREATE TABLE `tb_distance` (
  `start_end_pos` varchar(20) NOT NULL DEFAULT '西安-大同' COMMENT '起止位置（西安-大同，西安-宝鸡，西安-太原，大同-宝鸡，大同-太原，太原-宝鸡）',
  `distance` double NOT NULL DEFAULT '0' COMMENT '公里'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_distance` */

insert  into `tb_distance`(`start_end_pos`,`distance`) values ('西安-太原',602),('西安-宝鸡',176),('西安-太原',602),('大同-宝鸡',1041),('大同-太原',276),('宝鸡-太原',778),('西安-太原',602),('西安-宝鸡',176),('西安-太原',602),('大同-宝鸡',1041),('大同-太原',276),('宝鸡-太原',778);

/*Table structure for table `tb_logistics` */

DROP TABLE IF EXISTS `tb_logistics`;

CREATE TABLE `tb_logistics` (
  `logistics_id` int(11) NOT NULL COMMENT '物流商编号',
  `lod_name` varchar(20) NOT NULL DEFAULT '中通' COMMENT '物流商名称',
  `carriage` double NOT NULL DEFAULT '10' COMMENT '10(每公里10元)',
  PRIMARY KEY (`logistics_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_logistics` */

insert  into `tb_logistics`(`logistics_id`,`lod_name`,`carriage`) values (0,'中通',10),(1,'申通',15),(2,'京东',12);

/*Table structure for table `tb_users` */

DROP TABLE IF EXISTS `tb_users`;

CREATE TABLE `tb_users` (
  `user_name` varchar(16) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e' COMMENT '密码',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_users` */

insert  into `tb_users`(`user_name`,`password`) values ('admin','e10adc3949ba59abbe56e057f20f883e');

/*Table structure for table `tb_waybills` */

DROP TABLE IF EXISTS `tb_waybills`;

CREATE TABLE `tb_waybills` (
  `waybill_id` int(11) NOT NULL COMMENT '运单编号',
  `trade_id` varchar(20) NOT NULL DEFAULT 'null' COMMENT '交易编号（参照合同表tb_transaction里的主键）',
  `dis_status` int(11) NOT NULL DEFAULT '0' COMMENT '配送状态（0待确认，1配送中，2已完成）',
  `distributor` varchar(16) NOT NULL DEFAULT 'null' COMMENT '配送人',
  `dis_phone` varchar(16) NOT NULL DEFAULT 'null' COMMENT '配送人联系方式',
  `start_pos` varchar(16) NOT NULL DEFAULT 'null' COMMENT '起始位置',
  `end_pos` varchar(16) NOT NULL DEFAULT 'null' COMMENT '终止位置',
  `logistics_id` int(11) NOT NULL DEFAULT '0' COMMENT '物流商编号',
  `sum_carriage` double NOT NULL DEFAULT '0' COMMENT '总运费',
  `good_source` varchar(16) NOT NULL DEFAULT 'null' COMMENT '货源地',
  `good_destination` varchar(16) NOT NULL DEFAULT 'null' COMMENT '收货地',
  `good_trs_time` timestamp NOT NULL DEFAULT '2019-06-10 15:22:12' COMMENT '发货时间',
  `good_rec_time` timestamp NOT NULL DEFAULT '2019-06-12 15:22:12' COMMENT '到货时间',
  PRIMARY KEY (`waybill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_waybills` */

insert  into `tb_waybills`(`waybill_id`,`trade_id`,`dis_status`,`distributor`,`dis_phone`,`start_pos`,`end_pos`,`logistics_id`,`sum_carriage`,`good_source`,`good_destination`,`good_trs_time`,`good_rec_time`) values (101,'1001',0,'游神','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(102,'1002',0,'游神2','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(103,'1003',0,'游神3','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(104,'\n1004',0,'游神4','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(106,'1006',1,'游神6','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(107,'1007',1,'游神7','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(108,'1008',1,'游神8','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(109,'1009',2,'游神9','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(110,'1010',2,'游神10','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(120,'1111',0,'游神','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(123,'1110',0,'游神','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(124,'1023',1,'LMY','15345511236','西安','太原',0,123124,'西安','大同','2019-07-01 14:49:41','2019-06-13 00:00:00'),(125,'1011',0,'游神','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00'),(126,'1029',0,'游神','13344534353','西安','大同',0,123124,'西安','大同','2019-05-12 00:00:00','2019-06-13 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
