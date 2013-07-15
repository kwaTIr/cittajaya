CREATE DATABASE  IF NOT EXISTS `paperless` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `paperless`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: paperless
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t010`
--

DROP TABLE IF EXISTS `t010`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t010` (
  `tipe` varchar(4) NOT NULL,
  `kode` varchar(4) NOT NULL,
  `deksripsi` varchar(20) NOT NULL,
  PRIMARY KEY (`tipe`,`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t010`
--

LOCK TABLES `t010` WRITE;
/*!40000 ALTER TABLE `t010` DISABLE KEYS */;
/*!40000 ALTER TABLE `t010` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tkatalog`
--

DROP TABLE IF EXISTS `tkatalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tkatalog` (
  `kode` varchar(10) NOT NULL,
  `merk` varchar(4) NOT NULL COMMENT 'ambil dari 010 : TKMR',
  `artikel` varchar(20) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `ukuran` varchar(10) NOT NULL,
  `longdesc` varchar(45) NOT NULL COMMENT 'gabungan deskripsi merk artikel warna ukuran',
  `tipe` varchar(4) NOT NULL COMMENT 'ambil dari 010 : TKAT',
  PRIMARY KEY (`kode`),
  UNIQUE KEY `longdesc_UNIQUE` (`longdesc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tkatalog`
--

LOCK TABLES `tkatalog` WRITE;
/*!40000 ALTER TABLE `tkatalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `tkatalog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-14 23:40:35
