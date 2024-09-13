-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: db_lista_cuadros
-- ------------------------------------------------------
-- Server version	9.0.0

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
-- Table structure for table `cuadros`
--

DROP TABLE IF EXISTS `cuadros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuadros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `altura` int unsigned NOT NULL,
  `anchura` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuadros`
--

LOCK TABLES `cuadros` WRITE;
/*!40000 ALTER TABLE `cuadros` DISABLE KEYS */;
INSERT INTO `cuadros` VALUES (12,'Otoño Dorado',110,85),(13,'Figura en el Viento',105,80),(14,'Montaña Sagrada',115,95),(15,'Océano Profundo',130,85),(16,'Luz del Crepúsculo',140,90),(17,'Tierra de Sueños',125,100),(18,'Silencio en el Bosque',135,105),(19,'Ríos de Plata',90,70),(20,'Ventana al Pasado',105,75),(21,'Corazón de la Selva',125,95),(22,'Armonía Natural',100,65),(23,'Estrella Fugaz',115,80),(24,'Luces en la Ciudad',120,100),(25,'Misterios del Desierto',130,75),(26,'Noche Estrellada',90,60),(27,'Reflejo del Alma',110,70),(28,'Despertar del Día',95,85),(29,'Caminos Cruzados',105,65),(30,'Jardín Secreto',100,80),(31,'Luz y Sombra',115,90),(32,'Paz Interior',130,100),(33,'Amanecer Dorado',125,85),(34,'Bosque Encantado',140,95),(35,'Mares Tranquilos',135,70),(36,'Raíces del Tiempo',105,60),(37,'Cielo Abierto',95,55),(38,'Mirada Profunda',120,75),(39,'Ecos del Pasado',110,85),(40,'Fantasía Nocturna',140,80),(41,'Sueños de Verano',125,90),(42,'Ventana a lo Eterno',130,100),(43,'Caminos Perdidos',115,70),(44,'Danza en el Cielo',105,60),(45,'Tiempos de Paz',120,85),(46,'Jardín de Rosas',90,65),(47,'Colores de Otoño',130,95),(48,'Montañas Lejanas',135,85),(49,'Reflejos del Atardecer',110,75),(50,'El Gran Azul',140,100),(51,'Olas Silenciosas',120,80),(52,'Primavera en Flor',125,90),(53,'Horizontes Infinito',110,70),(54,'Serenidad del Lago',100,65),(56,'Amanecer en el Mar',140,75),(57,'Siluetas del Alba',115,60),(58,'Cumbre del Silencio',105,80),(59,'Vuelo Nocturno',130,90),(60,'Ventanas de Luz',125,100),(61,'Tardes Doradas',135,95),(62,'Río de Estrellas',120,85),(63,'Puente al Futuro',100,75),(64,'Bajo las Nubes',110,70),(65,'Bosque Mágico',130,80),(66,'Paisaje Invernal',140,90),(67,'Colinas Verdes',125,95),(68,'Sol de Medianoche',105,65),(69,'Cielo de Fuego',115,75),(70,'Campos de Lavanda',90,60),(71,'Reflejos de la Luna',120,100),(72,'Noche de Invierno',130,85),(73,'Sueños del Bosque',135,70),(74,'Puerta al Infinito',100,55),(75,'Montañas Nevadas',140,95),(76,'Tiempos Antiguos',125,85),(77,'Horizonte Lejano',115,90),(78,'Aurora Boreal',110,80),(79,'Ríos Tranquilos',120,65),(80,'Luz del Norte',130,75),(81,'Campos Dorados',135,105),(82,'Mar de Nubes',125,70),(83,'Cumbre Nevada',140,85),(84,'Aguas Calmadas',105,60),(85,'Sombras del Pasado',115,80),(86,'Ventana al Cielo',130,90),(87,'Caminos Olvidados',120,75),(88,'Luz y Naturaleza',135,95),(89,'Misterios del Mar',125,85),(90,'Montañas del Sur',140,100),(91,'Atardecer Dorado',110,70),(92,'Ríos de Oro',130,80),(93,'Campos de Oro',125,60),(94,'Sombra en el Mar',115,85),(95,'Horizonte Perdido',140,75),(96,'Noche estrellada',300,500),(142,'wertewrtrewt',2,33),(157,'AsteNagusia',2,1),(158,'',0,0),(159,'El bosco',123,321),(161,'lunes',1111,1111);
/*!40000 ALTER TABLE `cuadros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-13 10:19:24
