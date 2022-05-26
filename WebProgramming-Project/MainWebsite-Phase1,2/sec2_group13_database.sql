-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: proj_sql
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content` (
  `content_ID` int NOT NULL,
  `content_title` varchar(500) NOT NULL,
  `content_pic` varchar(3000) DEFAULT NULL,
  `content_descri` varchar(3000) NOT NULL,
  PRIMARY KEY (`content_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (1,'The Most Anticipated New Movies to Watch in 2022',NULL,'Get your Watchlists ready and start planning your new year, because we are running down the new movies IMDb fans can not wait to watch in 2022. Marvel and DC fans can rejoice as beloved superheroes from both universes will make their return to the big screen: Chris Hemsworth as the God of Thunder in \"Thor\": Love and Thunder\" and Robert Pattison as the latest Caped Crusader in \"The Batman.\" For action-packed adventure and a double dose of Tom Cruise, 2022 has you covered with \"Mission: Impossible 7\" and \"Top Gun: Maverick.\" What movies are you most anticipating?'),(2,'New Holiday Movies, Shows, and Specials to Stream in 2021',NULL,'Start a new tradition with these streaming recommendations for the season. Step under the mistletoe for some romance with \"Single All the Way\" and \"Love Hard.\" Then gather around the table with Padma Lakshmi in \"Taste the Nation: Holiday Edition.\" If you are feeling nostalgic, stream \"8-Bit Christmas.\" To delight the whole family, unwrap \"Snoopy Presents: For Auld Lang Syne\" or the snowy adventure of \"A Boy Called Christmas.\" Finally, when all is neither calm nor bright, stream the holiday horror \"Silent Night.\"'),(3,'6 Standout Scenes From First-Time Oscar Nominees',NULL,'Get ready for Hollywood`s biggest night by taking a look back at six must-see scenes featuring some of this year`s first-time Oscar nominees. Whether it`s Aunjanue Ellis in `King Richard,` Kirsten Dunst and Kodi Smit-Mcphee in `The Power of the Dog,` Jessie Buckley in `The Lost Daughter,` Ariana DeBose in `West Side Story,` Troy Kotsur in `CODA,` or Kristen Stewart in `Spencer,` you won`t want to miss these shining performances that highlighted the year in film. Which are your favorites?'),(4,'What to Watch After `Hamilton`',NULL,'Once you`ve memorized all the lyrics to Lin-Manuel Miranda`s hit Broadway musical on Disney+, check out these TV shows and movies to enhance your `Hamilton` experience.'),(5,'Best Moments from the Oscars 2022 Telecast [With Captions]',NULL,'Get a captioned recap of the funniest moments, most surprising speeches, and more highlights from the 2022 Academy Awards.'),(6,'All About Troy Kotsur',NULL,'Troy Kotsur broke out with his Oscar-winning role in `CODA,` but have you seen him on Disney`s \"The Mandalorian\"? Check out this behind-the-scenes peek at his career highlights.');
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL,
  `movie_title` varchar(500) NOT NULL,
  `movie_pic` varchar(3000) NOT NULL,
  `genre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'The Last Witch Hunter','https://images-fe.ssl-images-amazon.com/images/S/pv-target-images/be6c0738cb77f21154e9a0e1ae3bd6a72cc6944c29af07a1ebbdbbda30b8774d._V_SX300_.jpg','Action, Thriller, Horror'),(2,'After','https://us.v-cdn.net/6030983/uploads/UT30ZJV96BMW/image.png','Mystery, Action'),(3,'Die Hard','https://i.ebayimg.com/images/g/8aMAAOSw7Qdga52w/s-l1600.jpg','Action, Thriller, Romance'),(4,'Us','https://i.pinimg.com/564x/fc/33/67/fc3367ff7d2d7d9fc777dcb2a2da15f4.jpg','Horror, Mystery, Atmospheric'),(5,'The Informers','https://m.media-amazon.com/images/M/MV5BMTg2MDEzMDQxOV5BMl5BanBnXkFtZTcwMzcxMTA0Mg@@._V1_.jpg','Animation, Adventure, Action');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin_flag` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Taiyo','0990461117',1),(2,'Mhoomind','yoyo2544',1),(3,'BeBuilt','bb112233',0),(4,'Ackerping','pingping123',0),(5,'Kaowtum','boom0872456398',1),(6,'Poko','25450402',1),(7,'Peddep','029114716',1),(8,'DdayTawan','tawan08',0),(9,'Bankbank','09062545',0),(10,'Buasuwank','0891265911',1);
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

-- Dump completed on 2022-04-25  5:50:21
