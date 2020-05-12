/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.1.36-MariaDB : Database - db_laundry
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_laundry` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_laundry`;

/*Table structure for table `tbl_ambil` */

DROP TABLE IF EXISTS `tbl_ambil`;

CREATE TABLE `tbl_ambil` (
  `no_antrian` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jns_pewangi` varchar(10) NOT NULL,
  `jml_pakaian` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_ambil` */

insert  into `tbl_ambil`(`no_antrian`,`nama`,`no_telp`,`alamat`,`jns_pewangi`,`jml_pakaian`,`harga`,`tanggal`,`total`,`bayar`,`kembali`) values 
(3,'mila','087770432050','cicurug','Bubuk',1,13000,'2018-05-26',13000,20000,7000);

/*Table structure for table `tbl_login` */

DROP TABLE IF EXISTS `tbl_login`;

CREATE TABLE `tbl_login` (
  `user` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_login` */

insert  into `tbl_login`(`user`,`pass`) values 
('admin','1234');

/*Table structure for table `tbl_pesan` */

DROP TABLE IF EXISTS `tbl_pesan`;

CREATE TABLE `tbl_pesan` (
  `no_antrian` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `jns_pewangi` varchar(5) NOT NULL,
  `jml_pakaian` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`no_antrian`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_pesan` */

insert  into `tbl_pesan`(`no_antrian`,`nama`,`no_telp`,`alamat`,`jns_pewangi`,`jml_pakaian`,`harga`,`tanggal`) values 
(2,'nateu','087870037257','tanjung biru','Bubuk',2,23000,'2018-05-26'),
(4,'desti','089605612','sukasari','Bubuk',6,63000,'2018-05-26'),
(10,'ramzz','087849876','wojo','Bubuk',4,43000,'2018-12-28'),
(14,'yanti','0988457645','sewon','Cair',1,15000,'2018-12-28'),
(15,'yahya','009869565','jombor','Bubuk',2,23000,'2018-12-28');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
