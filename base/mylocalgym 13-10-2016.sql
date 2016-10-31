CREATE DATABASE  IF NOT EXISTS `mylocalgym` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mylocalgym`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mylocalgym
-- ------------------------------------------------------
-- Server version	5.6.31-log

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
-- Table structure for table `academia`
--

DROP TABLE IF EXISTS `academia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  `telefone` char(13) DEFAULT NULL,
  `cnpj` int(14) DEFAULT NULL,
  `razao_social` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` int(10) unsigned DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academia`
--

LOCK TABLES `academia` WRITE;
/*!40000 ALTER TABLE `academia` DISABLE KEYS */;
INSERT INTO `academia` VALUES (1,'sadas','1234','123',123456,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'math','1234','123',654321,NULL,'asp','asd','asd',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `academia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carteira_academia`
--

DROP TABLE IF EXISTS `carteira_academia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carteira_academia` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saldo` decimal(10,0) NOT NULL DEFAULT '0',
  `academiaId` int(11) NOT NULL DEFAULT '0',
  `dt_alteracao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `FK_carteira_academia_1` (`academiaId`),
  CONSTRAINT `FK_carteira_academia_1` FOREIGN KEY (`academiaId`) REFERENCES `academia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carteira_academia`
--

LOCK TABLES `carteira_academia` WRITE;
/*!40000 ALTER TABLE `carteira_academia` DISABLE KEYS */;
INSERT INTO `carteira_academia` VALUES (1,500,1,'2016-10-01 01:25:35'),(2,12,1,'2016-10-01 01:49:01'),(3,24,1,'2016-10-01 01:57:41'),(4,36,1,'2016-10-01 01:58:10'),(5,48,1,'2016-10-01 01:58:17'),(6,60,1,'2016-10-01 01:58:42'),(7,72,1,'2016-10-01 02:05:45'),(8,84,1,'2016-10-01 02:21:49'),(9,96,1,'2016-10-01 02:22:41'),(10,108,1,'2016-10-01 02:25:53'),(11,120,1,'2016-10-01 03:33:56'),(12,132,1,'2016-10-01 03:49:55'),(13,144,1,'2016-10-01 04:10:07'),(14,156,1,'2016-10-01 04:15:53'),(15,168,1,'2016-10-01 04:20:18'),(16,180,1,'2016-10-01 04:20:35'),(17,192,1,'2016-10-01 04:29:13'),(18,204,1,'2016-10-01 04:34:13'),(19,216,1,'2016-10-01 04:35:06'),(20,228,1,'2016-10-01 04:37:23'),(21,240,1,'2016-10-01 04:37:35'),(22,252,1,'2016-10-01 04:37:46');
/*!40000 ALTER TABLE `carteira_academia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carteira_cliente`
--

DROP TABLE IF EXISTS `carteira_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carteira_cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saldo` decimal(10,0) NOT NULL DEFAULT '0',
  `clienteId` int(11) NOT NULL DEFAULT '0',
  `dt_inclusao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `FK_carteira_cliente_1` (`clienteId`),
  CONSTRAINT `FK_carteira_cliente_1` FOREIGN KEY (`clienteId`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carteira_cliente`
--

LOCK TABLES `carteira_cliente` WRITE;
/*!40000 ALTER TABLE `carteira_cliente` DISABLE KEYS */;
INSERT INTO `carteira_cliente` VALUES (1,1000,4,'2016-09-28 23:02:40'),(2,1200,3,'2016-10-01 00:47:14'),(3,1100,2,'2016-10-01 00:58:23'),(4,988,2,'2016-10-01 00:59:49'),(7,976,2,'2016-10-01 01:06:41'),(8,964,2,'2016-10-01 01:06:56'),(9,952,2,'2016-10-01 01:07:41'),(10,940,2,'2016-10-01 01:08:31'),(11,940,2,'2016-10-01 01:08:47'),(16,1100,2,'2016-10-01 01:13:28'),(17,988,2,'2016-10-01 01:13:28'),(18,988,2,'2016-10-01 01:18:21'),(19,976,2,'2016-10-01 01:20:23'),(20,964,2,'2016-10-01 01:20:32'),(21,952,2,'2016-10-01 01:20:37'),(22,940,2,'2016-10-01 01:44:31'),(23,928,2,'2016-10-01 01:45:04'),(24,916,2,'2016-10-01 01:47:03'),(25,904,2,'2016-10-01 01:48:57'),(26,892,2,'2016-10-01 01:57:24'),(27,880,2,'2016-10-01 01:57:59'),(28,868,2,'2016-10-01 01:58:14'),(29,856,2,'2016-10-01 01:58:35'),(30,844,2,'2016-10-01 02:05:42'),(31,832,2,'2016-10-01 02:21:46'),(32,820,2,'2016-10-01 02:22:40'),(33,808,2,'2016-10-01 02:25:50'),(34,796,2,'2016-10-01 03:33:56'),(35,784,2,'2016-10-01 03:49:55'),(36,772,2,'2016-10-01 04:10:06'),(37,760,2,'2016-10-01 04:15:53'),(38,748,2,'2016-10-01 04:20:18'),(39,1188,3,'2016-10-01 04:20:35'),(40,736,2,'2016-10-01 04:29:11'),(41,1176,3,'2016-10-01 04:34:13'),(42,724,2,'2016-10-01 04:35:06'),(43,1164,3,'2016-10-01 04:37:23'),(44,712,2,'2016-10-01 04:37:35'),(45,988,4,'2016-10-01 04:37:46');
/*!40000 ALTER TABLE `carteira_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkin`
--

DROP TABLE IF EXISTS `checkin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `solicitacao_cliente` tinyint(1) NOT NULL DEFAULT '0',
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `id_academia` int(11) NOT NULL DEFAULT '0',
  `in_ativo_inativo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_checkin_1` (`id_cliente`) USING BTREE,
  KEY `FK_academia_id` (`id_academia`),
  CONSTRAINT `FK_academia_id` FOREIGN KEY (`id_academia`) REFERENCES `academia` (`id`),
  CONSTRAINT `FK_cliente_id` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkin`
--

LOCK TABLES `checkin` WRITE;
/*!40000 ALTER TABLE `checkin` DISABLE KEYS */;
INSERT INTO `checkin` VALUES (1,1,2,1,0),(2,1,3,1,0),(3,1,4,1,0);
/*!40000 ALTER TABLE `checkin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telefone` char(13) DEFAULT NULL,
  `apelido` varchar(10) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  `cpf` bigint(12) unsigned DEFAULT NULL,
  `exame_medico` longtext,
  `estado` varchar(30) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `endereco` varchar(30) DEFAULT NULL,
  `validade_saldo` date DEFAULT NULL,
  `ultima_recarga` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `apelido_UNIQUE` (`apelido`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'Matheus siqueira','mathgunz@gmail.com',NULL,'mathgunz','12345678',41758397802,NULL,NULL,NULL,NULL,NULL,NULL),(3,'joao',NULL,NULL,'joao','6321',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'siqueira',NULL,NULL,'siqueira','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'Matheus Siqueira Graciano','math@gmail1.com','11963155279','mathgunz1','1234',41758397801,NULL,'São Joçao','São paulo','mathgunz1',NULL,NULL),(12,'Matheus Siqueira Graciano','math@gmail11.com','11963155279','mathgunz12','1234',41758397803,NULL,'São Joçao','São paulo','mathgunz12',NULL,NULL),(15,'edfff','gfrr@fbg.com','5555','fdd','12345678',25343767729,NULL,'fff','ff','fdd',NULL,NULL),(16,'ffdddff','dd@fff.cfr','5555','cff','12345678',65193861547,NULL,'dd','rff','cff',NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_credito`
--

DROP TABLE IF EXISTS `historico_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_credito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `valor` decimal(5,3) DEFAULT NULL,
  `data_credito` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_credito` (`id_cliente`),
  CONSTRAINT `fk_cliente_credito` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_credito`
--

LOCK TABLES `historico_credito` WRITE;
/*!40000 ALTER TABLE `historico_credito` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_transacao`
--

DROP TABLE IF EXISTS `historico_transacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_transacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_transacao` date DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_academia` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_transacao_cli_aca` (`id_cliente`),
  KEY `FK_historico_transacao_2` (`id_academia`),
  CONSTRAINT `FK_historico_transacao_2` FOREIGN KEY (`id_academia`) REFERENCES `academia` (`id`),
  CONSTRAINT `fk_transacao_cli_aca` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_transacao`
--

LOCK TABLES `historico_transacao` WRITE;
/*!40000 ALTER TABLE `historico_transacao` DISABLE KEYS */;
INSERT INTO `historico_transacao` VALUES (1,'2016-09-15',20.00,2,1),(2,'2016-09-15',30.00,2,1),(3,'2016-08-15',25.00,2,1),(4,'2016-06-15',21.00,2,1),(11,'2016-05-15',30.00,2,1),(12,'2016-02-15',12.00,2,1),(13,'2016-09-17',30.00,2,1),(14,'2016-09-17',69.00,2,1),(16,'2016-10-01',NULL,2,1),(17,'2016-10-01',NULL,2,1),(18,'2016-10-01',NULL,2,1),(19,'2016-10-01',NULL,2,1),(20,'2016-10-01',NULL,2,1),(21,'2016-10-01',NULL,2,1),(22,'2016-10-01',NULL,2,1),(23,'2016-10-01',NULL,3,1),(24,'2016-10-01',NULL,2,1),(25,'2016-10-01',NULL,3,1),(26,'2016-10-01',NULL,2,1),(27,'2016-10-01',NULL,3,1),(28,'2016-10-01',NULL,2,1),(29,'2016-10-01',NULL,4,1);
/*!40000 ALTER TABLE `historico_transacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `preco` decimal(5,2) DEFAULT NULL,
  `tipo` varchar(30) NOT NULL DEFAULT '',
  `id_academia` int(11) NOT NULL,
  `padrao` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_servicos_aca` (`id_academia`),
  CONSTRAINT `fk_servicos_aca` FOREIGN KEY (`id_academia`) REFERENCES `academia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'padrao',12.00,'A',1,0);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-13  7:53:58
