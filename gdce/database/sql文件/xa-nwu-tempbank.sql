/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.24 : Database - xa-nwu-tempbank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xa-nwu-tempbank` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xa-nwu-tempbank`;

/*Table structure for table `tb_bank_finance` */

DROP TABLE IF EXISTS `tb_bank_finance`;

CREATE TABLE `tb_bank_finance` (
  `bankAcount` varchar(19) NOT NULL COMMENT '银行卡号',
  `bankPassword` varchar(32) NOT NULL COMMENT '登录密码',
  `cName` varchar(50) NOT NULL COMMENT '企业名称',
  `cRealName` varchar(20) NOT NULL COMMENT '法人代表',
  `cLegalPerson` varchar(18) NOT NULL COMMENT '法人身份证',
  `uRealName` varchar(20) NOT NULL COMMENT '联系人',
  `uTeleNum` varchar(14) NOT NULL COMMENT '联系电话',
  `balance` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
  `usableMoney` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '未冻结金额',
  `frozenMoney` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '冻结余额',
  PRIMARY KEY (`bankAcount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_bank_finance` */

insert  into `tb_bank_finance`(`bankAcount`,`bankPassword`,`cName`,`cRealName`,`cLegalPerson`,`uRealName`,`uTeleNum`,`balance`,`usableMoney`,`frozenMoney`) values ('1241234124124132412','DC483E80A7A0BD9EF71D8CF973673924','暴雪战网公司','瓦利拉','61032516401212221X','瓦利拉','15263748362',0.00,0.00,0.00),('6006066553365568218','DC483E80A7A0BD9EF71D8CF973673924','小米煤炭股份有限公司','渣渣辉','460034198403121254','张三','18292188250',30000000.00,15770097.00,14230003.00),('6006066554812668222','DC483E80A7A0BD9EF71D8CF973673924','小米','雷军','11204416541220243x','雷军','18292845571',0.00,0.00,0.00),('6006066693314868215','DC483E80A7A0BD9EF71D8CF973673924','s13号科技有限公司','岳毅','612324199304560221','杨华','13565649845',0.00,0.00,0.00);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
