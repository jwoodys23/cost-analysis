-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: swingtest
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(45) NOT NULL,
  `part_number` varchar(45) NOT NULL,
  `material_cost` decimal(10,2) NOT NULL DEFAULT '0.00',
  `labor_cost` decimal(10,2) NOT NULL DEFAULT '0.00',
  `freight_cost` decimal(10,2) DEFAULT '0.00',
  `stdMaterialCost` decimal(10,2) DEFAULT '0.00',
  `stdLaborCost` decimal(10,2) DEFAULT '0.00',
  `laborVariance` decimal(10,2) DEFAULT '0.00',
  `materialVariance` decimal(10,2) DEFAULT '0.00',
  `constant` varchar(45) DEFAULT 'Variance',
  `totalActual` decimal(10,2) DEFAULT '0.00',
  `totalStandard` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (1,'Engine','003-1345',800.50,120.00,40.00,900.00,90.00,30.00,-99.50,'Variance',960.50,220.00),(2,'Axle','001-2023',600.00,40.00,50.00,550.00,35.00,5.00,50.00,'Variance',690.00,120.00),(3,'Exhaust','044-2345',100.30,15.00,2.50,90.00,5.00,10.00,10.30,'Variance',117.80,12.50),(4,'Strut','045-0023',125.34,40.00,30.00,100.00,25.00,15.00,25.34,'Variance',195.34,80.00),(5,'Rear Wheel','033-2343',2500.00,45.00,100.00,2200.00,23.00,22.00,300.00,'Variance',2645.00,146.00),(6,'Front Wheel','2200.00',2000.00,200.00,45.00,1900.23,210.00,-10.00,99.77,'Variance',2245.00,465.00);
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-24 15:37:13
