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
  `deksripsi` varchar(10) NOT NULL,
  `kode` varchar(4) NOT NULL,
  `tipe` varchar(4) NOT NULL,
  PRIMARY KEY (`kode`,`tipe`)
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
-- Table structure for table `test1`
--

DROP TABLE IF EXISTS `test1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test1` (
  `idtest1` int(11) NOT NULL,
  `test1col` varchar(45) NOT NULL,
  `test1col1` varchar(45) NOT NULL,
  PRIMARY KEY (`idtest1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test1`
--

LOCK TABLES `test1` WRITE;
/*!40000 ALTER TABLE `test1` DISABLE KEYS */;
/*!40000 ALTER TABLE `test1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test2`
--

DROP TABLE IF EXISTS `test2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test2` (
  `idtest2` int(11) NOT NULL,
  `test2col` varchar(45) NOT NULL,
  PRIMARY KEY (`idtest2`,`test2col`),
  KEY `test1_idx` (`idtest2`),
  CONSTRAINT `test1` FOREIGN KEY (`idtest2`) REFERENCES `test1` (`idtest1`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test2`
--

LOCK TABLES `test2` WRITE;
/*!40000 ALTER TABLE `test2` DISABLE KEYS */;
/*!40000 ALTER TABLE `test2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tkartustok`
--

DROP TABLE IF EXISTS `tkartustok`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tkartustok` (
  `nourut` bigint(20) NOT NULL AUTO_INCREMENT,
  `kodekatalog` varchar(4) NOT NULL,
  `kodetrans` varchar(10) NOT NULL,
  `awal` int(11) NOT NULL,
  `transaksi` int(11) NOT NULL,
  `akhir` int(11) NOT NULL,
  PRIMARY KEY (`nourut`),
  UNIQUE KEY `unique` (`kodekatalog`,`kodetrans`),
  KEY `index` (`nourut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tkartustok`
--

LOCK TABLES `tkartustok` WRITE;
/*!40000 ALTER TABLE `tkartustok` DISABLE KEYS */;
/*!40000 ALTER TABLE `tkartustok` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tkatalog`
--

DROP TABLE IF EXISTS `tkatalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tkatalog` (
  `kode` varchar(4) NOT NULL,
  `artikel` varchar(20) NOT NULL,
  `longdesc` varchar(50) NOT NULL,
  `merk` varchar(4) NOT NULL,
  `tipe` varchar(4) NOT NULL,
  `ukuran` varchar(10) NOT NULL,
  `warna` varchar(10) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tkatalog`
--

LOCK TABLES `tkatalog` WRITE;
/*!40000 ALTER TABLE `tkatalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `tkatalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tklien`
--

DROP TABLE IF EXISTS `tklien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tklien` (
  `kode` varchar(4) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `alamat` varchar(45) NOT NULL,
  `kota` varchar(4) NOT NULL COMMENT 'msf010:tkot',
  `kodepos` varchar(6) NOT NULL,
  `namakontak` varchar(20) NOT NULL,
  `telp` varchar(45) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tklien`
--

LOCK TABLES `tklien` WRITE;
/*!40000 ALTER TABLE `tklien` DISABLE KEYS */;
/*!40000 ALTER TABLE `tklien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttransbrgheader`
--

DROP TABLE IF EXISTS `ttransbrgheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ttransbrgheader` (
  `kode` varchar(10) NOT NULL COMMENT 'reverse YYMMDDXXXX',
  `tanggal` varchar(6) NOT NULL COMMENT 'YYMMDD',
  `klien` varchar(4) NOT NULL COMMENT 'tklien',
  `inout` char(1) NOT NULL COMMENT 'I  : Masuk (Menambah SOH)\\nO : Keluar (mengurangi SOH)',
  `keterangan` varchar(255) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='transaksi barang header';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttransbrgheader`
--

LOCK TABLES `ttransbrgheader` WRITE;
/*!40000 ALTER TABLE `ttransbrgheader` DISABLE KEYS */;
/*!40000 ALTER TABLE `ttransbrgheader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttransbrgitem`
--

DROP TABLE IF EXISTS `ttransbrgitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ttransbrgitem` (
  `kode` varchar(10) NOT NULL COMMENT 'ttransbarangheader',
  `kodekatalog` varchar(4) NOT NULL,
  `jumlah` double NOT NULL,
  `satuan` varchar(4) NOT NULL COMMENT 'MSF010:TSB',
  `harga` double NOT NULL,
  `discount` varchar(20) NOT NULL COMMENT '10 \\n10 + 10.5\\n10+10+10',
  `total` double NOT NULL,
  PRIMARY KEY (`kode`,`kodekatalog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='transaksi barang item';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttransbrgitem`
--

LOCK TABLES `ttransbrgitem` WRITE;
/*!40000 ALTER TABLE `ttransbrgitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `ttransbrgitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-17 22:34:04
