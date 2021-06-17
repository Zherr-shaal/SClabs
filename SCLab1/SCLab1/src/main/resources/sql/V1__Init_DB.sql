-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: sclab1
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `business_credit`
--

DROP TABLE IF EXISTS `business_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `business_credit` (
  `id_credit` int NOT NULL AUTO_INCREMENT,
  `id_organization` int DEFAULT NULL,
  `credit_sum` int DEFAULT NULL,
  `credit_term` int DEFAULT NULL,
  `credit_type` varchar(45) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `percent` int DEFAULT NULL,
  PRIMARY KEY (`id_credit`),
  KEY `orgcredit_idx` (`id_organization`),
  CONSTRAINT `orgcredit` FOREIGN KEY (`id_organization`) REFERENCES `organization` (`id_organization`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_credit`
--



--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `id_card` int NOT NULL AUTO_INCREMENT,
  `id_person` int DEFAULT NULL,
  `id_type` int DEFAULT NULL,
  `sum` int DEFAULT NULL,
  `number` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id_card`),
  KEY `type_idx` (`id_type`),
  KEY `FKqei7ya64q67hob1369uw3j2of` (`id_person`),
  CONSTRAINT `FK5o7f17xih6724f19x6iqu6j6o` FOREIGN KEY (`id_type`) REFERENCES `card_type` (`id_type`),
  CONSTRAINT `FKqei7ya64q67hob1369uw3j2of` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--



--
-- Table structure for table `card_type`
--

DROP TABLE IF EXISTS `card_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_type` (
  `id_type` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_type`
--


--
-- Table structure for table `company_bank_account`
--

DROP TABLE IF EXISTS `company_bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_bank_account` (
  `id_account` int NOT NULL AUTO_INCREMENT,
  `id_organization` int DEFAULT NULL,
  `account_number` varchar(45) DEFAULT NULL,
  `sum` int DEFAULT NULL,
  PRIMARY KEY (`id_account`),
  KEY `account_of_idx` (`id_organization`),
  CONSTRAINT `account_of` FOREIGN KEY (`id_organization`) REFERENCES `organization` (`id_organization`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_bank_account`
--


--
-- Table structure for table `credit`
--

DROP TABLE IF EXISTS `credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit` (
  `id_credit` int NOT NULL AUTO_INCREMENT,
  `credit_sum` int DEFAULT NULL,
  `credit_term` int DEFAULT NULL,
  `credit_type` varchar(45) DEFAULT NULL,
  `percent` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`id_credit`),
  KEY `FKj6621qwel71guoshue60b8h9` (`type_id`),
  CONSTRAINT `FKj6621qwel71guoshue60b8h9` FOREIGN KEY (`type_id`) REFERENCES `time_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit`
--


--
-- Table structure for table `credit_person`
--

DROP TABLE IF EXISTS `credit_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_person` (
  `id_note` int NOT NULL AUTO_INCREMENT,
  `credit_fk` int NOT NULL,
  `person_fk` int NOT NULL,
  PRIMARY KEY (`id_note`),
  KEY `FKamqto49xu0wa5rvu30sqx81o` (`person_fk`),
  KEY `FK4pilvx6lauayas07swx2minq` (`credit_fk`),
  CONSTRAINT `FK4pilvx6lauayas07swx2minq` FOREIGN KEY (`credit_fk`) REFERENCES `credit` (`id_credit`),
  CONSTRAINT `FKamqto49xu0wa5rvu30sqx81o` FOREIGN KEY (`person_fk`) REFERENCES `person` (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_person`
--


--
-- Table structure for table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deposit` (
  `id_deposit` int NOT NULL AUTO_INCREMENT,
  `id_person` int DEFAULT NULL,
  `deposit_sum` int DEFAULT NULL,
  `deposit_term` int DEFAULT NULL,
  `deposit_type` varchar(45) DEFAULT NULL,
  `percent` int DEFAULT NULL,
  PRIMARY KEY (`id_deposit`),
  KEY `person_deposit_idx` (`id_person`),
  CONSTRAINT `person_deposit` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit`

--
-- Table structure for table `manger`
--

DROP TABLE IF EXISTS `manger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manger` (
  `id_manager` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_manager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manger`
--



--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `id_organization` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Owner` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`id_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--



--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id_person` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Surname` varchar(45) DEFAULT NULL,
  `Patronymic` varchar(45) DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Birth_date` date DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `addres` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--


--
-- Table structure for table `time_type`
--

DROP TABLE IF EXISTS `time_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_type`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-16 21:03:49
