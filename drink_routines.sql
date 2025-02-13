CREATE DATABASE  IF NOT EXISTS `drink` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `drink`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: drink
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `allmember`
--

DROP TABLE IF EXISTS `allmember`;
/*!50001 DROP VIEW IF EXISTS `allmember`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allmember` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `username`,
 1 AS `password`,
 1 AS `gender`,
 1 AS `age`,
 1 AS `address`,
 1 AS `mobile`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `allguest`
--

DROP TABLE IF EXISTS `allguest`;
/*!50001 DROP VIEW IF EXISTS `allguest`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allguest` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `username`,
 1 AS `password`,
 1 AS `gender`,
 1 AS `age`,
 1 AS `address`,
 1 AS `mobile`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `allmember`
--

/*!50001 DROP VIEW IF EXISTS `allmember`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allmember` AS select `member`.`id` AS `id`,`member`.`name` AS `name`,`member`.`username` AS `username`,`member`.`password` AS `password`,`member`.`gender` AS `gender`,`member`.`age` AS `age`,`member`.`address` AS `address`,`member`.`mobile` AS `mobile` from `member` union all select `vipmember`.`id` AS `id`,`vipmember`.`name` AS `name`,`vipmember`.`username` AS `username`,`vipmember`.`password` AS `password`,`vipmember`.`gender` AS `gender`,`vipmember`.`age` AS `age`,`vipmember`.`address` AS `address`,`vipmember`.`mobile` AS `mobile` from `vipmember` union all select `employee`.`id` AS `id`,`employee`.`name` AS `name`,`employee`.`username` AS `username`,`employee`.`password` AS `password`,`employee`.`gender` AS `gender`,`employee`.`age` AS `age`,`employee`.`address` AS `address`,`employee`.`mobile` AS `mobile` from `employee` union all select `superuser`.`id` AS `id`,`superuser`.`name` AS `name`,`superuser`.`username` AS `username`,`superuser`.`password` AS `password`,`superuser`.`gender` AS `gender`,`superuser`.`age` AS `age`,`superuser`.`address` AS `address`,`superuser`.`mobile` AS `mobile` from `superuser` order by `id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `allguest`
--

/*!50001 DROP VIEW IF EXISTS `allguest`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allguest` AS select `member`.`id` AS `id`,`member`.`name` AS `name`,`member`.`username` AS `username`,`member`.`password` AS `password`,`member`.`gender` AS `gender`,`member`.`age` AS `age`,`member`.`address` AS `address`,`member`.`mobile` AS `mobile` from `member` union all select `vipmember`.`id` AS `id`,`vipmember`.`name` AS `name`,`vipmember`.`username` AS `username`,`vipmember`.`password` AS `password`,`vipmember`.`gender` AS `gender`,`vipmember`.`age` AS `age`,`vipmember`.`address` AS `address`,`vipmember`.`mobile` AS `mobile` from `vipmember` order by `id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-13 16:37:15
