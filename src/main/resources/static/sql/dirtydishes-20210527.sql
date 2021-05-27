-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: dirtydishes
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3),(3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `ingredientname` varchar(32) NOT NULL,
  `ingredientdescription` varchar(255) DEFAULT NULL,
  `ingredienttype` enum('grain','meat') NOT NULL,
  `ingredientrecipeid` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ingredientname` (`ingredientname`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Chinese fermented red bean curd',NULL,'grain',NULL),(2,'maltose or honey',NULL,'grain',NULL),(3,'Chinese Shaoxing wine',NULL,'grain',NULL),(4,'soy sauce',NULL,'grain',NULL),(5,'oyster sauce',NULL,'grain',NULL),(6,'dark and thick soy sauce',NULL,'grain',NULL),(7,'five-spice powder',NULL,'grain',NULL),(8,'white pepper powder',NULL,'grain',NULL),(9,'sugar',NULL,'grain',NULL),(10,'Char Siu Sauce',NULL,'grain',1),(11,'skinless pork belly',NULL,'grain',NULL),(12,'garlic',NULL,'grain',NULL);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int NOT NULL,
  `employer` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `skill` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `version` varchar(10) DEFAULT NULL,
  `author` varchar(32) DEFAULT 'Anthony Redmond',
  `serveqty` int DEFAULT NULL,
  `serveqtytype` enum('people','adults','children','infants') DEFAULT NULL,
  `preptime` int DEFAULT NULL,
  `cooktime` int DEFAULT NULL,
  `portion` varchar(10) DEFAULT NULL,
  `portionuom` varchar(10) DEFAULT NULL,
  `cook_time` int DEFAULT NULL,
  `prep_time` int DEFAULT NULL,
  `serve_qty` int DEFAULT NULL,
  `serve_qty_type` varchar(255) DEFAULT NULL,
  `description` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `recipetitleandauthor` (`title`,`version`,`author`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'Char Siu Sauce','1','Anthony Redmond',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Pork Belly Char Siu ','1','Anthony Redmond',3,'people',15,30,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipeingredient`
--

DROP TABLE IF EXISTS `recipeingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipeingredient` (
  `recipeid` int unsigned NOT NULL,
  `ingredientline` int unsigned NOT NULL,
  `ingredientid` int unsigned NOT NULL AUTO_INCREMENT,
  `qty` varchar(10) NOT NULL,
  `uom` varchar(15) DEFAULT NULL,
  `instruction` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ingredientid`),
  UNIQUE KEY `recipeingredient` (`recipeid`,`ingredientid`),
  UNIQUE KEY `recipeingredientline` (`recipeid`,`ingredientline`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipeingredient`
--

LOCK TABLES `recipeingredient` WRITE;
/*!40000 ALTER TABLE `recipeingredient` DISABLE KEYS */;
INSERT INTO `recipeingredient` VALUES (1,1,1,'2','pieces',NULL),(1,2,2,'1','tablespoon',NULL),(1,3,3,'1','tablespoon',NULL),(1,4,4,'1','tablespoon',NULL),(1,5,5,'1','tablespoon',NULL),(1,6,6,'1','teaspoon',NULL),(1,7,7,'1','teaspoon',NULL),(1,8,8,'1/4','teaspoon',NULL),(1,9,9,'3 1/25','oz',NULL),(2,3,10,'8','tablespoon','freshly made'),(2,1,11,'1','lb','cut into 2 long strips'),(2,2,12,'2','tablespoons','finely chopped');
/*!40000 ALTER TABLE `recipeingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `pw_hash` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$GPM8yTc3zbvbwyqJUS4swOBtr01FSdJm1Nrn50Pq6nawJ/WHURUOO','Jermaine',''),(2,'$2a$10$UI/rdKK7i/vbbkMIA1h5LOLNlZSxCPCTLpwRIETpgvD5GKFsR3.um','MoX','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-27 12:15:03
