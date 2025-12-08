-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_catalog
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_actors_full_name` (`full_name`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors` VALUES (1,'Том Генкс',_binary '\0'),(2,'Тім Аллен',_binary '\0'),(3,'Дон Ріклз',_binary '\0'),(4,'Альберт Брукс',_binary '\0'),(5,'Еллен Дедженерес',_binary '\0'),(6,'Александр Ґоулд',_binary '\0'),(7,'Майк Маєрс',_binary '\0'),(8,'Едді Мерфі',_binary '\0'),(9,'Камерон Діас',_binary '\0'),(10,'Роуен Аткінсон',_binary '\0'),(11,'Меттью Бродерік',_binary '\0'),(12,'Нікета Каламе-Гарріс',_binary '\0'),(13,'Крістен Белл',_binary '\0'),(14,'Ідіна Мензел',_binary '\0'),(15,'Джонатан Ґрофф',_binary '\0'),(16,'Аулії Кравальйо',_binary '\0'),(17,'Двейн Джонсон',_binary '\0'),(18,'Рейчел Хаус',_binary '\0'),(19,'Джинніфер Ґудвін',_binary '\0'),(20,'Джейсон Бейтман',_binary '\0'),(21,'Ідріс Ельба',_binary '\0'),(22,'Едвард Аснер',_binary '\0'),(23,'Джордан Наґаї',_binary '\0'),(24,'Джон Ратценберґер',_binary '\0'),(25,'Емі Полер',_binary '\0'),(26,'Філліс Сміт',_binary '\0'),(27,'Річард Кайнд',_binary '\0'),(28,'Ентоні Ґонсалес',_binary '\0'),(29,'Ґаель Ґарсія Берналь',_binary '\0'),(30,'Бенджамін Бретт',_binary '\0'),(31,'Джек Блек',_binary '\0'),(32,'Іен Макшейн',_binary '\0'),(33,'Анджеліна Джолі',_binary '\0'),(34,'Джей Барушель',_binary '\0'),(35,'Джерард Батлер',_binary '\0'),(36,'Крістофер Мінц-Пласс',_binary '\0'),(37,'Бен Бертт',_binary '\0'),(38,'Елісса Найт',_binary '\0'),(39,'Джефф Ґарлін',_binary '\0'),(40,'Бред Ґарретт',_binary '\0'),(41,'Лу Романо',_binary '\0'),(42,'Паттон Освальт',_binary '\0'),(43,'Румі Хііраґі',_binary '\0'),(44,'Мію Іріно',_binary '\0'),(45,'Марі Нацукі',_binary '\0'),(46,'Йоджі Мацуґа',_binary '\0'),(47,'Юріко Ішіда',_binary '\0'),(48,'Юко Танака',_binary '\0'),(49,'Крейґ Т. Нельсон',_binary '\0'),(50,'Семюел Л. Джексон',_binary '\0'),(51,'Голлі Гантер',_binary '\0'),(52,'Раян Поттер',_binary '\0'),(53,'Скотт Едсіт',_binary '\0'),(54,'Джеймі Чунґ',_binary '\0'),(55,'Стів Карелл',_binary '\0'),(56,'Джейсон Сіґел',_binary '\0'),(57,'Рассел Бранд',_binary '\0'),(58,'Елай Марієнтал',_binary '\0'),(59,'Гаррі Коннік-молодший',_binary '\0'),(60,'Дженніфер Еністон',_binary '\0'),(61,'Тім Роббінс',_binary '\0'),(62,'Морган Фрімен',_binary '\0'),(63,'Боб Гантон',_binary '\0'),(64,'Марлон Брандо',_binary '\0'),(65,'Аль Пачіно',_binary '\0'),(66,'Джеймс Каан',_binary '\0'),(67,'Крістіан Бейл',_binary '\0'),(68,'Гіт Леджер',_binary '\0'),(69,'Аарон Екгарт',_binary '\0'),(70,'Джон Траволта',_binary '\0'),(71,'Ума Турман',_binary '\0'),(72,'Леонардо Ді Капріо',_binary '\0'),(73,'Джозеф Гордон-Левітт',_binary '\0'),(74,'Елліот Пейдж',_binary '\0'),(75,'Едвард Нортон',_binary '\0'),(76,'Бред Пітт',_binary '\0'),(77,'Міт Лоуф',_binary '\0'),(78,'Робін Райт',_binary '\0'),(79,'Ґері Сініс',_binary '\0'),(80,'Кіану Рівз',_binary '\0'),(81,'Лоренс Фішберн',_binary '\0'),(82,'Керрі-Енн Мосс',_binary '\0'),(83,'Меттью МакКонахі',_binary '\0'),(84,'Енн Гетевей',_binary '\0'),(85,'Джессіка Честейн',_binary '\0'),(86,'Рассел Кроу',_binary '\0'),(87,'Гоакін Фенікс',_binary '\0'),(88,'Конні Нільсен',_binary '\0'),(89,'Кейт Вінслет',_binary '\0'),(90,'Біллі Зейн',_binary '\0'),(91,'Елайджа Вуд',_binary '\0'),(92,'Віґґо Мортенсен',_binary '\0'),(93,'Ієн Маккеллен',_binary '\0'),(94,'Г\'ю Джекман',_binary '\0'),(95,'Скарлетт Йоганссон',_binary '\0'),(96,'Джеймі Фокс',_binary '\0'),(97,'Крістоф Вальц',_binary '\0'),(98,'Метт Деймон',_binary '\0'),(99,'Джек Ніколсон',_binary '\0'),(100,'Майлз Теллер',_binary '\0'),(101,'Дж. К. Сіммонс',_binary '\0'),(102,'Мелісса Бенуа',_binary '\0'),(103,'Том Гарді',_binary '\0'),(104,'Шарліз Терон',_binary '\0'),(105,'Ніколас Голт',_binary '\0'),(106,'Джессі Айзенберґ',_binary '\0'),(107,'Ендрю Гарфілд',_binary '\0'),(108,'Джастін Тімберлейк',_binary '\0'),(109,'Кевін Спейсі',_binary '\0'),(110,'Майкл Кларк Дункан',_binary '\0'),(111,'Девід Морс',_binary '\0'),(112,'Bryan Cranston',_binary '\0'),(113,'Aaron Paul',_binary '\0'),(114,'Anna Gunn',_binary '\0'),(115,'Peter Dinklage',_binary '\0'),(116,'Kit Harington',_binary '\0'),(117,'Emilia Clarke',_binary '\0'),(118,'Henry Cavill',_binary '\0'),(119,'Anya Chalotra',_binary '\0'),(120,'Freya Allan',_binary '\0'),(121,'Winona Ryder',_binary '\0'),(122,'David Harbour',_binary '\0'),(123,'Millie Bobby Brown',_binary '\0'),(124,'Andrew Lincoln',_binary '\0'),(125,'Norman Reedus',_binary '\0'),(126,'Melissa McBride',_binary '\0'),(127,'Pedro Pascal',_binary '\0'),(128,'Bella Ramsey',_binary '\0'),(129,'Gabriel Luna',_binary '\0'),(130,'Benedict Cumberbatch',_binary '\0'),(131,'Martin Freeman',_binary '\0'),(132,'Una Stubbs',_binary '\0'),(133,'Matthew McConaughey',_binary '\0'),(134,'Woody Harrelson',_binary '\0'),(135,'Mahershala Ali',_binary '\0'),(136,'Karl Urban',_binary '\0'),(137,'Antony Starr',_binary '\0'),(138,'Jack Quaid',_binary '\0'),(139,'Travis Fimmel',_binary '\0'),(140,'Katheryn Winnick',_binary '\0'),(141,'Gustaf Skarsgård',_binary '\0'),(142,'Бенедикт Камбербетч',_binary '\0'),(143,'Мартін Фрімен',_binary '\0'),(144,'Юна Стаббс',_binary '\0'),(145,'Меттью МакКонегі',_binary '\0'),(146,'Колін Фаррелл',_binary '\0'),(147,'Магершала Алі',_binary '\0'),(148,'Карл Урбан',_binary '\0'),(149,'Джек Квейд',_binary '\0'),(150,'Ентоні Старр',_binary '\0'),(151,'Кетрін Винник',_binary '\0'),(152,'Густаф Скарсгард',_binary '\0'),(153,'Александер Людвіг',_binary '\0'),(154,'Кілліан Мерфі',_binary '\0'),(155,'Пол Андерсон',_binary '\0'),(156,'Софі Рандл',_binary '\0'),(157,'Педро Паскаль',_binary '\0'),(158,'Кріс Бартлетт',_binary '\0'),(159,'Кейті Сакхофф',_binary '\0'),(160,'Еван Рейчел Вуд',_binary '\0'),(161,'Тендіве Ньютон',_binary '\0'),(162,'Джеффрі Райт',_binary '\0'),(163,'Метт Сміт',_binary '\0'),(164,'Емма Д’Арсі',_binary '\0'),(165,'Олівія Кук',_binary '\0');
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_countries_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (20,'Canada'),(19,'Hungary'),(21,'Ireland'),(18,'Poland'),(17,'United Kingdom'),(16,'United States'),(3,'Австралія'),(7,'Велика Британія'),(15,'Гонконг'),(22,'Ірландія'),(11,'Канада'),(5,'Китай'),(12,'Мальта'),(13,'Марокко'),(4,'Мексика'),(10,'Німеччина'),(14,'Нова Зеландія'),(6,'Росія'),(1,'США'),(8,'Франція'),(9,'Чехія'),(2,'Японія');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('create-actors-v1','vadym','db/changelog/schema/001-actors/001-actors-create.yaml','2025-12-03 12:18:59',1,'EXECUTED','9:8b13d28c3cba8600762134c5f0b1a8c1','createTable tableName=actors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-actors-full_name','vadym','db/changelog/schema/001-actors/001-actors-indexes.yaml','2025-12-03 12:18:59',2,'EXECUTED','9:0d70b41f6a3719a702d94ad74eba13e3','addUniqueConstraint constraintName=uk_actors_full_name, tableName=actors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-countries-v1','vadym','db/changelog/schema/002-countries/002-countries-create.yaml','2025-12-03 12:18:59',3,'EXECUTED','9:76a43cf5fe49d635ecac8fb0734eb891','createTable tableName=countries','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-countries-name','vadym','db/changelog/schema/002-countries/002-countries-indexes.yaml','2025-12-03 12:18:59',4,'EXECUTED','9:665185f3a8a8390b76e3bfb215a0e557','addUniqueConstraint constraintName=uk_countries_name, tableName=countries','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-directors-v1','vadym','db/changelog/schema/003-directors/003-directors-create.yaml','2025-12-03 12:18:59',5,'EXECUTED','9:2c61a627b32443b43e9aaa671100b2d6','createTable tableName=directors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-directors-full_name','vadym','db/changelog/schema/003-directors/003-directors-indexes.yaml','2025-12-03 12:18:59',6,'EXECUTED','9:6d19ee1ce7238da6db67c66fb961334f','addUniqueConstraint constraintName=uk_directors_full_name, tableName=directors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-genres-v1','vadym','db/changelog/schema/004-genres/004-genres-create.yaml','2025-12-03 12:18:59',7,'EXECUTED','9:71220c445e8f7ff2a2356ac9e7d886ec','createTable tableName=genres','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-genres-name','vadym','db/changelog/schema/004-genres/004-genres-indexes.yaml','2025-12-03 12:18:59',8,'EXECUTED','9:1daa91d9cd276cdc1d10254af9a3f3be','addUniqueConstraint constraintName=uk_genres_name, tableName=genres','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-roles-v1','vadym','db/changelog/schema/005-roles/005-roles-create.yaml','2025-12-03 12:18:59',9,'EXECUTED','9:bccb0fe77f4ff7d4aace8727092a3a2b','createTable tableName=roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-roles-name','vadym','db/changelog/schema/005-roles/005-roles-indexes.yaml','2025-12-03 12:18:59',10,'EXECUTED','9:3b4c061be8312125e810cd5a12f4d98e','addUniqueConstraint constraintName=uk_roles_name, tableName=roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-users-v1','vadym','db/changelog/schema/006-users/006-users-create.yaml','2025-12-03 12:18:59',11,'EXECUTED','9:8753a8a29db9a35d527d79069df8f51a','createTable tableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-users-email','vadym','db/changelog/schema/006-users/006-users-indexes.yaml','2025-12-03 12:18:59',12,'EXECUTED','9:03275f1b632182a8439b1c93172d3f73','addUniqueConstraint constraintName=uk_users_email, tableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-users-nickname','vadym','db/changelog/schema/006-users/006-users-indexes.yaml','2025-12-03 12:18:59',13,'EXECUTED','9:edb1a929d05059c63aef81b5ea2d42d1','addUniqueConstraint constraintName=uk_users_nickname, tableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('update-users-v2','vadym','db/changelog/schema/006-users/006-users-updates.yaml','2025-12-03 12:18:59',14,'EXECUTED','9:786ae0c4386b3239d0a7de14390b5be8','addColumn tableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-movies-v1','vadym','db/changelog/schema/007-movies/007-movies-create.yaml','2025-12-03 12:18:59',15,'EXECUTED','9:50c0a5830a85937968d619eef5d56cd8','createTable tableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movies-title','vadym','db/changelog/schema/007-movies/007-movies-indexes.yaml','2025-12-03 12:18:59',16,'EXECUTED','9:c9825efe8cb243ae0d0e4459d623cada','createIndex indexName=idx_movies_title, tableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movies-release_year','vadym','db/changelog/schema/007-movies/007-movies-indexes.yaml','2025-12-03 12:19:00',17,'EXECUTED','9:17562b9b4ca351d34b507a602a7be7be','createIndex indexName=idx_movies_release_year, tableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('uc-movies-title','vadym','db/changelog/schema/007-movies/007v1-add-unique-movie-title.yaml','2025-12-03 12:19:00',18,'EXECUTED','9:4d4c2a4747e9469d4b11f938f3ce9a8b','addUniqueConstraint constraintName=uc_movies_title_unique, tableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-wishlists-v1','vadym','db/changelog/schema/008-wishlists/008-wishlists-create.yaml','2025-12-03 12:19:00',19,'EXECUTED','9:66ec96dd2d64762d34576625511be09b','createTable tableName=wishlists','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-wishlists-users','vadym','db/changelog/schema/008-wishlists/008-wishlists-fks.yaml','2025-12-03 12:19:00',20,'EXECUTED','9:c4f3ebc35c16e6a89e8904c05188cd08','addForeignKeyConstraint baseTableName=wishlists, constraintName=fk_wishlists_users, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-wishlists-user_id','vadym','db/changelog/schema/008-wishlists/008-wishlists-indexes.yaml','2025-12-03 12:19:00',21,'EXECUTED','9:da02664b60178fd74904dabe853dc34b','addUniqueConstraint constraintName=uk_wishlists_user_id, tableName=wishlists','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-wishlist_items-v1','vadym','db/changelog/schema/009-wishlist_items/009-wishlist_items-create.yaml','2025-12-03 12:19:00',22,'EXECUTED','9:fd77de7dadaab4e25cbf895b72953df0','createTable tableName=wishlist_items','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-wishlist_items-movies','vadym','db/changelog/schema/009-wishlist_items/009-wishlist_items-fks.yaml','2025-12-03 12:19:00',23,'EXECUTED','9:52dd8d2eae2a669dc299988f26d25ad0','addForeignKeyConstraint baseTableName=wishlist_items, constraintName=fk_wishlist_items_movie, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-wishlist_items-wishlists','vadym','db/changelog/schema/009-wishlist_items/009-wishlist_items-fks.yaml','2025-12-03 12:19:00',24,'EXECUTED','9:ef15f3cf48b2b205309689077e367be4','addForeignKeyConstraint baseTableName=wishlist_items, constraintName=fk_wishlist_items_wishlist, referencedTableName=wishlists','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-wishlist_items-wishlist-movie','vadym','db/changelog/schema/009-wishlist_items/009-wishlist_items-indexes.yaml','2025-12-03 12:19:00',25,'EXECUTED','9:591ecf16a808792a0d8f5c9d171a3171','addUniqueConstraint constraintName=uk_wishlist_items_wishlist_movie, tableName=wishlist_items','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-wishlist_items-movie_id','vadym','db/changelog/schema/009-wishlist_items/009-wishlist_items-indexes.yaml','2025-12-03 12:19:00',26,'EXECUTED','9:f9e27e6904109de6dfdad8b06c9b556b','createIndex indexName=idx_wishlist_items_movie_id, tableName=wishlist_items','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-reviews-v1','vadym','db/changelog/schema/010-reviews/010-reviews-create.yaml','2025-12-03 12:19:00',27,'EXECUTED','9:3c67d17c129822b22ce86c05849926f5','createTable tableName=reviews','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-reviews-movies','vadym','db/changelog/schema/010-reviews/010-reviews-fks.yaml','2025-12-03 12:19:00',28,'EXECUTED','9:27f23a6be926c818812241b01d085de2','addForeignKeyConstraint baseTableName=reviews, constraintName=fk_reviews_movies, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-reviews-users','vadym','db/changelog/schema/010-reviews/010-reviews-fks.yaml','2025-12-03 12:19:00',29,'EXECUTED','9:8b759aec8fa42ef1535c031850e50b91','addForeignKeyConstraint baseTableName=reviews, constraintName=fk_reviews_users, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-reviews-movie_id','vadym','db/changelog/schema/010-reviews/010-reviews-indexes.yaml','2025-12-03 12:19:00',30,'EXECUTED','9:0fc37c7b76390657746af2fdf2eeef3f','createIndex indexName=idx_reviews_movie_id, tableName=reviews','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-reviews-user_id','vadym','db/changelog/schema/010-reviews/010-reviews-indexes.yaml','2025-12-03 12:19:00',31,'EXECUTED','9:619da05e4b9a0479d6083632d792bc64','createIndex indexName=idx_reviews_user_id, tableName=reviews','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-review_comments-v1','vadym','db/changelog/schema/011-review_comments/011-review_comments-create.yaml','2025-12-03 12:19:00',32,'EXECUTED','9:aa6f040c7811f03e57a6222ad064b000','createTable tableName=review_comments','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-review_comments-parent','vadym','db/changelog/schema/011-review_comments/011-review_comments-fks.yaml','2025-12-03 12:19:00',33,'EXECUTED','9:897f793dc57bf1faa657971b394c2ba4','addForeignKeyConstraint baseTableName=review_comments, constraintName=fk_review_comments_parent, referencedTableName=review_comments','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-review_comments-reviews','vadym','db/changelog/schema/011-review_comments/011-review_comments-fks.yaml','2025-12-03 12:19:00',34,'EXECUTED','9:9e706530e591acbc5ffa2f6f1d0dd446','addForeignKeyConstraint baseTableName=review_comments, constraintName=fk_review_comments_review, referencedTableName=reviews','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-review_comments-users','vadym','db/changelog/schema/011-review_comments/011-review_comments-fks.yaml','2025-12-03 12:19:00',35,'EXECUTED','9:f551a109c4f9985a6b20adae5f24a61c','addForeignKeyConstraint baseTableName=review_comments, constraintName=fk_review_comments_user, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-review_comments-review_id','vadym','db/changelog/schema/011-review_comments/011-review_comments-indexes.yaml','2025-12-03 12:19:00',36,'EXECUTED','9:a1f27941fc14c1776c97cb7ca515859d','createIndex indexName=idx_review_comments_review_id, tableName=review_comments','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-review_comments-user_id','vadym','db/changelog/schema/011-review_comments/011-review_comments-indexes.yaml','2025-12-03 12:19:00',37,'EXECUTED','9:23f592fe024aeeef6d67ef4bfe5d98e2','createIndex indexName=idx_review_comments_user_id, tableName=review_comments','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-review_comments-parent_comment_id','vadym','db/changelog/schema/011-review_comments/011-review_comments-indexes.yaml','2025-12-03 12:19:00',38,'EXECUTED','9:4974219f2996e386ee9c0e0aabbb40a2','createIndex indexName=idx_review_comments_parent_comment_id, tableName=review_comments','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-ratings-v1','vadym','db/changelog/schema/012-ratings/012-ratings-create.yaml','2025-12-03 12:19:00',39,'EXECUTED','9:17b7e2cfaea0a0e89c77d55aebb56ff8','createTable tableName=ratings','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-ratings-movies','vadym','db/changelog/schema/012-ratings/012-ratings-fks.yaml','2025-12-03 12:19:00',40,'EXECUTED','9:a4d638b1e7e1518812bf065dfc5fd65b','addForeignKeyConstraint baseTableName=ratings, constraintName=fk_ratings_movies, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-ratings-users','vadym','db/changelog/schema/012-ratings/012-ratings-fks.yaml','2025-12-03 12:19:00',41,'EXECUTED','9:48e7a676d42a317fc31f0ee3dc77ad7d','addForeignKeyConstraint baseTableName=ratings, constraintName=fk_ratings_users, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-ratings-movie-user','vadym','db/changelog/schema/012-ratings/012-ratings-indexes.yaml','2025-12-03 12:19:00',42,'EXECUTED','9:9771125c89fb75ff52d57d36e43f6e3c','addUniqueConstraint constraintName=uk_ratings_movie_user, tableName=ratings','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-ratings-movie_id','vadym','db/changelog/schema/012-ratings/012-ratings-indexes.yaml','2025-12-03 12:19:00',43,'EXECUTED','9:df513e10731e1900ae253a3ee3b59aa9','createIndex indexName=idx_ratings_movie_id, tableName=ratings','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-ratings-user_id','vadym','db/changelog/schema/012-ratings/012-ratings-indexes.yaml','2025-12-03 12:19:00',44,'EXECUTED','9:0966d22f152fb6ba3ac1ddc6399a0302','createIndex indexName=idx_ratings_user_id, tableName=ratings','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-email_verification_token-v1','vadym','db/changelog/schema/013-email_verification_token/013-email_verification_token-create.yaml','2025-12-03 12:19:00',45,'EXECUTED','9:5b056f395ebe1f442381bd82b0395e8c','createTable tableName=email_verification_token','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-email_verification_token-users','vadym','db/changelog/schema/013-email_verification_token/013-email_verification_token-fks.yaml','2025-12-03 12:19:00',46,'EXECUTED','9:799213f2f34c286b2724e6b9fbfd523e','addForeignKeyConstraint baseTableName=email_verification_token, constraintName=fk_email_verification_token_user, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-email_verification_token-token','vadym','db/changelog/schema/013-email_verification_token/013-email_verification_token-indexes.yaml','2025-12-03 12:19:00',47,'EXECUTED','9:2c00af1dba1cbda1122213118374e38d','addUniqueConstraint constraintName=uk_email_verification_token_token, tableName=email_verification_token','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-email_verification_token-user_id','vadym','db/changelog/schema/013-email_verification_token/013-email_verification_token-indexes.yaml','2025-12-03 12:19:00',48,'EXECUTED','9:3cd04f2740be4dcb72f2d959e5da2a4b','createIndex indexName=idx_email_verification_token_user_id, tableName=email_verification_token','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-password_reset_tokens-v1','vadym','db/changelog/schema/014-password_reset_tokens/014-password_reset_tokens-create.yaml','2025-12-03 12:19:00',49,'EXECUTED','9:3a607a65716910c70c405c609f5419e5','createTable tableName=password_reset_tokens','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-password_reset_tokens-users','vadym','db/changelog/schema/014-password_reset_tokens/014-password_reset_tokens-fks.yaml','2025-12-03 12:19:00',50,'EXECUTED','9:00d8e67f1bfb43b6a6070d989f211b89','addForeignKeyConstraint baseTableName=password_reset_tokens, constraintName=fk_password_reset_tokens_users, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-password_reset_tokens-token','vadym','db/changelog/schema/014-password_reset_tokens/014-password_reset_tokens-indexes.yaml','2025-12-03 12:19:00',51,'EXECUTED','9:7666fab514ec4a6479faaa262c2d5794','addUniqueConstraint constraintName=uk_password_reset_tokens_token, tableName=password_reset_tokens','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-password_reset_tokens-user_id','vadym','db/changelog/schema/014-password_reset_tokens/014-password_reset_tokens-indexes.yaml','2025-12-03 12:19:00',52,'EXECUTED','9:ecec56010d3d69f91d48c2e97080f460','createIndex indexName=idx_password_reset_tokens_user_id, tableName=password_reset_tokens','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-movie_actors-v1','vadym','db/changelog/schema/015-movie_actors/015-movie_actors-create.yaml','2025-12-03 12:19:00',53,'EXECUTED','9:8ee0600980b92b71457968e488d92157','createTable tableName=movie_actors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_actors-actors','vadym','db/changelog/schema/015-movie_actors/015-movie_actors-fks.yaml','2025-12-03 12:19:01',54,'EXECUTED','9:520d1f29581606587030f66e14352ec8','addForeignKeyConstraint baseTableName=movie_actors, constraintName=fk_movie_actors_actor, referencedTableName=actors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_actors-movies','vadym','db/changelog/schema/015-movie_actors/015-movie_actors-fks.yaml','2025-12-03 12:19:01',55,'EXECUTED','9:01abbe9340c55aa341e7fb7e795d715d','addForeignKeyConstraint baseTableName=movie_actors, constraintName=fk_movie_actors_movie, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movie_actors-movie-actor','vadym','db/changelog/schema/015-movie_actors/015-movie_actors-indexes.yaml','2025-12-03 12:19:01',56,'EXECUTED','9:3809de5ccb3b665b260d4cdda35e7482','addUniqueConstraint constraintName=uk_movie_actors_movie_actor, tableName=movie_actors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movie_actors-actor_id','vadym','db/changelog/schema/015-movie_actors/015-movie_actors-indexes.yaml','2025-12-03 12:19:01',57,'EXECUTED','9:ef0b5497468e738d7b7201939afa3a55','createIndex indexName=idx_movie_actors_actor_id, tableName=movie_actors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-movie_countries-v1','vadym','db/changelog/schema/016-movie_countries/016-movie_countries-create.yaml','2025-12-03 12:19:01',58,'EXECUTED','9:34d216d7f08a150ba73d77da2ab28714','createTable tableName=movie_countries','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_countries-countries','vadym','db/changelog/schema/016-movie_countries/016-movie_countries-fks.yaml','2025-12-03 12:19:01',59,'EXECUTED','9:40373d80c2f8eb60d3b188bd21eca21a','addForeignKeyConstraint baseTableName=movie_countries, constraintName=fk_movie_countries_country, referencedTableName=countries','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_countries-movies','vadym','db/changelog/schema/016-movie_countries/016-movie_countries-fks.yaml','2025-12-03 12:19:01',60,'EXECUTED','9:7ac7b9df602e530d434784c3f4328b98','addForeignKeyConstraint baseTableName=movie_countries, constraintName=fk_movie_countries_movie, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movie_countries-country_id','vadym','db/changelog/schema/016-movie_countries/016-movie_countries-indexes.yaml','2025-12-03 12:19:01',61,'EXECUTED','9:e1e9e8bcb7a16eb04c7bf84edadcfb3d','createIndex indexName=idx_movie_countries_country_id, tableName=movie_countries','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-movie_directors-v1','vadym','db/changelog/schema/017-movie_directors/017-movie_directors-create.yaml','2025-12-03 12:19:01',62,'EXECUTED','9:3dea84dd0b30b31b00200b5ecd3bb9df','createTable tableName=movie_directors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_directors-directors','vadym','db/changelog/schema/017-movie_directors/017-movie_directors-fks.yaml','2025-12-03 12:19:01',63,'EXECUTED','9:6d515a2f9bd3f125276f40110d10cc51','addForeignKeyConstraint baseTableName=movie_directors, constraintName=fk_movie_directors_director, referencedTableName=directors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_directors-movies','vadym','db/changelog/schema/017-movie_directors/017-movie_directors-fks.yaml','2025-12-03 12:19:01',64,'EXECUTED','9:9593390bcaccc96a2c47bd33845b3db5','addForeignKeyConstraint baseTableName=movie_directors, constraintName=fk_movie_directors_movie, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movie_directors-director_id','vadym','db/changelog/schema/017-movie_directors/017-movie_directors-indexes.yaml','2025-12-03 12:19:01',65,'EXECUTED','9:33e89fc026179170825449b64673d450','createIndex indexName=idx_movie_directors_director_id, tableName=movie_directors','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-movie_genres-v1','vadym','db/changelog/schema/018-movie_genres/018-movie_genres-create.yaml','2025-12-03 12:19:01',66,'EXECUTED','9:d8e4d4b60c285be643a8d4728fad2d0f','createTable tableName=movie_genres','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_genres-genres','vadym','db/changelog/schema/018-movie_genres/018-movie_genres-fks.yaml','2025-12-03 12:19:01',67,'EXECUTED','9:163d12854be26b0ee13d78b934e6ae7e','addForeignKeyConstraint baseTableName=movie_genres, constraintName=fk_movie_genres_genre, referencedTableName=genres','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-movie_genres-movies','vadym','db/changelog/schema/018-movie_genres/018-movie_genres-fks.yaml','2025-12-03 12:19:01',68,'EXECUTED','9:c6ef1b6cd6573b507cc519442dd60988','addForeignKeyConstraint baseTableName=movie_genres, constraintName=fk_movie_genres_movie, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-movie_genres-genre_id','vadym','db/changelog/schema/018-movie_genres/018-movie_genres-indexes.yaml','2025-12-03 12:19:01',69,'EXECUTED','9:0b7dfae77147bca6327843613f07b8b9','createIndex indexName=idx_movie_genres_genre_id, tableName=movie_genres','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-users_roles-v1','vadym','db/changelog/schema/019-users_roles/019-users_roles-create.yaml','2025-12-03 12:19:01',70,'EXECUTED','9:550d6c5fb40cdcac2a3598a026e3425f','createTable tableName=users_roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-users_roles-roles','vadym','db/changelog/schema/019-users_roles/019-users_roles-fks.yaml','2025-12-03 12:19:01',71,'EXECUTED','9:0dde046fb8c16bea5db0c280e4307090','addForeignKeyConstraint baseTableName=users_roles, constraintName=fk_users_roles_role, referencedTableName=roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('fk-users_roles-users','vadym','db/changelog/schema/019-users_roles/019-users_roles-fks.yaml','2025-12-03 12:19:01',72,'EXECUTED','9:c4dae1e6346eb57eeded5b11789132a5','addForeignKeyConstraint baseTableName=users_roles, constraintName=fk_users_roles_user, referencedTableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('idx-users_roles-role_id','vadym','db/changelog/schema/019-users_roles/019-users_roles-indexes.yaml','2025-12-03 12:19:01',73,'EXECUTED','9:631e052f417ca9ee628c75d96f71a1f7','createIndex indexName=idx_users_roles_role_id, tableName=users_roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('seed-roles-v1','vadym','db/changelog/data/seed-roles.yaml','2025-12-03 12:19:01',74,'EXECUTED','9:42f495d9ca10ca16a67e664bb0affb21','insert tableName=roles; insert tableName=roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('seed-users-v1','vadym','db/changelog/data/seed-users.yaml','2025-12-03 12:19:01',75,'EXECUTED','9:6f9ccc2188d9f56029be77172633be91','insert tableName=users; insert tableName=users','',NULL,'4.31.1',NULL,NULL,'4760738488'),('seed-users_roles-v1','vadym','db/changelog/data/seed-users_roles.yaml','2025-12-03 12:19:01',76,'EXECUTED','9:40f60da310fa2830167a1291b4397be8','insert tableName=users_roles; insert tableName=users_roles','',NULL,'4.31.1',NULL,NULL,'4760738488'),('create-movie-watch-links-v1','vadym','db/changelog/schema/020-movie_watch_links/020-movie_watch_links-create.yaml','2025-12-03 16:33:59',77,'EXECUTED','9:43986c1eaf847077d3dbe5aa753ad900','createTable tableName=movie_watch_links','',NULL,'4.31.1',NULL,NULL,'4776038325'),('fk-movie-watch-links-movies','vadym','db/changelog/schema/020-movie_watch_links/020-movie_watch_links-fks.yaml','2025-12-03 16:33:59',78,'EXECUTED','9:2127c55b982132c5ef0845c1e0b0908c','addForeignKeyConstraint baseTableName=movie_watch_links, constraintName=fk_movie_watch_links_movies, referencedTableName=movies','',NULL,'4.31.1',NULL,NULL,'4776038325'),('idx-movie-watch-links-movie-id','vadym','db/changelog/schema/020-movie_watch_links/020-movie_watch_links-indexes.yaml','2025-12-03 16:33:59',79,'EXECUTED','9:d0323f6b0e9ec187bc71e00e9cea6bfc','createIndex indexName=idx_movie_watch_links_movie_id, tableName=movie_watch_links','',NULL,'4.31.1',NULL,NULL,'4776038325'),('add-total-rating-sum-to-movies','codex','db/changelog/schema/013-movie-rating-aggregates/013-movie-rating-aggregates.yaml','2025-12-08 11:28:18',80,'EXECUTED','9:a9c5d3356e83c7b7b970c1cfe400af2a','addColumn tableName=movies','',NULL,'4.31.1',NULL,NULL,'5189694986'),('ensure-rating-count-in-movies','codex','db/changelog/schema/013-movie-rating-aggregates/013-movie-rating-aggregates.yaml','2025-12-08 11:28:18',81,'MARK_RAN','9:3b3266431118130e48edca7301abb602','addColumn tableName=movies','',NULL,'4.31.1',NULL,NULL,'5189694986'),('fix-total-rating-sum-type','codex','db/changelog/schema/014-movie-rating-aggregates-fix/014-movie-rating-aggregates-fix.yaml','2025-12-08 11:51:26',82,'EXECUTED','9:c40631a72a82b18d04f8fbb110782c01','modifyDataType columnName=total_rating_sum, tableName=movies','',NULL,'4.31.1',NULL,NULL,'5191085017'),('fix-rating-count-type','codex','db/changelog/schema/014-movie-rating-aggregates-fix/014-movie-rating-aggregates-fix.yaml','2025-12-08 11:51:26',83,'EXECUTED','9:cddb894dbb6a4d2fb1f4e1dedf66ce34','modifyDataType columnName=rating_count, tableName=movies','',NULL,'4.31.1',NULL,NULL,'5191085017');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangeloglock`
--

DROP TABLE IF EXISTS `databasechangeloglock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangeloglock` (
  `ID` int NOT NULL,
  `LOCKED` tinyint NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_directors_full_name` (`full_name`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES (52,'Craig Mazin'),(47,'D.B. Weiss'),(46,'David Benioff'),(57,'Eric Kripke'),(51,'Frank Darabont'),(48,'Lauren Schmidt Hissrich'),(54,'Mark Gatiss'),(49,'Matt Duffer'),(58,'Michael Hirst'),(53,'Neil Druckmann'),(56,'Nic Pizzolatto'),(50,'Ross Duffer'),(55,'Steven Moffat'),(45,'Vince Gilligan'),(19,'Адріан Моліна'),(13,'Байрон Говард'),(17,'Боб Пітерсон'),(24,'Бред Берд'),(5,'Віккі Дженсон'),(35,'Девід Фінчер'),(43,'Демієн Шазелл'),(15,'Джаред Буш'),(40,'Джеймс Кемерон'),(9,'Дженніфер Лі'),(1,'Джон Лассетер'),(11,'Джон Маскер'),(21,'Джон Стівенсон'),(66,'Джон Фавро'),(68,'Джонатан Нолан'),(44,'Джордж Міллер'),(70,'Джордж Р. Р. Мартін'),(22,'Дін ДеБлуа'),(27,'Дон Голл'),(12,'Дон Холл'),(4,'Ендрю Адамсон'),(2,'Ендрю Стентон'),(63,'Ерік Кріпке'),(62,'Ісса Лопес'),(34,'Квентін Тарантіно'),(8,'Кріс Бак'),(28,'Кріс Вільямс'),(30,'Кріс Рено'),(23,'Кріс Сандерс'),(33,'Крістофер Нолан'),(37,'Лана Вачовскі'),(3,'Лі Анкріч'),(67,'Ліза Джой'),(38,'Ліллі Вачовскі'),(64,'Майкл Херст'),(59,'Марк Гейтіс'),(20,'Марк Осборн'),(42,'Мартін Скорсезе'),(61,'Нік Піццолатто'),(29,'П\'єр Коффен'),(16,'Піт Доктер'),(41,'Пітер Джексон'),(69,'Раян Кондал'),(39,'Рідлі Скотт'),(14,'Річ Мур'),(7,'Роб Мінкофф'),(36,'Роберт Земекіс'),(6,'Роджер Аллерс'),(10,'Рон Клементс'),(18,'Ронні дель Кармен'),(60,'Стівен Моффат'),(65,'Стівен Найт'),(31,'Френк Дарабонт'),(32,'Френсіс Форд Коппола'),(26,'Хаяо Міядзакі'),(25,'Ян Пінкава');
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_verification_token`
--

DROP TABLE IF EXISTS `email_verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_verification_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `token` varchar(255) NOT NULL,
  `expires_at` datetime NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_email_verification_token_token` (`token`),
  KEY `idx_email_verification_token_user_id` (`user_id`),
  CONSTRAINT `fk_email_verification_token_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_verification_token`
--

LOCK TABLES `email_verification_token` WRITE;
/*!40000 ALTER TABLE `email_verification_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_verification_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_genres_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (19,'Action'),(20,'Adventure'),(24,'Comedy'),(16,'Crime'),(17,'Drama'),(21,'Fantasy'),(22,'Horror'),(23,'Mystery'),(18,'Thriller'),(1,'Анімація'),(15,'Біографія'),(13,'Вестерн'),(4,'Драма'),(5,'Екшн'),(3,'Комедія'),(8,'Кримінал'),(12,'Містика'),(14,'Музика'),(9,'Наукова фантастика'),(2,'Пригоди'),(11,'Романтика'),(6,'Сімейний'),(10,'Трилер'),(7,'Фентезі');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actors`
--

DROP TABLE IF EXISTS `movie_actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_actors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `movie_id` bigint NOT NULL,
  `actor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_movie_actors_movie_actor` (`movie_id`,`actor_id`),
  KEY `idx_movie_actors_actor_id` (`actor_id`),
  CONSTRAINT `fk_movie_actors_actor` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_movie_actors_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actors`
--

LOCK TABLES `movie_actors` WRITE;
/*!40000 ALTER TABLE `movie_actors` DISABLE KEYS */;
INSERT INTO `movie_actors` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,4),(5,2,5),(6,2,6),(7,3,7),(8,3,8),(9,3,9),(10,4,10),(11,4,11),(12,4,12),(13,5,13),(14,5,14),(15,5,15),(16,6,16),(17,6,17),(18,6,18),(19,7,19),(20,7,20),(21,7,21),(22,8,22),(23,8,23),(24,8,24),(25,9,25),(26,9,26),(27,9,27),(28,10,28),(29,10,29),(30,10,30),(31,11,31),(32,11,32),(33,11,33),(34,12,34),(35,12,35),(36,12,36),(37,13,37),(38,13,38),(39,13,39),(40,14,40),(41,14,41),(42,14,42),(43,15,43),(44,15,44),(45,15,45),(46,16,46),(47,16,47),(48,16,48),(49,17,49),(50,17,50),(51,17,51),(52,18,52),(53,18,53),(54,18,54),(55,19,55),(56,19,56),(57,19,57),(58,20,58),(59,20,59),(60,20,60),(61,21,61),(62,21,62),(63,21,63),(64,22,64),(65,22,65),(66,22,66),(67,23,67),(68,23,68),(69,23,69),(70,24,50),(71,24,70),(72,24,71),(73,25,72),(74,25,73),(75,25,74),(76,26,75),(77,26,76),(78,26,77),(79,27,1),(80,27,78),(81,27,79),(82,28,80),(83,28,81),(84,28,82),(85,29,83),(86,29,84),(87,29,85),(88,30,86),(89,30,87),(90,30,88),(91,31,72),(92,31,89),(93,31,90),(94,32,91),(95,32,92),(96,32,93),(97,33,67),(98,33,94),(99,33,95),(100,34,72),(101,34,96),(102,34,97),(103,35,72),(104,35,98),(105,35,99),(106,36,100),(107,36,101),(108,36,102),(109,37,103),(110,37,104),(111,37,105),(112,38,106),(113,38,107),(114,38,108),(115,39,62),(116,39,76),(117,39,109),(118,40,1),(119,40,110),(120,40,111),(121,41,112),(122,41,113),(123,41,114),(124,42,115),(125,42,116),(126,42,117),(127,43,118),(128,43,119),(129,43,120),(130,44,121),(131,44,122),(132,44,123),(133,45,124),(134,45,125),(135,45,126),(136,46,127),(137,46,128),(138,46,129),(139,47,130),(140,47,131),(141,47,132),(142,48,133),(143,48,134),(144,48,135),(145,49,136),(146,49,137),(147,49,138),(148,50,139),(149,50,140),(150,50,141),(151,51,142),(152,51,143),(153,51,144),(154,52,145),(155,52,146),(156,52,147),(157,53,148),(158,53,149),(159,53,150),(160,54,151),(161,54,152),(162,54,153),(163,55,154),(164,55,155),(165,55,156),(166,56,157),(167,56,158),(168,56,159),(169,57,160),(170,57,161),(171,57,162),(172,58,163),(173,58,164),(174,58,165);
/*!40000 ALTER TABLE `movie_actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_countries`
--

DROP TABLE IF EXISTS `movie_countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_countries` (
  `movie_id` bigint NOT NULL,
  `country_id` bigint NOT NULL,
  PRIMARY KEY (`movie_id`,`country_id`),
  KEY `idx_movie_countries_country_id` (`country_id`),
  CONSTRAINT `fk_movie_countries_country` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_movie_countries_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_countries`
--

LOCK TABLES `movie_countries` WRITE;
/*!40000 ALTER TABLE `movie_countries` DISABLE KEYS */;
INSERT INTO `movie_countries` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(51,1),(52,1),(53,1),(56,1),(57,1),(58,1),(2,2),(11,2),(13,2),(15,2),(16,2),(2,3),(28,3),(37,3),(10,4),(11,5),(11,6),(12,7),(20,7),(23,7),(25,7),(29,7),(30,7),(33,7),(51,7),(55,7),(12,8),(19,8),(20,9),(26,10),(29,11),(54,11),(30,12),(30,13),(32,14),(35,15),(41,16),(42,16),(43,16),(44,16),(45,16),(46,16),(47,16),(48,16),(49,16),(42,17),(43,17),(47,17),(43,18),(43,19),(46,20),(50,20),(50,21),(54,22);
/*!40000 ALTER TABLE `movie_countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_directors`
--

DROP TABLE IF EXISTS `movie_directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_directors` (
  `movie_id` bigint NOT NULL,
  `director_id` bigint NOT NULL,
  PRIMARY KEY (`movie_id`,`director_id`),
  KEY `idx_movie_directors_director_id` (`director_id`),
  CONSTRAINT `fk_movie_directors_director` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_movie_directors_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_directors`
--

LOCK TABLES `movie_directors` WRITE;
/*!40000 ALTER TABLE `movie_directors` DISABLE KEYS */;
INSERT INTO `movie_directors` VALUES (1,1),(2,2),(13,2),(2,3),(10,3),(3,4),(3,5),(4,6),(4,7),(5,8),(5,9),(6,10),(6,11),(6,12),(7,13),(7,14),(7,15),(8,16),(9,16),(8,17),(9,18),(10,19),(11,20),(11,21),(12,22),(12,23),(14,24),(17,24),(20,24),(14,25),(15,26),(16,26),(18,27),(18,28),(19,29),(19,30),(21,31),(40,31),(22,32),(23,33),(25,33),(29,33),(33,33),(24,34),(34,34),(26,35),(38,35),(39,35),(27,36),(28,37),(28,38),(30,39),(31,40),(32,41),(35,42),(36,43),(37,44),(41,45),(42,46),(42,47),(43,48),(44,49),(44,50),(45,51),(46,52),(46,53),(47,54),(47,55),(48,56),(49,57),(50,58),(51,59),(51,60),(52,61),(52,62),(53,63),(54,64),(55,65),(56,66),(57,67),(57,68),(58,69),(58,70);
/*!40000 ALTER TABLE `movie_directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_genres`
--

DROP TABLE IF EXISTS `movie_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_genres` (
  `movie_id` bigint NOT NULL,
  `genre_id` bigint NOT NULL,
  PRIMARY KEY (`movie_id`,`genre_id`),
  KEY `idx_movie_genres_genre_id` (`genre_id`),
  CONSTRAINT `fk_movie_genres_genre` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_movie_genres_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_genres`
--

LOCK TABLES `movie_genres` WRITE;
/*!40000 ALTER TABLE `movie_genres` DISABLE KEYS */;
INSERT INTO `movie_genres` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(25,2),(29,2),(30,2),(32,2),(37,2),(54,2),(56,2),(58,2),(1,3),(2,3),(3,3),(5,3),(6,3),(8,3),(9,3),(14,3),(19,3),(53,3),(4,4),(10,4),(21,4),(22,4),(23,4),(24,4),(26,4),(27,4),(29,4),(30,4),(31,4),(32,4),(33,4),(34,4),(35,4),(36,4),(38,4),(39,4),(40,4),(51,4),(52,4),(54,4),(55,4),(57,4),(58,4),(7,5),(11,5),(12,5),(17,5),(18,5),(20,5),(23,5),(25,5),(28,5),(30,5),(37,5),(53,5),(54,5),(56,5),(58,5),(13,6),(15,6),(16,7),(32,7),(40,7),(56,7),(22,8),(23,8),(24,8),(26,8),(35,8),(39,8),(40,8),(51,8),(52,8),(53,8),(55,8),(25,9),(28,9),(29,9),(33,9),(37,9),(57,9),(26,10),(35,10),(27,11),(31,11),(33,12),(39,12),(51,12),(52,12),(57,12),(34,13),(36,14),(38,15),(41,16),(47,16),(48,16),(49,16),(41,17),(42,17),(43,17),(44,17),(45,17),(46,17),(47,17),(48,17),(50,17),(41,18),(45,18),(42,19),(43,19),(46,19),(49,19),(50,19),(42,20),(43,20),(46,20),(50,20),(44,21),(44,22),(45,22),(47,23),(48,23),(49,24);
/*!40000 ALTER TABLE `movie_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_watch_links`
--

DROP TABLE IF EXISTS `movie_watch_links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_watch_links` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `movie_id` bigint NOT NULL,
  `url` varchar(1024) NOT NULL,
  `platform_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_movie_watch_links_movie_id` (`movie_id`),
  CONSTRAINT `fk_movie_watch_links_movies` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_watch_links`
--

LOCK TABLES `movie_watch_links` WRITE;
/*!40000 ALTER TABLE `movie_watch_links` DISABLE KEYS */;
INSERT INTO `movie_watch_links` VALUES (1,1,'https://www.netflix.com/title/80100172','Netflix');
/*!40000 ALTER TABLE `movie_watch_links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `release_year` int DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `average_rating` decimal(3,1) DEFAULT NULL,
  `rating_count` int DEFAULT NULL,
  `poster_url` varchar(512) DEFAULT NULL,
  `trailer_url` varchar(512) DEFAULT NULL,
  `is_free` bit(1) NOT NULL,
  `age_rating` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `season` varchar(20) DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `total_rating_sum` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_movies_title_unique` (`title`),
  KEY `idx_movies_title` (`title`),
  KEY `idx_movies_release_year` (`release_year`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Історія іграшок','Іграшковий ковбой Вуді ревнує, коли у хлопчика з’являється нова іграшка — астронавт Базз. Через випадковість вони губляться й мусять повернутися додому разом.','1995-11-22',1995,81,10.0,0,'https://m.media-amazon.com/images/M/MV5BZTA3OWVjOWItNjE1NS00NzZiLWE1MjgtZDZhMWI1ZTlkNzYwXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=4KPTXpQehio',_binary '\0','AGE_0','CARTOON','AUTUMN',_binary '\0',0),(2,'У пошуках Немо','Боязкий клоун-фіш Марлін вирушає через океан, щоб урятувати свого сина Немо, якого забрали до Сіднея.','2003-05-30',2003,100,8.0,0,'https://m.media-amazon.com/images/M/MV5BMTc5NjExNTA5OV5BMl5BanBnXkFtZTYwMTQ0ODY2._V1_SX300.jpg','https://www.youtube.com/watch?v=wZdpNglLbt8',_binary '\0','AGE_0','CARTOON','SPRING',_binary '\0',0),(3,'Шрек','Огр Шрек мусить урятувати принцесу Фіону, щоб повернути своє болото, але несподівано знаходить друзів і новий сенс життя.','2001-05-18',2001,90,7.0,0,'https://m.media-amazon.com/images/M/MV5BN2FkMTRkNTUtYTI0NC00ZjI4LWI5MzUtMDFmOGY0NmU2OGY1XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=CwXOrWvPBPk',_binary '\0','AGE_7','CARTOON','SPRING',_binary '\0',0),(4,'Король Лев','Левеня Сімба втікає після трагедії, а згодом повертається, щоб прийняти свою долю та врятувати королівство.','1994-06-24',1994,88,9.0,0,'https://m.media-amazon.com/images/M/MV5BZGRiZDZhZjItM2M3ZC00Y2IyLTk3Y2MtMWY5YjliNDFkZTJlXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=lFzVJEksoDY',_binary '\0','AGE_0','CARTOON','SUMMER',_binary '\0',0),(5,'Крижане серце','Анна вирушає на пошуки сестри Ельзи, чия магія занурила королівство в одвічну зиму.','2013-11-27',2013,102,8.0,0,'https://m.media-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg','https://www.youtube.com/watch?v=TbQm5doF_Uc',_binary '\0','AGE_7','CARTOON','AUTUMN',_binary '\0',0),(6,'Моана','Смілива дівчина Моана вирушає у відкрите море, щоб зупинити прокляття та знайти легендарного напівбога Мауї.','2016-11-23',2016,107,7.0,0,'https://m.media-amazon.com/images/M/MV5BMjI4MzU5NTExNF5BMl5BanBnXkFtZTgwNzY1MTEwMDI@._V1_SX300.jpg','https://www.youtube.com/watch?v=LKFuXETZUsI',_binary '\0','AGE_7','CARTOON','AUTUMN',_binary '\0',0),(7,'Зоотрополіс','Поліцейська кролиця Джуді та шахрай-лис Нік розкривають змову, що загрожує всьому місту тварин.','2016-03-04',2016,108,8.0,0,'https://m.media-amazon.com/images/M/MV5BOTMyMjEyNzIzMV5BMl5BanBnXkFtZTgwNzIyNjU0NzE@._V1_SX300.jpg','https://www.youtube.com/watch?v=jWM0ct-OLsM',_binary '\0','AGE_7','CARTOON','SPRING',_binary '\0',0),(8,'Вгору','Самотній літній чоловік прив’язує до свого дому тисячі повітряних куль, щоб здійснити мрію життя, та випадково бере з собою хлопчика-скаута.','2009-05-29',2009,96,10.0,0,'https://m.media-amazon.com/images/M/MV5BNmI1ZTc5MWMtMDYyOS00ZDc2LTkzOTAtNjQ4NWIxNjYyNDgzXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=ORFWdXl_zJ4',_binary '\0','AGE_7','CARTOON','SPRING',_binary '\0',0),(9,'Думками навиворіт','Емоції маленької Райлi намагаються допомогти їй адаптуватися до переїзду в нове місто та школу.','2015-06-19',2015,95,7.0,0,'https://m.media-amazon.com/images/M/MV5BOTgxMDQwMDk0OF5BMl5BanBnXkFtZTgwNjU5OTg2NDE@._V1_SX300.jpg','https://www.youtube.com/watch?v=yRUAzGQ3nSY',_binary '\0','AGE_7','CARTOON','SUMMER',_binary '\0',0),(10,'Коко','Хлопчик Міґель потрапляє до Країни Мертвих у пошуках свого прадіда-музиканта, попри заборону родини.','2017-11-22',2017,105,8.0,0,'https://m.media-amazon.com/images/M/MV5BMDIyM2E2NTAtMzlhNy00ZGUxLWI1NjgtZDY5MzhiMDc5NGU3XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=zNCz4mQzfEI',_binary '\0','AGE_7','CARTOON','AUTUMN',_binary '\0',0),(11,'Кунг-фу Панда','Незграбний панда По несподівано стає обраним воїном, який має врятувати Долину Миру від небезпечного ворога.','2008-06-06',2008,92,9.0,0,'https://m.media-amazon.com/images/M/MV5BZDU5MDNiMGItYjVmZi00NDUxLTg2OTktNGE0NzNlNzM4NzgyXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=PXi3Mv6KMzY',_binary '\0','AGE_7','CARTOON','SUMMER',_binary '\0',0),(12,'Як приборкати дракона','Юний вікінг Гікапа мріє стати мисливцем на драконів, але замість цього знаходить унікального друга — Нічну Лють.','2010-03-26',2010,98,7.5,0,'https://m.media-amazon.com/images/M/MV5BMjA5NDQyMjc2NF5BMl5BanBnXkFtZTcwMjg5ODcyMw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=oKiYuIsPxYk',_binary '\0','AGE_7','CARTOON','SPRING',_binary '\0',0),(13,'ВАЛЛ·І','Робот-прибиральник ВАЛЛ·І самотньо працює на покинутій Землі, доки не зустрічає розвідувальний робот EVE і не відкриває для себе любов.','2008-06-27',2008,98,8.5,0,'https://m.media-amazon.com/images/M/MV5BMjExMTg5OTU0NF5BMl5BanBnXkFtZTcwMjMxMzMzMw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=CZ1CATNbXg0',_binary '\0','AGE_0','CARTOON','SUMMER',_binary '\0',0),(14,'Рататуй','Ремі — щур, що мріє бути шеф-кухарем. Він утворює неймовірний союз із юним кухарем у ресторані Парижа.','2007-06-29',2007,111,9.5,0,'https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=NgsQ8mVkN8w',_binary '\0','AGE_0','CARTOON','SUMMER',_binary '\0',0),(15,'Віднесені привидами','Дівчинка Тіхіро потрапляє у світ духів і мусить знайти шлях назад, пройшовши випробування та подорослішавши.','2003-03-28',2003,124,8.5,0,'https://m.media-amazon.com/images/M/MV5BNTEyNmEwOWUtYzkyOC00ZTQ4LTllZmUtMjk0Y2YwOGUzYjRiXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=ByXuk9QqQkk',_binary '\0','AGE_7','CARTOON','SPRING',_binary '\0',0),(16,'Принцеса Мононоке','Воїн Асітака потрапляє у конфлікт між духами лісу та людьми, що нищать природу, і зустрічає дівчину Мононоке.','1997-07-12',1997,133,9.5,0,'https://m.media-amazon.com/images/M/MV5BZTcyN2Y0MDYtMGI1NC00MWQ1LWFhZGMtN2U4NTcxZGYyNjljXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=4OiMOHRDs14',_binary '\0','AGE_12','CARTOON','SUMMER',_binary '\0',0),(17,'Суперсімейка','Родина супергероїв, що намагається жити звичайним життям, знову змушена врятувати світ від небезпеки.','2004-11-05',2004,115,8.5,0,'https://m.media-amazon.com/images/M/MV5BMTY5OTU0OTc2NV5BMl5BanBnXkFtZTcwMzU4MDcyMQ@@._V1_SX300.jpg','https://www.youtube.com/watch?v=eZbzbC9285I',_binary '\0','AGE_7','CARTOON','AUTUMN',_binary '\0',0),(18,'Місто героїв','Юний геній Хіро створює команду супергероїв разом із милим роботом Беймаксом, щоб протистояти злочинцю.','2014-11-07',2014,102,8.5,0,'https://m.media-amazon.com/images/M/MV5BYjQ3YzUyOGQtNjdlYS00YmRhLWIyOWYtMGQ3YjkwMjJiYzRjXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=z3biFxZIJOQ',_binary '\0','AGE_7','CARTOON','AUTUMN',_binary '\0',0),(19,'Гидкий я','Лиходій Ґру планує грандіозне пограбування, але все змінюється, коли він усиновлює трьох дівчаток.','2010-07-09',2010,95,8.0,0,'https://m.media-amazon.com/images/M/MV5BMTY3NjY0MTQ0Nl5BMl5BanBnXkFtZTcwMzQ2MTc0Mw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=zzCZ1W_CUoI',_binary '\0','AGE_0','CARTOON','SUMMER',_binary '\0',0),(20,'Залізний велетень','Хлопчик Гоґарт знаходить гігантського робота, якого уряд хоче знищити. Разом вони створюють неймовірну дружбу.','1999-08-06',1999,86,8.7,0,'https://m.media-amazon.com/images/M/MV5BODM4ZjZjMGEtYmFiMy00MThjLWIzZjUtMDU0ODg1NTI2MzIwXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=f8itpB5E_ME',_binary '\0','AGE_7','CARTOON','SUMMER',_binary '\0',0),(21,'Втеча з Шоушенка','Банкір, несправедливо засуджений до довічного ув’язнення, знаходить надію та дружбу, не полишаючи мрії про свободу.','1994-10-14',1994,142,NULL,0,'https://m.media-amazon.com/images/M/MV5BMDAyY2FhYjctNDc5OS00MDNlLThiMGUtY2UxYWVkNGY2ZjljXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=NmzuHjWmXOc',_binary '\0','AGE_18','MOVIE','AUTUMN',_binary '\0',0),(22,'Хрещений батько','Глава мафіозного клану Корлеоне передає владу своєму нерішучому синові, що змінює долю всієї родини.','1972-03-24',1972,175,NULL,0,'https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2ZGEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=UaVTIH8mujA',_binary '\0','AGE_18','MOVIE','SPRING',_binary '\0',0),(23,'Темний лицар','Бетмен протистоїть Джокеру, який розгортає хаос у Готемі та випробовує межі моралі міста й самого героя.','2008-07-18',2008,152,NULL,0,'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=EXeTwQWrcwY',_binary '\0','AGE_12','MOVIE','SUMMER',_binary '\0',0),(24,'Кримінальне чтиво','Кілька історій злочинців, боксера та пари грабіжників переплітаються у вирі насильства й чорного гумору.','1994-10-14',1994,154,NULL,0,'https://m.media-amazon.com/images/M/MV5BYTViYTE3ZGQtNDBlMC00ZTAyLTkyODMtZGRiZDg0MjA2YThkXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=s7EdQ4FqbhY',_binary '\0','AGE_18','MOVIE','AUTUMN',_binary '\0',0),(25,'Початок','Спеціаліст зі снів намагається виконати неможливе — впровадити ідею в чужу свідомість, ризикуючи потонути у власних спогадах.','2010-07-16',2010,148,NULL,0,'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=8hP9D6kZseM',_binary '\0','AGE_12','MOVIE','SUMMER',_binary '\0',0),(26,'Бійцівський клуб','Офісний працівник знайомиться з харизматичним незнайомцем і занурюється у світ підпільних боїв, що виходить з-під контролю.','1999-10-15',1999,139,NULL,0,'https://m.media-amazon.com/images/M/MV5BOTgyOGQ1NDItNGU3Ny00MjU3LTg2YWEtNmEyYjBiMjI1Y2M5XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=SUXWAEX2jlg',_binary '\0','AGE_18','MOVIE','AUTUMN',_binary '\0',0),(27,'Форрест Ґамп','Історія США постає крізь життя Форреста, простодушного чоловіка, який випадково стає учасником великих подій.','1994-07-06',1994,142,NULL,0,'https://m.media-amazon.com/images/M/MV5BNDYwNzVjMTItZmU5YS00YjQ5LTljYjgtMjY2NDVmYWMyNWFmXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=bLvqoHBptjg',_binary '\0','AGE_12','MOVIE','SUMMER',_binary '\0',0),(28,'Матриця','Хакер Нео дізнається, що реальність — це симуляція, і приєднується до борців за свободу людства.','1999-03-31',1999,136,NULL,0,'https://m.media-amazon.com/images/M/MV5BN2NmN2VhMTQtMDNiOS00NDlhLTliMjgtODE2ZTY0ODQyNDRhXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=m8e-FF8MsqU',_binary '\0','AGE_18','MOVIE','SPRING',_binary '\0',0),(29,'Інтерстеллар','Людство стоїть на межі вимирання, і пілот Купер вирушає у космос, щоб знайти новий дім для людства.','2014-11-07',2014,169,NULL,0,'https://m.media-amazon.com/images/M/MV5BYzdjMDAxZGItMjI2My00ODA1LTlkNzItOWFjMDU5ZDJlYWY3XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=zSWdZVtXT7E',_binary '\0','AGE_12','MOVIE','AUTUMN',_binary '\0',0),(30,'Гладіатор','Римський генерал Максимус шукає помсти імператору, який зрадив його та знищив його родину.','2000-05-05',2000,155,NULL,0,'https://m.media-amazon.com/images/M/MV5BYWQ4YmNjYjEtOWE1Zi00Y2U4LWI4NTAtMTU0MjkxNWQ1ZmJiXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=owK1qxDselE',_binary '\0','AGE_18','MOVIE','SPRING',_binary '\0',0),(31,'Титанік','Юна аристократка закохується в бідного художника на борту фатального корабля, що назавжди змінює їхні долі.','1997-12-19',1997,194,NULL,0,'https://m.media-amazon.com/images/M/MV5BYzYyN2FiZmUtYWYzMy00MzViLWJkZTMtOGY1ZjgzNWMwN2YxXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=2e-eXJ6HgkQ',_binary '\0','AGE_12','MOVIE','WINTER',_binary '\0',0),(32,'Володар перснів: Повернення короля','Арґорн та Гендальф ведуть людей у вирішальній битві, поки Фродо та Сем наближаються до Рокової гори, щоб знищити Перстень.','2003-12-17',2003,201,NULL,0,'https://m.media-amazon.com/images/M/MV5BMTZkMjBjNWMtZGI5OC00MGU0LTk4ZTItODg2NWM3NTVmNWQ4XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=r5X-hFf6Bwo',_binary '\0','AGE_12','MOVIE','WINTER',_binary '\0',0),(33,'Престиж','Двоє ілюзіоністів XIX століття вступають у смертельне суперництво за найдосконаліший сценічний трюк.','2006-10-20',2006,130,NULL,0,'https://m.media-amazon.com/images/M/MV5BMTM3MzQ5MjQ5OF5BMl5BanBnXkFtZTcwMTQ3NzMzMw@@._V1_SX300.jpg','https://www.youtube.com/watch?v=o4gHCmTQDVI',_binary '\0','AGE_12','MOVIE','AUTUMN',_binary '\0',0),(34,'Джанґо вільний','Звільнений раб об’єднується з мисливцем за головами, щоб урятувати свою дружину з жорстокої плантації.','2012-12-25',2012,165,NULL,0,'https://m.media-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_SX300.jpg','https://www.youtube.com/watch?v=eUdM9vrCbow',_binary '\0','AGE_18','MOVIE','WINTER',_binary '\0',0),(35,'Відступники','Поліцейський під прикриттям та інформатор у поліції намагаються викрити один одного серед бостонської мафії.','2006-10-06',2006,151,NULL,0,'https://m.media-amazon.com/images/M/MV5BMTI1MTY2OTIxNV5BMl5BanBnXkFtZTYwNjQ4NjY3._V1_SX300.jpg','https://www.youtube.com/watch?v=iojhqm0JTW4',_binary '\0','AGE_18','MOVIE','AUTUMN',_binary '\0',0),(36,'Одержимість','Молодий барабанщик потрапляє під наставництво жорстокого диригента, який доводить його до межі можливостей.','2014-10-15',2014,106,NULL,0,'https://m.media-amazon.com/images/M/MV5BMDFjOWFkYzktYzhhMC00NmYyLTkwY2EtYjViMDhmNzg0OGFkXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=7d_jQycdQGo',_binary '\0','AGE_18','MOVIE','AUTUMN',_binary '\0',0),(37,'Шалений Макс: Дорога гніву','У постапокаліптичному світі Макс і Фуріоса тікають від тирана, рятуючи групу жінок-бранок.','2015-05-15',2015,120,NULL,0,'https://m.media-amazon.com/images/M/MV5BZDRkODJhOTgtOTc1OC00NTgzLTk4NjItNDgxZDY4YjlmNDY2XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=hEJnMQG9ev8',_binary '\0','AGE_18','MOVIE','SPRING',_binary '\0',0),(38,'Соціальна мережа','Марк Цукерберґ створює Facebook і опиняється в центрі судових позовів та конфліктів через права на ідею.','2010-10-01',2010,120,NULL,0,'https://m.media-amazon.com/images/M/MV5BMjlkNTE5ZTUtNGEwNy00MGVhLThmZjMtZjU1NDE5Zjk1NDZkXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=lB95KLmpLR4',_binary '\0','AGE_12','MOVIE','AUTUMN',_binary '\0',0),(39,'Сім','Двоє детективів розслідують серію жорстоких убивств, пов’язаних із сімома смертними гріхами.','1995-09-22',1995,127,NULL,0,'https://m.media-amazon.com/images/M/MV5BY2IzNzMxZjctZjUxZi00YzAxLTk3ZjMtODFjODdhMDU5NDM1XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=znmZoVkCjpI',_binary '\0','AGE_18','MOVIE','AUTUMN',_binary '\0',0),(40,'Зелена миля','Начальник блоку смертників відкриває надзвичайний дар засудженого, що змінює його погляд на життя і справедливість.','1999-12-10',1999,189,NULL,0,'https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_SX300.jpg','https://www.youtube.com/watch?v=Ki4haFrqSrw',_binary '\0','AGE_18','MOVIE','WINTER',_binary '\0',0),(41,'Breaking Bad','Шкільний учитель хімії Волтер Вайт дізнається про смертельний діагноз і вирішує забезпечити родину, виготовляючи метамфетамін разом з колишнім учнем. Занурюючись у світ злочинності, він відкриває у собі темний бік, який змінює життя всіх довкола.','2008-01-20',2008,49,NULL,0,'https://m.media-amazon.com/images/M/MV5BMzU5ZGYzNmQtMTdhYy00OGRiLTg0NmQtYjVjNzliZTg1ZGE4XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=HhesaQXLuRY',_binary '\0','AGE_16','SERIES','WINTER',_binary '\0',0),(42,'Game of Thrones','У світі Вестеросу дев’ять родів борються за владу, поки давня загроза пробуджується на далекій Півночі. Політичні інтриги, зрада та битва за Залізний трон визначать долю королівств.','2011-04-17',2011,57,NULL,0,'https://m.media-amazon.com/images/M/MV5BMTNhMDJmNmYtNDQ5OS00ODdlLWE0ZDAtZTgyYTIwNDY3OTU3XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=KPLWWIOCOOQ',_binary '\0','AGE_16','SERIES','SPRING',_binary '\0',0),(43,'The Witcher','Ґеральт із Рівії — відьмак-мисливець на чудовиськ, який намагається знайти своє місце у світі, де справжні монстри часто — люди. Його доля переплітається з принцесою Цірі та чарівницею Єнніфер.','2019-12-20',2019,60,NULL,0,'https://m.media-amazon.com/images/M/MV5BOTQzMzNmMzUtODgwNS00YTdhLTg5N2MtOWU1YTc4YWY3NjRlXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=ndl1W4ltcmg',_binary '\0','AGE_16','SERIES','WINTER',_binary '\0',0),(44,'Stranger Things','У тихому містечку Гокінс зникає хлопчик, а друзі та родина стикаються з таємничими силами та секретними експериментами. Світ перевертається, коли вони знаходять дівчинку з надприродними здібностями.','2016-07-15',2016,51,NULL,0,'https://m.media-amazon.com/images/M/MV5BNjRiMTA4NWUtNmE0ZC00NGM0LWJhMDUtZWIzMDM5ZDIzNTg3XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=b9EkMc79ZSU',_binary '\0','AGE_16','SERIES','SUMMER',_binary '\0',0),(45,'The Walking Dead','Після пробудження від коми Рік Ґраймс потрапляє у світ, охоплений зомбі-апокаліпсисом. Він очолює групу вцілілих, які намагаються знайти безпеку та боротися за людяність.','2010-10-31',2010,44,NULL,0,'https://m.media-amazon.com/images/M/MV5BYWQwMGRhNGEtZTNhMy00MzVjLWJhMjItYjcwMDljMTkyNTg2XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=sfAc2U20uyg',_binary '\0','AGE_16','SERIES','AUTUMN',_binary '\0',0),(46,'The Last of Us','Через 20 років після краху цивілізації Джоел супроводжує Еллі — дівчинку, яка може стати ключем до порятунку людства. Їхня подорож сповнена небезпек, втрат і надії.','2023-01-15',2023,78,NULL,0,'https://m.media-amazon.com/images/M/MV5BYWI3ODJlMzktY2U5NC00ZjdlLWE1MGItNWQxZDk3NWNjN2RhXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=uLtkt8BonwM',_binary '\0','AGE_16','SERIES','WINTER',_binary '\0',0),(47,'Sherlock','Шерлок Голмс — геніальний детектив сучасного Лондона, який розкриває найскладніші злочини разом із ветераном Джоном Ватсоном. Їхній союз — поєднання логіки, нестандартного мислення та гумору.','2010-10-24',2010,88,NULL,0,'https://m.media-amazon.com/images/M/MV5BNTQzNGZjNDEtOTMwYi00MzFjLWE2ZTYtYzYxYzMwMjZkZDc5XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=xK7S9mrFWL4',_binary '\0','AGE_16','SERIES','AUTUMN',_binary '\0',0),(48,'True Detective','Антологія глибоких кримінальних історій, де розслідування відкривають темні секрети детективів. Кожен сезон — нові герої, новий злочин і безжальна правда.','2014-01-12',2014,55,NULL,0,'https://m.media-amazon.com/images/M/MV5BYjgwYzA1NWMtNDYyZi00ZGQyLWI5NTktMDYwZjE2OTIwZWEwXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=TxRO7upb93A',_binary '\0','AGE_16','SERIES','WINTER',_binary '\0',0),(49,'The Boys','Світ, де супергерої — зірки, а не захисники. Група звичайних людей об’єднується, щоб знищити корупцію та викрити темний бік суперсили.','2019-07-26',2019,31,NULL,0,'https://m.media-amazon.com/images/M/MV5BMWJlN2U5MzItNjU4My00NTM2LWFjOWUtOWFiNjg3ZTMxZDY1XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=5SKP1_F7ReE',_binary '\0','AGE_16','SERIES','SUMMER',_binary '\0',0),(50,'Vikings','Історія легендарного Рагнара Лодброка, який прагне досліджувати нові землі та кинути виклик старому порядку. Жорстокі битви й політичні інтриги визначають долю вікінгів.','2013-03-03',2013,44,NULL,0,'https://m.media-amazon.com/images/M/MV5BOTFmZmExYTEtYmE0Mi00MzRmLWE4ZDYtOThiNzNlOTIyODljXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=9GgxinPwAGc',_binary '\0','AGE_16','SERIES','SPRING',_binary '\0',0),(51,'Шерлок','Сучасна інтерпретація пригод детектива Шерлока Голмса, який розкриває найскладніші злочини Лондона разом із доктором Ватсоном.','2010-10-24',2010,88,NULL,0,'https://m.media-amazon.com/images/M/MV5BNTQzNGZjNDEtOTMwYi00MzFjLWE2ZTYtYzYxYzMwMjZkZDc5XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=IrBKwzL3K7s',_binary '\0','AGE_12','SERIES','AUTUMN',_binary '\0',0),(52,'Справжній детектив','Антологія кримінальних історій, у яких розслідування відкривають особисті та професійні секрети детективів і людей довкола них.','2014-01-12',2014,55,NULL,0,'https://m.media-amazon.com/images/M/MV5BYjgwYzA1NWMtNDYyZi00ZGQyLWI5NTktMDYwZjE2OTIwZWEwXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=fVQUcaO4AvE',_binary '\0','AGE_16','SERIES','WINTER',_binary '\0',0),(53,'Пацани','Світ, де супергерої стали корумпованими зірками. Група простих хлопців вирішує протистояти їм та викрити правду.','2019-07-26',2019,31,NULL,0,'https://m.media-amazon.com/images/M/MV5BMWJlN2U5MzItNjU4My00NTM2LWFjOWUtOWFiNjg3ZTMxZDY1XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=06rueu_fh30',_binary '\0','AGE_18','SERIES','SUMMER',_binary '\0',0),(54,'Вікінги','Історія Рагнара Лодброка — легендарного воїна-вікінга, який прагне досліджувати нові землі та змінити долю свого народу.','2013-03-03',2013,44,NULL,0,'https://m.media-amazon.com/images/M/MV5BOTFmZmExYTEtYmE0Mi00MzRmLWE4ZDYtOThiNzNlOTIyODljXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=9GgxinPwAGc',_binary '\0','AGE_18','SERIES','SPRING',_binary '\0',0),(55,'Гострі картузи','Гангстерська сага про родину Шелбі, яка будує кримінальну імперію в Бірмінгемі після Першої світової війни.','2014-09-30',2014,60,NULL,0,'https://m.media-amazon.com/images/M/MV5BOGM0NGY3ZmItOGE2ZC00OWIxLTk0N2EtZWY4Yzg3ZDlhNGI3XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=oVzVdvGIC7U',_binary '\0','AGE_16','SERIES','AUTUMN',_binary '\0',0),(56,'Мандалорець','Одинокий найманець подорожує далекими краями галактики після падіння Імперії, виконуючи небезпечні завдання.','2019-11-12',2019,40,NULL,0,'https://m.media-amazon.com/images/M/MV5BNjgxZGM0OWUtZGY1MS00MWRmLTk2N2ItYjQyZTI1OThlZDliXkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=aOC8E8z_ifw',_binary '\0','AGE_12','SERIES','AUTUMN',_binary '\0',0),(57,'Світ Дикого Заходу','Парк розваг майбутнього дозволяє гостям пережити будь-які фантазії, поки штучний інтелект не виходить з-під контролю.','2016-10-02',2016,62,NULL,0,'https://m.media-amazon.com/images/M/MV5BMjM2MTA5NjIwNV5BMl5BanBnXkFtZTgwNjI2OTMxNTM@._V1_SX300.jpg','https://www.youtube.com/watch?v=IuS5huqOND4',_binary '\0','AGE_16','SERIES','AUTUMN',_binary '\0',0),(58,'Дом Дракона','Передісторія «Гри престолів», що показує боротьбу Таргарієнів за владу та падіння їхньої великої династії.','2022-08-21',2022,60,NULL,0,'https://m.media-amazon.com/images/M/MV5BM2QzMGVkNjUtN2Y4Yi00ODMwLTg3YzktYzUxYjJlNjFjNDY1XkEyXkFqcGc@._V1_SX300.jpg','https://www.youtube.com/watch?v=DotnJ7tTA34',_binary '\0','AGE_16','SERIES','SUMMER',_binary '\0',0);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_tokens`
--

DROP TABLE IF EXISTS `password_reset_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_tokens` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `token` varchar(255) NOT NULL,
  `user_id` bigint NOT NULL,
  `expires_at` datetime NOT NULL,
  `used` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_password_reset_tokens_token` (`token`),
  KEY `idx_password_reset_tokens_user_id` (`user_id`),
  CONSTRAINT `fk_password_reset_tokens_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_tokens`
--

LOCK TABLES `password_reset_tokens` WRITE;
/*!40000 ALTER TABLE `password_reset_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `value` int NOT NULL,
  `movie_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_ratings_movie_user` (`movie_id`,`user_id`),
  KEY `idx_ratings_movie_id` (`movie_id`),
  KEY `idx_ratings_user_id` (`user_id`),
  CONSTRAINT `fk_ratings_movies` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ratings_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
INSERT INTO `ratings` VALUES (1,10,1,3),(2,8,2,3),(3,7,3,3),(4,9,4,3),(5,8,5,3),(6,7,6,3),(7,8,7,3),(8,10,8,3),(9,7,9,3),(10,8,10,3),(11,10,11,3),(12,8,12,3),(13,7,13,3),(14,10,14,3),(15,8,15,3),(16,10,16,3),(17,9,17,3),(18,10,18,3),(19,7,19,3),(20,10,20,3),(21,8,10,4),(22,8,11,4),(23,7,12,4),(24,10,13,4),(25,9,14,4),(26,9,15,4),(27,9,16,4),(28,8,17,4),(29,7,18,4),(30,9,19,4),(31,8,20,4),(32,8,20,5);
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_comments`
--

DROP TABLE IF EXISTS `review_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) NOT NULL,
  `review_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `parent_comment_id` bigint DEFAULT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_review_comments_review_id` (`review_id`),
  KEY `idx_review_comments_user_id` (`user_id`),
  KEY `idx_review_comments_parent_comment_id` (`parent_comment_id`),
  CONSTRAINT `fk_review_comments_parent` FOREIGN KEY (`parent_comment_id`) REFERENCES `review_comments` (`id`),
  CONSTRAINT `fk_review_comments_review` FOREIGN KEY (`review_id`) REFERENCES `reviews` (`id`),
  CONSTRAINT `fk_review_comments_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_comments`
--

LOCK TABLES `review_comments` WRITE;
/*!40000 ALTER TABLE `review_comments` DISABLE KEYS */;
INSERT INTO `review_comments` VALUES (1,'Fair point, it lines up with my own experience watching it.',1,3,NULL,'2025-12-03 11:56:49'),(2,'I see what you mean, and it’s a pretty reasonable interpretation.',1,4,1,'2025-12-03 11:56:50'),(3,'I get your point, and it adds nicely to the overall discussion.',1,5,2,'2025-12-03 11:56:50'),(4,'Interesting view, I can support that opinion to some extent.',1,6,3,'2025-12-03 11:56:51'),(5,'I see what you mean, and it’s a pretty reasonable interpretation.',1,7,4,'2025-12-03 11:56:51'),(6,'Interesting view, I can support that opinion to some extent.',1,3,NULL,'2025-12-03 11:57:47'),(7,'Makes sense, and it fits the general feel of the title for me too.',1,4,6,'2025-12-03 11:57:47'),(8,'I see what you mean, and it’s a pretty reasonable interpretation.',1,5,7,'2025-12-03 11:57:48'),(9,'I see what you mean, and it’s a pretty reasonable interpretation.',1,6,8,'2025-12-03 11:57:48'),(10,'Nice comment, I can relate to that perspective quite well.',1,7,9,'2025-12-03 11:57:49');
/*!40000 ALTER TABLE `review_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(2000) NOT NULL,
  `movie_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_reviews_movie_id` (`movie_id`),
  KEY `idx_reviews_user_id` (`user_id`),
  CONSTRAINT `fk_reviews_movies` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_reviews_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,'Some moments stood out, and the overall tone stayed stable and comfortable to watch.',1,3,'2025-12-03 10:44:30'),(2,'It felt smooth and easy to follow, delivering a generally positive impression overall.',2,3,'2025-12-03 10:44:30'),(3,'Good enough to watch once, with a simple story and clear presentation overall.',3,3,'2025-12-03 10:44:31'),(4,'Nothing extraordinary, but it kept my attention and delivered a solid overall impression.',4,3,'2025-12-03 10:44:31'),(5,'A decent piece of entertainment with stable pacing and a calm narrative approach.',5,3,'2025-12-03 10:44:32'),(6,'A decent piece of entertainment with stable pacing and a calm narrative approach.',6,3,'2025-12-03 10:44:33'),(7,'The story was consistent and paced well, offering a generally enjoyable viewing experience overall.',7,3,'2025-12-03 10:44:33'),(8,'Some moments stood out, and the overall tone stayed stable and comfortable to watch.',8,3,'2025-12-03 10:44:34'),(9,'Provides a comfortable neutral experience with a clean narrative and predictable progression.',9,3,'2025-12-03 10:44:34'),(10,'A decent piece of entertainment with stable pacing and a calm narrative approach.',10,3,'2025-12-03 10:44:35'),(11,'The production quality felt consistent, making the viewing experience reasonably enjoyable throughout.',11,3,'2025-12-03 10:44:36'),(12,'The production quality felt consistent, making the viewing experience reasonably enjoyable throughout.',12,3,'2025-12-03 10:44:36'),(13,'Good enough to watch once, with a simple story and clear presentation overall.',13,3,'2025-12-03 10:44:37'),(14,'Good enough to watch once, with a simple story and clear presentation overall.',14,3,'2025-12-03 10:44:37'),(15,'Characters were developed enough to keep me interested through most of the runtime.',15,3,'2025-12-03 10:44:38'),(16,'It felt smooth and easy to follow, delivering a generally positive impression overall.',16,3,'2025-12-03 10:44:39'),(17,'The production quality felt consistent, making the viewing experience reasonably enjoyable throughout.',17,3,'2025-12-03 10:44:39'),(18,'Provides a comfortable neutral experience with a clean narrative and predictable progression.',18,3,'2025-12-03 10:44:40'),(19,'Provides a comfortable neutral experience with a clean narrative and predictable progression.',19,3,'2025-12-03 10:44:40'),(20,'Visual style and direction felt balanced, contributing to a pleasant and steady atmosphere.',20,3,'2025-12-03 10:44:41'),(21,'Visual style and direction felt balanced, contributing to a pleasant and steady atmosphere.',10,4,'2025-12-03 10:44:42'),(22,'Characters were developed enough to keep me interested through most of the runtime.',11,4,'2025-12-03 10:44:42'),(23,'The production quality felt consistent, making the viewing experience reasonably enjoyable throughout.',12,4,'2025-12-03 10:44:43'),(24,'Provides a comfortable neutral experience with a clean narrative and predictable progression.',13,4,'2025-12-03 10:44:43'),(25,'A decent piece of entertainment with stable pacing and a calm narrative approach.',14,4,'2025-12-03 10:44:44'),(26,'Good enough to watch once, with a simple story and clear presentation overall.',15,4,'2025-12-03 10:44:45'),(27,'Provides a comfortable neutral experience with a clean narrative and predictable progression.',16,4,'2025-12-03 10:44:45'),(28,'Good enough to watch once, with a simple story and clear presentation overall.',17,4,'2025-12-03 10:44:46'),(29,'The production quality felt consistent, making the viewing experience reasonably enjoyable throughout.',18,4,'2025-12-03 10:44:46'),(30,'Good enough to watch once, with a simple story and clear presentation overall.',19,4,'2025-12-03 10:44:47'),(31,'The story was consistent and paced well, offering a generally enjoyable viewing experience overall.',20,4,'2025-12-03 10:44:48'),(32,'A decent piece of entertainment with stable pacing and a calm narrative approach.',20,5,'2025-12-03 10:44:48');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_roles_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `profile_image_url` varchar(512) DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `email_verified` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_users_email` (`email`),
  UNIQUE KEY `uk_users_nickname` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@mail.com','admin','$2a$10$V.x6hrUbrvy3qIyX7E8Pru4ymNk1CBMpBj4FwX7KXL4YWoaRD.SXO','Admin','Admin',NULL,_binary '\0',_binary ''),(2,'user@mail.com','user','$2a$10$V.x6hrUbrvy3qIyX7E8Pru4ymNk1CBMpBj4FwX7KXL4YWoaRD.SXO','User','User',NULL,_binary '\0',_binary ''),(3,'oliver_s@mail.com','oliver_s','$2a$10$fwMe2tEtHmdOtfLzJe61R.FmeTI409rYxpG2FK81WVE6o2oReVV5K',NULL,NULL,NULL,_binary '\0',_binary ''),(4,'emma_j@mail.com','emma_j','$2a$10$UrhdJL0.6cl5detb6wyiM.BVGA1F4l5ZUcY6v8GxxVRX/RTji9mbm',NULL,NULL,NULL,_binary '\0',_binary ''),(5,'liam_b@mail.com','liam_b','$2a$10$LMQC7DwBGQTEqpjkQ2Xy4OgnDAS659MhePrpxbPVCivNXh89ND1hG',NULL,NULL,NULL,_binary '\0',_binary ''),(6,'sophia_d@mail.com','sophia_d','$2a$10$DacFGSp4Lxvyz3E/eVii/uzxnFI4ca/tc2I/BCC355/hytB7.BU3.',NULL,NULL,NULL,_binary '\0',_binary ''),(7,'noah_w@mail.com','noah_w','$2a$10$EOq76PMQOhloYE.kNqioneUTSpqovKQ3LmwOqtn3EyzTD2xa/Ul.2',NULL,NULL,NULL,_binary '\0',_binary '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `idx_users_roles_role_id` (`role_id`),
  CONSTRAINT `fk_users_roles_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_users_roles_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist_items`
--

DROP TABLE IF EXISTS `wishlist_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `wishlist_id` bigint NOT NULL,
  `movie_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_wishlist_items_wishlist_movie` (`wishlist_id`,`movie_id`),
  KEY `idx_wishlist_items_movie_id` (`movie_id`),
  CONSTRAINT `fk_wishlist_items_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `fk_wishlist_items_wishlist` FOREIGN KEY (`wishlist_id`) REFERENCES `wishlists` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist_items`
--

LOCK TABLES `wishlist_items` WRITE;
/*!40000 ALTER TABLE `wishlist_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlists`
--

DROP TABLE IF EXISTS `wishlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlists` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_wishlists_user_id` (`user_id`),
  CONSTRAINT `fk_wishlists_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlists`
--

LOCK TABLES `wishlists` WRITE;
/*!40000 ALTER TABLE `wishlists` DISABLE KEYS */;
INSERT INTO `wishlists` VALUES (1,3),(2,4),(3,5),(4,6),(5,7);
/*!40000 ALTER TABLE `wishlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'movie_catalog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-08 12:41:49
