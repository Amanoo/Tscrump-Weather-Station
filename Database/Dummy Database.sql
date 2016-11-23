CREATE DATABASE  IF NOT EXISTS `dummyweatherstation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dummyweatherstation`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dummyweatherstation
-- ------------------------------------------------------
-- Server version	5.6.32-log

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
-- Table structure for table `dummysensorvalues`
--

DROP TABLE IF EXISTS `dummysensorvalues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dummysensorvalues` (
  `Date` datetime NOT NULL,
  `Temperature` float DEFAULT NULL,
  `Pressure` float DEFAULT NULL,
  `Humidity` float DEFAULT NULL,
  `Brightness` float DEFAULT NULL,
  PRIMARY KEY (`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dummysensorvalues`
--

LOCK TABLES `dummysensorvalues` WRITE;
/*!40000 ALTER TABLE `dummysensorvalues` DISABLE KEYS */;
INSERT INTO `dummysensorvalues` VALUES ('2016-11-16 18:00:00',20,1.005,0.2,0.6),('2016-11-17 18:00:00',21,0.998,0.5,0.6),('2016-11-17 19:00:00',19,0.986,0.4,0.5),('2016-11-17 20:00:00',18,0.975,0.33,0.4),('2016-11-17 21:00:00',15,0.983,0.2556,0.3);
/*!40000 ALTER TABLE `dummysensorvalues` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-19 21:26:13