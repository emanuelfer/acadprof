-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: acadprofe
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.35-MariaDB

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'emanuel','1','a80e1c212420901edde8bbeb64037593');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `idTurma` int(11) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idAluno`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `idTurma_idx` (`idTurma`),
  CONSTRAINT `idTurmaAluno` FOREIGN KEY (`idTurma`) REFERENCES `turma` (`idTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (4,'Gabriel','1','456',1,'d6ee4e61af68a10f9bb9ee130313881f'),(5,'Guilherme','2','789',1,'192309aaddc500140db28668e1bbd8b5'),(6,'emanuel','3','5',2,'a80e1c212420901edde8bbeb64037593'),(7,'pedro','4','852',1,'c6cc8094c2dc07b700ffcc36d64e2138'),(8,'david','5','9654',1,'172522ec1028ab781d9dfd17eaca4427'),(9,'alexsandro','6','8987415',2,'902e3ffe40f2835d204a0e74ad0fcc1f'),(10,'debora','7','8888',3,'e99169dde5ede114db67001ca047a974'),(11,'elias','8','1177',1,'29a2b2e1849474d94d12051309c7b4d7'),(12,'lucas','9','255555',2,'dc53fc4f621c80bdc2fa0329a6123708'),(14,'Vitoria','10','24',3,'abd7a6ff9dede06a043127c2de751d56'),(15,'thayla','11','99997',3,'b7f79191bf741a8b14f592113af411b1'),(17,'felipe','12','5596',4,'7e04da88cbb8cc933c7b89fbfe121cca'),(18,'milan','13','130',4,'83227a721a3363d2c78381664c78657f');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula` (
  `idAula` int(11) NOT NULL AUTO_INCREMENT,
  `horario` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `semestre` varchar(45) DEFAULT NULL,
  `conteudo` varchar(45) NOT NULL,
  `idDisciplina` int(11) NOT NULL,
  `idTurma` int(11) NOT NULL,
  `idProfessor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAula`),
  KEY `idTurma_idx` (`idTurma`),
  KEY `idDisciplina_idx` (`idDisciplina`),
  KEY `idProfessor_idx` (`idProfessor`),
  CONSTRAINT `idDisciplinaAula` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idProfessor` FOREIGN KEY (`idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTurma` FOREIGN KEY (`idTurma`) REFERENCES `turma` (`idTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,'07h15 - 08h55','01/02/2019','2019.1	','Herança',1,2,1),(2,'08h55 - 10h35','01/02/2019','2019.1	','HTML básico',2,2,1),(3,'07h15 - 08h55','30/01/2019','2019.1	','Polimorfismo',1,1,1),(4,'07h15 - 08h55','03/02/2019','2019.1','Introdução à Química Orgânica',4,3,3),(5,'08h55 - 10h35','02/02/2019','2019.1','Reações Orgânicas',4,3,3),(6,'07h15 - 08h55','03/02/2019','2019.1','Inequação do Primeiro Grau',3,3,4),(7,'07h15 - 08h55','06/02/2019','2019.1','Design Responsivo',2,2,2),(8,'07h15 - 08h55','07/02/2019','2019.1','Conjuntos',3,1,4),(9,'13h15 - 16h30','14/02/2019','2019.1','Portas lógicas',5,4,8),(10,'07h15 - 08h55','14/02/2019','2019.1','Introdução ao arduino',6,4,8);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `idAvaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `nota` double NOT NULL,
  `parecer` varchar(45) NOT NULL,
  `data` varchar(45) NOT NULL,
  `idAluno` int(11) NOT NULL,
  `idAula` int(11) NOT NULL,
  PRIMARY KEY (`idAvaliacao`),
  KEY `idAluno_idx` (`idAluno`),
  KEY `idAvaliacaoAula_idx` (`idAula`),
  CONSTRAINT `idAluno` FOREIGN KEY (`idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idAula` FOREIGN KEY (`idAula`) REFERENCES `aula` (`idAula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,10,'muito boa','01/02/2018',6,1),(2,7,'Aula média','01/02/2018',6,2),(3,5,'Faltou explicar melhor','01/02/2019',5,3),(4,8.9,'Razoável','02/02/2019',4,3),(5,7.8,'Faltou mostrar mais exemplos práticos','03/02/2019',8,3),(6,10,'adjasdf','03/02/2019',9,1),(7,8.9,'Foi legal.','06/02/2019',10,4),(8,10,'Aula de qualidade.','06/02/2019',12,7),(9,10,'Ribamar é fera!','08/02/2019',5,8),(10,5.5,'Gostei não, professor!','09/02/2019',15,4),(11,8.6,'Muito bem exemplificada!','14/02/2019',17,9),(12,10,'Perfeita!','14/02/2019',17,10),(13,10,'gostei','14/02/2019',18,9),(14,7,'É o mínimo que se espera!','14/02/2019',18,10);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `idDepartamento_idx` (`idDepartamento`),
  CONSTRAINT `idDepartamentoCurso` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Informática','Info',1),(3,'Química','QM',2),(4,'Matemática','MTM',3),(5,'Eletrônica','ETNC',4);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `idCoordenador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCoordenador_idx` (`idCoordenador`),
  CONSTRAINT `idCoordenador` FOREIGN KEY (`idCoordenador`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Departamento Acadêmico de Informática','DAI',NULL),(2,'Departamento de Química','DQ',3),(3,'Departamento de Matemática','DEMAT',4),(4,'Departamento de Eletrônica','DETNC',NULL);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `idDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDisciplina`),
  KEY `idDepartamentoDisciplina_idx` (`idDepartamento`),
  CONSTRAINT `idDepartamentoDisciplina` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'Progamação Orientada a Objetos','POO',1),(2,'Autoria Web','AW',1),(3,'Matemática I','MTM',3),(4,'Química III','QM III',2),(5,'Circuitos Digitais I','CDI',4),(6,'Arduino Básico','AB',4);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `idProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `graduacao` varchar(45) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idProfessor`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  KEY `idDepartamento_idx` (`idDepartamento`),
  CONSTRAINT `idDepartamento` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'ulysses','001','Mestre',1,'6a39c2f21e6aaa086eb504e92036c282'),(2,'joao','002','Doutor',1,'dccd96c256bc7dd39bae41a405f25e43'),(3,'marcio','003','Pós-Graduado',2,'1b150854805cbe12194c8dbc55c900cd'),(4,'ribamar','004','Pós-Doutorado',3,'a303eb9e736aff0abbcd03ef1c026b90'),(5,'elaine','005','Mestrado',2,'fb47bb2639a2df6c3b4d36ab33a274ff'),(8,'sergio','006','Mestrado',4,'3bffa4ebdf4874e506c2b12405796aa5');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_disciplina`
--

DROP TABLE IF EXISTS `professor_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_disciplina` (
  `idProfessorDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `ch` varchar(5) DEFAULT NULL,
  `idProfessor` int(11) NOT NULL,
  `idDisciplina` int(11) NOT NULL,
  PRIMARY KEY (`idProfessorDisciplina`),
  KEY `idProfessor_idx` (`idProfessor`),
  KEY `idDisciplina_idx` (`idDisciplina`),
  CONSTRAINT `idDisciplinaDisciplina` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idProfessorDisciplina` FOREIGN KEY (`idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_disciplina`
--

LOCK TABLES `professor_disciplina` WRITE;
/*!40000 ALTER TABLE `professor_disciplina` DISABLE KEYS */;
INSERT INTO `professor_disciplina` VALUES (1,'80h',1,1),(2,'40h',1,2);
/*!40000 ALTER TABLE `professor_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `idTurma` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `modalidade` varchar(45) NOT NULL,
  `ano` varchar(5) NOT NULL,
  `turno` varchar(10) NOT NULL,
  `semestre` varchar(6) NOT NULL,
  `idCurso` int(11) NOT NULL,
  PRIMARY KEY (`idTurma`),
  KEY `idCurso_idx` (`idCurso`),
  CONSTRAINT `idCurso` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'602','Integrado','3ºano','Matutino','2019.1',1),(2,'603','Concomitante','1ºano','Vespertino','2019.1',1),(3,'511','Integrado','3','Diurno','2019.1',3),(4,'407','Integrado','2','Vespertino','2019.1',5);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-14 12:25:12
