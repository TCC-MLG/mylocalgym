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
INSERT INTO `checkin` VALUES (1,1,2,1,0),(2,0,3,1,1),(3,0,4,1,1);
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
  `cpf` int(14) DEFAULT NULL,
  `exame_medico` longtext,
  `estado` varchar(30) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `endereco` varchar(30) DEFAULT NULL,
  `validade_saldo` date DEFAULT NULL,
  `saldo` decimal(5,2) DEFAULT NULL,
  `ultima_recarga` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'Matheus siqueira',NULL,NULL,'mathgunz','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'joao',NULL,NULL,'joao','6321',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'siqueira',NULL,NULL,'siqueira','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_transacao`
--

LOCK TABLES `historico_transacao` WRITE;
/*!40000 ALTER TABLE `historico_transacao` DISABLE KEYS */;
INSERT INTO `historico_transacao` VALUES (1,'2016-09-15',20.00,2,1),(2,'2016-09-15',30.00,2,1),(3,'2016-08-15',25.00,2,1),(4,'2016-06-15',21.00,2,1),(11,'2016-05-15',30.00,2,1),(12,'2016-02-15',12.00,2,1),(13,'2016-09-17',30.00,2,1),(14,'2016-09-17',69.00,2,1);
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
  `tipo` varchar(30) NOT NULL,
  `id_academia` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_servicos_aca` (`id_academia`),
  CONSTRAINT `fk_servicos_aca` FOREIGN KEY (`id_academia`) REFERENCES `academia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
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

-- Dump completed on 2016-09-26 23:26:44
