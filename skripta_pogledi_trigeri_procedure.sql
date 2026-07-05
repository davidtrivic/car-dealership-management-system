-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: projekat_baze_podataka
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ID_Agent` FOREIGN KEY (`ID`) REFERENCES `zaposleni` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1),(2),(5),(6),(7);
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dio`
--

DROP TABLE IF EXISTS `dio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dio` (
  `IdDijela` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  `Zaliha` int NOT NULL,
  `MinimalnaKolicina` int NOT NULL,
  PRIMARY KEY (`IdDijela`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dio`
--

LOCK TABLES `dio` WRITE;
/*!40000 ALTER TABLE `dio` DISABLE KEYS */;
INSERT INTO `dio` VALUES (1,'Filter ulja',50,10),(2,'Kočione pločice',30,5),(3,'Svjećice',100,20),(4,'Amortizer',15,3);
/*!40000 ALTER TABLE `dio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dobavljac`
--

DROP TABLE IF EXISTS `dobavljac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dobavljac` (
  `IdDobavljaca` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  `Adresa` varchar(45) NOT NULL,
  `Telefon` varchar(20) NOT NULL,
  PRIMARY KEY (`IdDobavljaca`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dobavljac`
--

LOCK TABLES `dobavljac` WRITE;
/*!40000 ALTER TABLE `dobavljac` DISABLE KEYS */;
INSERT INTO `dobavljac` VALUES (1,'AutoDijel d.o.o.','Industrijska 15, Banja Luka','051123456'),(2,'Motopart d.o.o.','Kralja Alfonsa 8, Sarajevo','033234567'),(3,'TechPart d.o.o.','Karađorđeva 33, Banja Luka','051345678'),(4,'EuroAuto d.o.o.','Zmaj Jovina 2, Sarajevo','033456789');
/*!40000 ALTER TABLE `dobavljac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dostupna_vozila_info`
--

DROP TABLE IF EXISTS `dostupna_vozila_info`;
/*!50001 DROP VIEW IF EXISTS `dostupna_vozila_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `dostupna_vozila_info` AS SELECT 
 1 AS `VIN`,
 1 AS `Marka`,
 1 AS `Model`,
 1 AS `Godiste`,
 1 AS `Boja`,
 1 AS `Opis`,
 1 AS `Kilometraza`,
 1 AS `ZapreminaMotora`,
 1 AS `VrstaGoriva`,
 1 AS `Pogon`,
 1 AS `Oprema`,
 1 AS `NabavnaCijena`,
 1 AS `ProdajnaCijena`,
 1 AS `Status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `komercijalni_podaci`
--

DROP TABLE IF EXISTS `komercijalni_podaci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `komercijalni_podaci` (
  `VIN` char(17) NOT NULL,
  `NabavnaCijena` decimal(10,2) NOT NULL,
  `ProdajnaCijena` decimal(10,2) NOT NULL,
  `Status` enum('Dostupno','Rezervisano','Prodano') NOT NULL,
  PRIMARY KEY (`VIN`),
  CONSTRAINT `FK_VIN_KomercijalniPodaci` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komercijalni_podaci`
--

LOCK TABLES `komercijalni_podaci` WRITE;
/*!40000 ALTER TABLE `komercijalni_podaci` DISABLE KEYS */;
INSERT INTO `komercijalni_podaci` VALUES ('1HGCM82633A123456',18000.00,22000.00,'Dostupno'),('2HGCM82633A654321',24000.00,28000.00,'Dostupno'),('3HGCM82633A111222',15000.00,19500.00,'Dostupno'),('4HCCD82633A459231',95000.00,107000.00,'Dostupno'),('4HGCM82633A333444',16000.00,20000.00,'Prodano'),('5HGCM82633A555666',22000.00,27500.00,'Prodano'),('6HGCM82633A777888',35000.00,42000.00,'Dostupno'),('7HGCM82633A999000',11000.00,14500.00,'Prodano'),('8HGCM82633A111333',21000.00,25500.00,'Dostupno'),('9HGCM82633A444555',8500.00,11000.00,'Prodano'),('AHGCM82633A666777',14000.00,17500.00,'Dostupno'),('BHGCM82633A888999',23000.00,27000.00,'Rezervisano'),('CHGCM82633A000111',17000.00,21500.00,'Dostupno'),('DHGCM82633A222333',13500.00,17000.00,'Prodano'),('EHGCM82633A444555',19000.00,23500.00,'Dostupno'),('FHGCM82633A666777',7000.00,9500.00,'Dostupno'),('GHGCM82633A888000',22000.00,26500.00,'Rezervisano');
/*!40000 ALTER TABLE `komercijalni_podaci` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `validacija_cijene` BEFORE INSERT ON `komercijalni_podaci` FOR EACH ROW BEGIN
    IF NEW.ProdajnaCijena < NEW.NabavnaCijena THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Prodajna cijena ne može biti manja od nabavne!';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `kupac`
--

DROP TABLE IF EXISTS `kupac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kupac` (
  `JMB` char(13) NOT NULL,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  `Adresa` varchar(45) NOT NULL,
  `Telefon` varchar(15) NOT NULL,
  `Email` varchar(45) NOT NULL,
  PRIMARY KEY (`JMB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupac`
--

LOCK TABLES `kupac` WRITE;
/*!40000 ALTER TABLE `kupac` DISABLE KEYS */;
INSERT INTO `kupac` VALUES ('1111222233334','Nikola','Nikolić','Kralja Petra 12, Banja Luka','065345678','nikola@email.com'),('1231231231231','Petar','Petrović','Bulevar Stepe Stepanovića 12, Banja Luka','065123951','petar111@email.com'),('1234567890123','Stefan','Stefanović','Ulica bb, Banja Luka','065123456','stefan@email.com'),('2222333344445','Aleksa','Aleksić','Vidovdanska 3, Banja Luka','065456789','aleksa@email.com'),('3333444455556','Sandra','Sandrić','Nemanjina 7, Banja Luka','066567890','sandra@email.com'),('4444555566667','Dragan','Draganović','Svetosavska 22, Banja Luka','065678901','dragan@email.com'),('5555666677778','Jelena','Jelenić','Majke Jugovića 1, Banja Luka','066789012','jelena@email.com'),('6666777788889','Vladimir','Vladimirović','Cara Dušana 9, Banja Luka','065890123','vladimir@email.com'),('7777888899990','Kristina','Kristić','Kneza Miloša 4, Banja Luka','066901234','kristina@email.com'),('8888999900001','Dejan','Dejanović','Sutješka 18, Banja Luka','065012345','dejan@email.com'),('9876543210987','Maja','Majić','Cara Lazara 5, Banja Luka','066234567','maja@email.com'),('9999000011112','Milica','Miličić','Jevrejska 6, Banja Luka','066123456','milica@email.com');
/*!40000 ALTER TABLE `kupac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `narudzba`
--

DROP TABLE IF EXISTS `narudzba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `narudzba` (
  `IdNarudzbe` int NOT NULL AUTO_INCREMENT,
  `IdDobavljaca` int NOT NULL,
  `DatumNarudzbe` date NOT NULL,
  `Status` enum('Naruceno','Primljeno') NOT NULL,
  PRIMARY KEY (`IdNarudzbe`),
  KEY `FK_IdDobavljaca_Narudzba` (`IdDobavljaca`),
  CONSTRAINT `FK_IdDobavljaca_Narudzba` FOREIGN KEY (`IdDobavljaca`) REFERENCES `dobavljac` (`IdDobavljaca`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `narudzba`
--

LOCK TABLES `narudzba` WRITE;
/*!40000 ALTER TABLE `narudzba` DISABLE KEYS */;
INSERT INTO `narudzba` VALUES (1,1,'2026-05-01','Primljeno'),(2,2,'2026-05-20','Naruceno'),(3,1,'2026-03-15','Primljeno'),(4,3,'2026-04-10','Primljeno'),(5,4,'2026-05-25','Naruceno');
/*!40000 ALTER TABLE `narudzba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `nova_vozila_info`
--

DROP TABLE IF EXISTS `nova_vozila_info`;
/*!50001 DROP VIEW IF EXISTS `nova_vozila_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `nova_vozila_info` AS SELECT 
 1 AS `VIN`,
 1 AS `Marka`,
 1 AS `Model`,
 1 AS `Godiste`,
 1 AS `Boja`,
 1 AS `Opis`,
 1 AS `PeriodGarancije`,
 1 AS `Kilometraza`,
 1 AS `ZapreminaMotora`,
 1 AS `VrstaGoriva`,
 1 AS `Pogon`,
 1 AS `Oprema`,
 1 AS `NabavnaCijena`,
 1 AS `ProdajnaCijena`,
 1 AS `Status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `novo_vozilo`
--

DROP TABLE IF EXISTS `novo_vozilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `novo_vozilo` (
  `VIN` char(17) NOT NULL,
  `PeriodGarancije` int NOT NULL,
  PRIMARY KEY (`VIN`),
  CONSTRAINT `FK_VIN_NovoVozilo` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novo_vozilo`
--

LOCK TABLES `novo_vozilo` WRITE;
/*!40000 ALTER TABLE `novo_vozilo` DISABLE KEYS */;
INSERT INTO `novo_vozilo` VALUES ('1HGCM82633A123456',24),('2HGCM82633A654321',36),('4HCCD82633A459231',60),('6HGCM82633A777888',36),('8HGCM82633A111333',36),('BHGCM82633A888999',36),('EHGCM82633A444555',84),('GHGCM82633A888000',36);
/*!40000 ALTER TABLE `novo_vozilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `placanje`
--

DROP TABLE IF EXISTS `placanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `placanje` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Tip` enum('Kredit','Gotovina','Lizing') NOT NULL,
  `Banka` varchar(45) DEFAULT NULL,
  `BrojRata` int DEFAULT NULL,
  `IznosRate` decimal(10,2) DEFAULT NULL,
  `Avans` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placanje`
--

LOCK TABLES `placanje` WRITE;
/*!40000 ALTER TABLE `placanje` DISABLE KEYS */;
INSERT INTO `placanje` VALUES (1,'Gotovina',NULL,NULL,NULL,NULL),(2,'Kredit','UniCredit Bank',48,250.00,3000.00),(3,'Lizing','Raiffeisen Leasing',36,320.00,2000.00),(4,'Gotovina',NULL,NULL,NULL,NULL),(5,'Kredit','NLB Banka',60,380.00,4000.00),(6,'Lizing','S-Leasing',48,290.00,2500.00),(7,'Gotovina',NULL,NULL,NULL,NULL),(8,'Kredit','Sparkasse',36,520.00,5000.00),(9,'Lizing','UniCredit Leasing',60,210.00,1500.00),(10,'Gotovina',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `placanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `polovna_vozila_info`
--

DROP TABLE IF EXISTS `polovna_vozila_info`;
/*!50001 DROP VIEW IF EXISTS `polovna_vozila_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `polovna_vozila_info` AS SELECT 
 1 AS `VIN`,
 1 AS `Marka`,
 1 AS `Model`,
 1 AS `Godiste`,
 1 AS `Boja`,
 1 AS `Opis`,
 1 AS `BrojPrethodnihVlasnika`,
 1 AS `Kilometraza`,
 1 AS `ZapreminaMotora`,
 1 AS `VrstaGoriva`,
 1 AS `Pogon`,
 1 AS `Oprema`,
 1 AS `NabavnaCijena`,
 1 AS `ProdajnaCijena`,
 1 AS `Status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `polovno_vozilo`
--

DROP TABLE IF EXISTS `polovno_vozilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polovno_vozilo` (
  `VIN` char(17) NOT NULL,
  `BrojPrethodnihVlasnika` int NOT NULL,
  PRIMARY KEY (`VIN`),
  CONSTRAINT `FK_VIN_PolovnoVozilo` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polovno_vozilo`
--

LOCK TABLES `polovno_vozilo` WRITE;
/*!40000 ALTER TABLE `polovno_vozilo` DISABLE KEYS */;
INSERT INTO `polovno_vozilo` VALUES ('3HGCM82633A111222',2),('4HGCM82633A333444',1),('5HGCM82633A555666',1),('7HGCM82633A999000',2),('9HGCM82633A444555',2),('AHGCM82633A666777',1),('CHGCM82633A000111',1),('DHGCM82633A222333',1),('FHGCM82633A666777',3);
/*!40000 ALTER TABLE `polovno_vozilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `popravka`
--

DROP TABLE IF EXISTS `popravka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `popravka` (
  `IdNaloga` int NOT NULL,
  `IdDijela` int NOT NULL,
  `DatumPopravke` date NOT NULL,
  `UtrosenaKolicina` int NOT NULL,
  `UtrosenoVrijeme` int NOT NULL,
  PRIMARY KEY (`IdNaloga`,`IdDijela`,`DatumPopravke`),
  KEY `FK_IdDijela_Popravka` (`IdDijela`),
  CONSTRAINT `FK_IdDijela_Popravka` FOREIGN KEY (`IdDijela`) REFERENCES `dio` (`IdDijela`),
  CONSTRAINT `FK_IdNaloga_Popravka` FOREIGN KEY (`IdNaloga`) REFERENCES `radni_nalog` (`IdNaloga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popravka`
--

LOCK TABLES `popravka` WRITE;
/*!40000 ALTER TABLE `popravka` DISABLE KEYS */;
INSERT INTO `popravka` VALUES (1,1,'2026-05-10',1,30),(1,3,'2026-05-10',4,15),(2,2,'2026-05-15',2,60),(3,1,'2026-02-15',1,45),(4,1,'2026-03-10',1,30),(4,3,'2026-03-10',2,20),(5,4,'2026-04-01',2,90),(6,1,'2026-04-20',1,30),(6,2,'2026-04-20',2,60),(7,3,'2026-05-05',4,20),(8,2,'2026-05-20',4,75);
/*!40000 ALTER TABLE `popravka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodaja`
--

DROP TABLE IF EXISTS `prodaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodaja` (
  `IdProdaje` int NOT NULL AUTO_INCREMENT,
  `ID_Agenta` int NOT NULL,
  `JMB_Kupca` char(13) NOT NULL,
  `VIN` char(17) NOT NULL,
  `ID_Placanja` int NOT NULL,
  `Datum` date NOT NULL,
  `Cijena` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdProdaje`),
  KEY `FK_ID_Agenta_Prodaja` (`ID_Agenta`),
  KEY `FK_JMB_Kupca_Prodaja` (`JMB_Kupca`),
  KEY `FK_VIN_Prodaja` (`VIN`),
  KEY `FK_ID_Placanja_Prodaja` (`ID_Placanja`),
  CONSTRAINT `FK_ID_Agenta_Prodaja` FOREIGN KEY (`ID_Agenta`) REFERENCES `agent` (`ID`),
  CONSTRAINT `FK_ID_Placanja_Prodaja` FOREIGN KEY (`ID_Placanja`) REFERENCES `placanje` (`ID`),
  CONSTRAINT `FK_JMB_Kupca_Prodaja` FOREIGN KEY (`JMB_Kupca`) REFERENCES `kupac` (`JMB`),
  CONSTRAINT `FK_VIN_Prodaja` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodaja`
--

LOCK TABLES `prodaja` WRITE;
/*!40000 ALTER TABLE `prodaja` DISABLE KEYS */;
INSERT INTO `prodaja` VALUES (1,1,'1234567890123','4HGCM82633A333444',1,'2026-03-15',20000.00),(2,1,'2222333344445','5HGCM82633A555666',4,'2026-01-10',27500.00),(3,2,'3333444455556','7HGCM82633A999000',5,'2026-01-22',14500.00),(4,5,'4444555566667','9HGCM82633A444555',7,'2026-02-05',11000.00),(5,1,'5555666677778','DHGCM82633A222333',6,'2026-02-18',17000.00),(6,6,'6666777788889','1HGCM82633A123456',4,'2026-03-02',22000.00),(7,2,'7777888899990','3HGCM82633A111222',5,'2026-03-20',19500.00),(8,5,'8888999900001','4HGCM82633A333444',7,'2026-04-05',20000.00);
/*!40000 ALTER TABLE `prodaja` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `provjera_dostupnosti_vozila` BEFORE INSERT ON `prodaja` FOR EACH ROW begin
	declare vStatus ENUM('Dostupno', 'Rezervisano', 'Prodano');
    
	select Status into vStatus
    from Komercijalni_Podaci
    where new.VIN = VIN;
    
	if vStatus != 'Dostupno' then
    signal sqlstate '45000'
    set message_text = 'Vozilo nije dostupno za prodaju!';
    end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `postavi_datum_prodaje` BEFORE INSERT ON `prodaja` FOR EACH ROW BEGIN
    IF NEW.Datum IS NULL THEN
        SET NEW.Datum = CURDATE();
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `promjena_statusa_vozila` AFTER INSERT ON `prodaja` FOR EACH ROW BEGIN
	UPDATE Komercijalni_Podaci
    SET Status = "Prodano"
    WHERE VIN = new.VIN;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `prodaja_po_agentu`
--

DROP TABLE IF EXISTS `prodaja_po_agentu`;
/*!50001 DROP VIEW IF EXISTS `prodaja_po_agentu`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prodaja_po_agentu` AS SELECT 
 1 AS `ID_Agenta`,
 1 AS `Ime_Agenta`,
 1 AS `Prezime_Agenta`,
 1 AS `Ukupno_Prodaja`,
 1 AS `Ukupna_Vrijednost`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `prodaje_info`
--

DROP TABLE IF EXISTS `prodaje_info`;
/*!50001 DROP VIEW IF EXISTS `prodaje_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prodaje_info` AS SELECT 
 1 AS `IdProdaje`,
 1 AS `ID_Agenta`,
 1 AS `Ime_Agenta`,
 1 AS `Prezime_Agenta`,
 1 AS `JMB_Kupca`,
 1 AS `Ime_Kupca`,
 1 AS `Prezime_Kupca`,
 1 AS `VIN_Vozila`,
 1 AS `Marka_Vozila`,
 1 AS `Model_Vozila`,
 1 AS `Godiste_Vozila`,
 1 AS `ID_Placanja`,
 1 AS `Tip_Placanja`,
 1 AS `Datum_Prodaje`,
 1 AS `Cijena`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `racun`
--

DROP TABLE IF EXISTS `racun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `racun` (
  `IdNaloga` int NOT NULL,
  `Iznos` decimal(10,2) NOT NULL,
  `DatumIzdavanja` date NOT NULL,
  PRIMARY KEY (`IdNaloga`),
  CONSTRAINT `FK_IdNaloga_Racun` FOREIGN KEY (`IdNaloga`) REFERENCES `radni_nalog` (`IdNaloga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racun`
--

LOCK TABLES `racun` WRITE;
/*!40000 ALTER TABLE `racun` DISABLE KEYS */;
INSERT INTO `racun` VALUES (1,125.00,'2026-05-10'),(3,91.50,'2026-02-15'),(4,86.40,'2026-03-10'),(5,165.00,'2026-04-01'),(6,195.00,'2026-04-20');
/*!40000 ALTER TABLE `racun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radni_nalog`
--

DROP TABLE IF EXISTS `radni_nalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radni_nalog` (
  `IdNaloga` int NOT NULL AUTO_INCREMENT,
  `VIN` char(17) NOT NULL,
  `JMB_Vlasnika` char(13) NOT NULL,
  `IdTehnicara` int NOT NULL,
  `OpisZahtjeva` varchar(250) NOT NULL,
  `DatumPrijema` date NOT NULL,
  `Status` enum('Primljeno','U radu','Zavrseno','Isporuceno') NOT NULL,
  `CijenaRada` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdNaloga`),
  KEY `FK_ID_RadniNalog` (`IdTehnicara`),
  KEY `FK_VIN_RadniNalog` (`VIN`),
  KEY `FK_JMB_Vlasnika_RadniNalog` (`JMB_Vlasnika`),
  CONSTRAINT `FK_ID_RadniNalog` FOREIGN KEY (`IdTehnicara`) REFERENCES `servisni_tehnicar` (`ID`),
  CONSTRAINT `FK_JMB_Vlasnika_RadniNalog` FOREIGN KEY (`JMB_Vlasnika`) REFERENCES `kupac` (`JMB`),
  CONSTRAINT `FK_VIN_RadniNalog` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radni_nalog`
--

LOCK TABLES `radni_nalog` WRITE;
/*!40000 ALTER TABLE `radni_nalog` DISABLE KEYS */;
INSERT INTO `radni_nalog` VALUES (1,'3HGCM82633A111222','1111222233334',3,'Redovni servis i zamjena filtera','2026-05-10','Zavrseno',50.00),(2,'4HGCM82633A333444','1234567890123',4,'Zamjena kočionih pločica','2026-05-15','U radu',50.00),(3,'5HGCM82633A555666','2222333344445',3,'Zamjena ulja i filtera','2026-02-15','Zavrseno',50.00),(4,'7HGCM82633A999000','3333444455556',4,'Servis mjenjača','2026-03-10','Zavrseno',50.00),(5,'9HGCM82633A444555','4444555566667',8,'Zamjena amortizera','2026-04-01','Zavrseno',50.00),(6,'DHGCM82633A222333','5555666677778',9,'Dijagnostika i servis','2026-04-20','Zavrseno',50.00),(7,'1HGCM82633A123456','6666777788889',3,'Zamjena svjećica i filtera','2026-05-05','U radu',50.00),(8,'3HGCM82633A111222','7777888899990',4,'Kočioni sistem','2026-05-20','Primljeno',50.00);
/*!40000 ALTER TABLE `radni_nalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servisni_tehnicar`
--

DROP TABLE IF EXISTS `servisni_tehnicar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servisni_tehnicar` (
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ID_ServisniTehnicar` FOREIGN KEY (`ID`) REFERENCES `zaposleni` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servisni_tehnicar`
--

LOCK TABLES `servisni_tehnicar` WRITE;
/*!40000 ALTER TABLE `servisni_tehnicar` DISABLE KEYS */;
INSERT INTO `servisni_tehnicar` VALUES (3),(4),(8),(9);
/*!40000 ALTER TABLE `servisni_tehnicar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavka`
--

DROP TABLE IF EXISTS `stavka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stavka` (
  `IdDijela` int NOT NULL,
  `IdNarudzbe` int NOT NULL,
  `Cijena` decimal(10,2) NOT NULL,
  `Kolicina` int NOT NULL,
  PRIMARY KEY (`IdDijela`,`IdNarudzbe`),
  KEY `FK_IdNarudzbe_Stavka` (`IdNarudzbe`),
  CONSTRAINT `FK_IdDijela_Stavka` FOREIGN KEY (`IdDijela`) REFERENCES `dio` (`IdDijela`),
  CONSTRAINT `FK_IdNarudzbe_Stavka` FOREIGN KEY (`IdNarudzbe`) REFERENCES `narudzba` (`IdNarudzbe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavka`
--

LOCK TABLES `stavka` WRITE;
/*!40000 ALTER TABLE `stavka` DISABLE KEYS */;
INSERT INTO `stavka` VALUES (1,1,8.50,20),(1,3,8.50,30),(1,5,8.50,25),(2,2,25.00,10),(2,3,25.00,15),(3,1,3.20,50),(3,4,3.20,100),(3,5,3.20,60),(4,2,45.00,5),(4,4,45.00,8);
/*!40000 ALTER TABLE `stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `sva_vozila_info`
--

DROP TABLE IF EXISTS `sva_vozila_info`;
/*!50001 DROP VIEW IF EXISTS `sva_vozila_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sva_vozila_info` AS SELECT 
 1 AS `VIN`,
 1 AS `Marka`,
 1 AS `Model`,
 1 AS `Godiste`,
 1 AS `Boja`,
 1 AS `Opis`,
 1 AS `Kilometraza`,
 1 AS `ZapreminaMotora`,
 1 AS `VrstaGoriva`,
 1 AS `Pogon`,
 1 AS `Oprema`,
 1 AS `NabavnaCijena`,
 1 AS `ProdajnaCijena`,
 1 AS `Status`,
 1 AS `TipVozila`,
 1 AS `PeriodGarancije`,
 1 AS `BrojPrethodnihVlasnika`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tehnicka_specifikacija`
--

DROP TABLE IF EXISTS `tehnicka_specifikacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tehnicka_specifikacija` (
  `VIN` char(17) NOT NULL,
  `Kilometraza` int NOT NULL,
  `ZapreminaMotora` int NOT NULL,
  `VrstaGoriva` varchar(10) NOT NULL,
  `Pogon` varchar(20) NOT NULL,
  `Oprema` varchar(45) NOT NULL,
  PRIMARY KEY (`VIN`),
  CONSTRAINT `FK_VIN_TehnickaSpecifikacija` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tehnicka_specifikacija`
--

LOCK TABLES `tehnicka_specifikacija` WRITE;
/*!40000 ALTER TABLE `tehnicka_specifikacija` DISABLE KEYS */;
INSERT INTO `tehnicka_specifikacija` VALUES ('1HGCM82633A123456',15000,1600,'Dizel','Prednji','Navigacija, klima'),('2HGCM82633A654321',0,1800,'Benzin','Prednji','Full oprema'),('3HGCM82633A111222',85000,2000,'Dizel','Zadnji','Koža, navigacija'),('4HCCD82633A459231',25000,1984,'Dizel','Svi','Senzori, klima, navigacija'),('4HGCM82633A333444',42000,1400,'Benzin','Prednji','Klima, senzori'),('5HGCM82633A555666',35000,2000,'Dizel','Prednji','Koža, navigacija, panorama'),('6HGCM82633A777888',18000,2200,'Dizel','Zadnji','Full oprema, AMG paket'),('7HGCM82633A999000',62000,1500,'Benzin','Prednji','Klima, navigacija'),('8HGCM82633A111333',0,1600,'Benzin','Prednji','Full oprema, kamera'),('9HGCM82633A444555',88000,1600,'Dizel','Prednji','Klima, tempomat'),('AHGCM82633A666777',28000,1400,'Benzin','Prednji','Klima, senzori, kamera'),('BHGCM82633A888999',0,1500,'Benzin','Prednji','Full oprema, Honda Sensing'),('CHGCM82633A000111',45000,1600,'Dizel','Svi','Navigacija, panorama, koža'),('DHGCM82633A222333',22000,1400,'Benzin','Prednji','Klima, navigacija, kamera'),('EHGCM82633A444555',0,1600,'Benzin','Prednji','Full oprema, garancija 7g'),('FHGCM82633A666777',95000,1400,'Dizel','Prednji','Klima, tempomat'),('GHGCM82633A888000',0,2000,'Benzin','Prednji','Full oprema, Skyactiv');
/*!40000 ALTER TABLE `tehnicka_specifikacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testna_voznja`
--

DROP TABLE IF EXISTS `testna_voznja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testna_voznja` (
  `VIN` char(17) NOT NULL,
  `JMB_Kupca` char(13) NOT NULL,
  `ID_Agenta` int NOT NULL,
  `DatumVoznje` date NOT NULL,
  PRIMARY KEY (`VIN`,`JMB_Kupca`,`ID_Agenta`,`DatumVoznje`),
  KEY `FK_JMB_Kupca_TestnaVoznja` (`JMB_Kupca`),
  KEY `FK_ID_Agenta_TestnaVoznja` (`ID_Agenta`),
  CONSTRAINT `FK_ID_Agenta_TestnaVoznja` FOREIGN KEY (`ID_Agenta`) REFERENCES `agent` (`ID`),
  CONSTRAINT `FK_JMB_Kupca_TestnaVoznja` FOREIGN KEY (`JMB_Kupca`) REFERENCES `kupac` (`JMB`),
  CONSTRAINT `FK_VIN_TestnaVoznja` FOREIGN KEY (`VIN`) REFERENCES `vozilo` (`VIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testna_voznja`
--

LOCK TABLES `testna_voznja` WRITE;
/*!40000 ALTER TABLE `testna_voznja` DISABLE KEYS */;
INSERT INTO `testna_voznja` VALUES ('1HGCM82633A123456','1234567890123',1,'2026-04-10'),('3HGCM82633A111222','1111222233334',1,'2026-05-03'),('6HGCM82633A777888','2222333344445',1,'2026-01-08'),('CHGCM82633A000111','6666777788889',1,'2026-03-01'),('EHGCM82633A444555','2222333344445',1,'2026-05-05'),('2HGCM82633A654321','9876543210987',2,'2026-04-12'),('8HGCM82633A111333','1111222233334',2,'2026-05-18'),('8HGCM82633A111333','3333444455556',2,'2026-01-20'),('EHGCM82633A444555','4444555566667',2,'2026-06-16'),('FHGCM82633A666777','7777888899990',2,'2026-03-18'),('AHGCM82633A666777','4444555566667',5,'2026-02-03'),('GHGCM82633A888000','8888999900001',5,'2026-04-02'),('6HGCM82633A777888','9999000011112',6,'2026-04-20'),('EHGCM82633A444555','5555666677778',6,'2026-02-15');
/*!40000 ALTER TABLE `testna_voznja` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `provjera_dostupnosti_testna_voznja` BEFORE INSERT ON `testna_voznja` FOR EACH ROW begin
	declare vStatus ENUM('Dostupno', 'Rezervisano', 'Prodano');
    
	select Status into vStatus
    from Komercijalni_Podaci
    where new.VIN = VIN;
    
	if vStatus != 'Dostupno' then
    signal sqlstate '45000'
    set message_text = 'Vozilo nije dostupno za testnu voznju!';
    end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `provjera_duplikat_testna_voznja` BEFORE INSERT ON `testna_voznja` FOR EACH ROW BEGIN
    DECLARE v_BrojVoznjiDanas INT;
    
    SELECT COUNT(*) INTO v_BrojVoznjiDanas
    FROM Testna_Voznja
    WHERE VIN = NEW.VIN
      AND JMB_Kupca = NEW.JMB_Kupca
      AND DatumVoznje = NEW.DatumVoznje;
    
    IF v_BrojVoznjiDanas > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Kupac vec ima testnu voznju za ovo vozilo danas';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `testne_voznje_info`
--

DROP TABLE IF EXISTS `testne_voznje_info`;
/*!50001 DROP VIEW IF EXISTS `testne_voznje_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `testne_voznje_info` AS SELECT 
 1 AS `VIN`,
 1 AS `Marka`,
 1 AS `Model`,
 1 AS `JMB_Kupca`,
 1 AS `Ime_Kupca`,
 1 AS `Prezime_Kupca`,
 1 AS `ID_Agenta`,
 1 AS `Ime_Agenta`,
 1 AS `Prezime_Agenta`,
 1 AS `DatumVoznje`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `uplata`
--

DROP TABLE IF EXISTS `uplata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uplata` (
  `IdUplate` int NOT NULL AUTO_INCREMENT,
  `IdPlacanja` int NOT NULL,
  `Iznos` decimal(10,2) NOT NULL,
  `DatumUplate` date NOT NULL,
  PRIMARY KEY (`IdUplate`),
  KEY `FK_IdPlacanja_Uplata` (`IdPlacanja`),
  CONSTRAINT `FK_IdPlacanja_Uplata` FOREIGN KEY (`IdPlacanja`) REFERENCES `placanje` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uplata`
--

LOCK TABLES `uplata` WRITE;
/*!40000 ALTER TABLE `uplata` DISABLE KEYS */;
INSERT INTO `uplata` VALUES (1,2,250.00,'2026-04-01'),(2,2,250.00,'2026-05-01'),(3,5,380.00,'2026-02-22'),(4,5,380.00,'2026-03-22'),(5,5,380.00,'2026-04-22'),(6,6,210.00,'2026-03-20'),(7,6,210.00,'2026-04-20'),(8,6,210.00,'2026-05-20'),(9,2,250.00,'2026-03-01'),(10,2,250.00,'2026-04-01'),(11,2,250.00,'2026-05-01'),(12,3,320.00,'2026-04-15'),(13,3,320.00,'2026-05-15'),(14,5,380.00,'2026-05-22');
/*!40000 ALTER TABLE `uplata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vozilo`
--

DROP TABLE IF EXISTS `vozilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vozilo` (
  `VIN` char(17) NOT NULL,
  `Marka` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `Godiste` int NOT NULL,
  `Boja` varchar(20) NOT NULL,
  `Opis` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`VIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vozilo`
--

LOCK TABLES `vozilo` WRITE;
/*!40000 ALTER TABLE `vozilo` DISABLE KEYS */;
INSERT INTO `vozilo` VALUES ('1HGCM82633A123456','Volkswagen','Golf 7',2022,'Crna','Odlično stanje'),('2HGCM82633A654321','Toyota','Corolla',2023,'Bijela','Novo vozilo'),('3HGCM82633A111222','BMW','320d',2020,'Siva','Polovno vozilo'),('4HCCD82633A459231','Skoda','Kodiak',2022,'Crna',''),('4HGCM82633A333444','Škoda','Octavia',2021,'Plava','Jedan vlasnik'),('5HGCM82633A555666','Audi','A4',2021,'Crna','Odlično stanje, jedan vlasnik'),('6HGCM82633A777888','Mercedes','C220',2022,'Bijela','Full oprema, garancija'),('7HGCM82633A999000','Renault','Megane',2020,'Crvena','Redovno servisan'),('8HGCM82633A111333','Peugeot','308',2023,'Siva','Novo vozilo'),('9HGCM82633A444555','Ford','Focus',2019,'Plava','Dva prethodna vlasnika'),('AHGCM82633A666777','Opel','Astra',2021,'Zelena','Jedan vlasnik, servisna knjiga'),('BHGCM82633A888999','Honda','Civic',2022,'Crna','Novo vozilo, full oprema'),('CHGCM82633A000111','Nissan','Qashqai',2020,'Bijela','SUV, redovno servisan'),('DHGCM82633A222333','Hyundai','i30',2021,'Srebrna','Odlično stanje'),('EHGCM82633A444555','Kia','Ceed',2023,'Crvena','Novo vozilo, garancija 7 godina'),('FHGCM82633A666777','Seat','Leon',2019,'Plava','Tri prethodna vlasnika'),('GHGCM82633A888000','Mazda','3',2022,'Bijela','Novo vozilo');
/*!40000 ALTER TABLE `vozilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaposleni`
--

DROP TABLE IF EXISTS `zaposleni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zaposleni` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES (1,'Marko','Marković'),(2,'Ana','Anić'),(3,'Petar','Petrović'),(4,'Ivana','Ivanić'),(5,'Jovana','Jovanović'),(6,'Milan','Milanović'),(7,'Dragana','Draganić'),(8,'Boris','Borić'),(9,'Tijana','Tijanić'),(10,'Nemanja','Nemanić');
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'projekat_baze_podataka'
--

--
-- Dumping routines for database 'projekat_baze_podataka'
--
/*!50003 DROP PROCEDURE IF EXISTS `dodaj_novo_vozilo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_novo_vozilo`(
    IN pVIN CHAR(17),
    IN pMarka VARCHAR(45),
    IN pModel VARCHAR(45),
    IN pGodiste INT,
    IN pBoja VARCHAR(20),
    IN pOpis VARCHAR(250),
    IN pKilometraza INT,
    IN pZapreminaMotora INT,
    IN pVrstaGoriva VARCHAR(10),
    IN pPogon VARCHAR(20),
    IN pOprema VARCHAR(45),
    IN pNabavnaCijena DECIMAL(10,2),
    IN pProdajnaCijena DECIMAL(10,2),
    IN pPeriodGarancije INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO Vozilo (VIN, Marka, Model, Godiste, Boja, Opis)
    VALUES (pVIN, pMarka, pModel, pGodiste, pBoja, pOpis);
    
    INSERT INTO Tehnicka_Specifikacija (VIN, Kilometraza, ZapreminaMotora, VrstaGoriva, Pogon, Oprema)
    VALUES (pVIN, pKilometraza, pZapreminaMotora, pVrstaGoriva, pPogon, pOprema);
    
    INSERT INTO Komercijalni_Podaci (VIN, NabavnaCijena, ProdajnaCijena, Status)
    VALUES (pVIN, pNabavnaCijena, pProdajnaCijena, 'Dostupno');
    
    INSERT INTO Novo_Vozilo (VIN, PeriodGarancije)
    VALUES (pVIN, pPeriodGarancije);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dodaj_polovno_vozilo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_polovno_vozilo`(
    IN pVIN CHAR(17),
    IN pMarka VARCHAR(45),
    IN pModel VARCHAR(45),
    IN pGodiste INT,
    IN pBoja VARCHAR(20),
    IN pOpis VARCHAR(250),
    IN pKilometraza INT,
    IN pZapreminaMotora INT,
    IN pVrstaGoriva VARCHAR(10),
    IN pPogon VARCHAR(20),
    IN pOprema VARCHAR(45),
    IN pNabavnaCijena DECIMAL(10,2),
    IN pProdajnaCijena DECIMAL(10,2),
    IN pBrojPrethodnihVlasnika INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO Vozilo (VIN, Marka, Model, Godiste, Boja, Opis)
    VALUES (pVIN, pMarka, pModel, pGodiste, pBoja, pOpis);
    
    INSERT INTO Tehnicka_Specifikacija (VIN, Kilometraza, ZapreminaMotora, VrstaGoriva, Pogon, Oprema)
    VALUES (pVIN, pKilometraza, pZapreminaMotora, pVrstaGoriva, pPogon, pOprema);
    
    INSERT INTO Komercijalni_Podaci (VIN, NabavnaCijena, ProdajnaCijena, Status)
    VALUES (pVIN, pNabavnaCijena, pProdajnaCijena, 'Dostupno');
    
    INSERT INTO Polovno_Vozilo (VIN, BrojPrethodnihVlasnika)
    VALUES (pVIN, pBrojPrethodnihVlasnika);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dodaj_testnu_voznju` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_testnu_voznju`(
    IN pVIN CHAR(17),
    IN pJmbKupca CHAR(13),
    IN pIdAgenta INT,
    IN pDatumVoznje DATE
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO Testna_Voznja (VIN, JMB_Kupca, ID_Agenta, DatumVoznje)
    VALUES (pVIN, pJmbKupca, pIdAgenta, pDatumVoznje);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiraj_prodaju` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiraj_prodaju`(
    IN pIdAgenta INT,
    IN pJmbKupca CHAR(13),
    IN pVIN CHAR(17),
    IN pTipPlacanja ENUM('Kredit', 'Gotovina', 'Lizing'),
    IN pBanka VARCHAR(45),
    IN pBrojRata INT,
    IN pIznosRate DECIMAL(10,2),
    IN pAvans DECIMAL(10,2),
    IN pCijena DECIMAL(10,2),
    OUT pIdProdaje INT
)
BEGIN
    DECLARE vIdPlacanja INT;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO Placanje (Tip, Banka, BrojRata, IznosRate, Avans)
    VALUES (pTipPlacanja, pBanka, pBrojRata, pIznosRate, pAvans);
    
    SET vIdPlacanja = LAST_INSERT_ID();
    
    INSERT INTO Prodaja (ID_Agenta, JMB_Kupca, VIN, ID_Placanja, Datum, Cijena)
    VALUES (pIdAgenta, pJmbKupca, pVIN, vIdPlacanja, CURDATE(), pCijena);
    
    SET pIdProdaje = LAST_INSERT_ID();
    
    IF pTipPlacanja = 'Gotovina' THEN
        INSERT INTO Uplata (IdPlacanja, Iznos, DatumUplate)
        VALUES (vIdPlacanja, pCijena, CURDATE());
    END IF;
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `otkazi_rezervaciju_vozila` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `otkazi_rezervaciju_vozila`(
    IN pVIN CHAR(17)
)
BEGIN
    DECLARE vStatus ENUM('Dostupno', 'Rezervisano', 'Prodano');
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    SELECT Status INTO vStatus
    FROM Komercijalni_Podaci
    WHERE VIN = pVIN;
    
    IF vStatus != 'Rezervisano' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Vozilo nije u statusu Rezervisano';
    END IF;
    
    UPDATE Komercijalni_Podaci
    SET Status = 'Dostupno'
    WHERE VIN = pVIN;
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registruj_novog_kupca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registruj_novog_kupca`(
    IN pJMB CHAR(13),
    IN pIme VARCHAR(45),
    IN pPrezime VARCHAR(45),
    IN pAdresa VARCHAR(45),
    IN pTelefon VARCHAR(15),
    IN pEmail VARCHAR(45)
)
BEGIN
    DECLARE vPostoji INT;
    
    SELECT COUNT(*) INTO vPostoji
    FROM Kupac WHERE JMB = pJMB;
    
    IF vPostoji = 0 THEN
        INSERT INTO Kupac (JMB, Ime, Prezime, Adresa, Telefon, Email)
        VALUES (pJMB, pIme, pPrezime, pAdresa, pTelefon, pEmail);
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rezervisi_vozilo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `rezervisi_vozilo`(
    IN pVIN CHAR(17),
    IN pJmbKupca CHAR(13)
)
BEGIN
    DECLARE vStatus ENUM('Dostupno', 'Rezervisano', 'Prodano');
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    SELECT Status INTO vStatus
    FROM Komercijalni_Podaci
    WHERE VIN = pVIN;
    
    IF vStatus != 'Dostupno' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Vozilo nije dostupno za rezervaciju';
    END IF;
    
    UPDATE Komercijalni_Podaci
    SET Status = 'Rezervisano'
    WHERE VIN = pVIN;
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `unos_uplate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `unos_uplate`(
    IN pIdPlacanja INT,
    IN pIznos DECIMAL(10,2),
    IN pDatumUplate DATE
)
BEGIN
    DECLARE vTipPlacanja ENUM('Kredit', 'Gotovina', 'Lizing');
    DECLARE vIznosRate DECIMAL(10,2);
    DECLARE vBrojRata INT;
    DECLARE vBrojUplacenih INT;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    SELECT Tip, IznosRate, BrojRata INTO vTipPlacanja, vIznosRate, vBrojRata
    FROM Placanje
    WHERE ID = pIdPlacanja;

    IF vTipPlacanja = 'Gotovina' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Gotovinska uplata se automatski kreira pri prodaji';
    END IF;

    SELECT COUNT(*) INTO vBrojUplacenih
    FROM Uplata
    WHERE IdPlacanja = pIdPlacanja;

    IF vBrojUplacenih >= vBrojRata THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Sve rate su vec uplacene';
    END IF;

    INSERT INTO Uplata (IdPlacanja, Iznos, DatumUplate)
    VALUES (pIdPlacanja, pIznos, pDatumUplate);

    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `dostupna_vozila_info`
--

/*!50001 DROP VIEW IF EXISTS `dostupna_vozila_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dostupna_vozila_info` AS select `v`.`VIN` AS `VIN`,`v`.`Marka` AS `Marka`,`v`.`Model` AS `Model`,`v`.`Godiste` AS `Godiste`,`v`.`Boja` AS `Boja`,`v`.`Opis` AS `Opis`,`ts`.`Kilometraza` AS `Kilometraza`,`ts`.`ZapreminaMotora` AS `ZapreminaMotora`,`ts`.`VrstaGoriva` AS `VrstaGoriva`,`ts`.`Pogon` AS `Pogon`,`ts`.`Oprema` AS `Oprema`,`kp`.`NabavnaCijena` AS `NabavnaCijena`,`kp`.`ProdajnaCijena` AS `ProdajnaCijena`,`kp`.`Status` AS `Status` from ((`vozilo` `v` join `tehnicka_specifikacija` `ts` on((`v`.`VIN` = `ts`.`VIN`))) join `komercijalni_podaci` `kp` on((`v`.`VIN` = `kp`.`VIN`))) where (`kp`.`Status` = 'Dostupno') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nova_vozila_info`
--

/*!50001 DROP VIEW IF EXISTS `nova_vozila_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nova_vozila_info` AS select `v`.`VIN` AS `VIN`,`v`.`Marka` AS `Marka`,`v`.`Model` AS `Model`,`v`.`Godiste` AS `Godiste`,`v`.`Boja` AS `Boja`,`v`.`Opis` AS `Opis`,`nv`.`PeriodGarancije` AS `PeriodGarancije`,`ts`.`Kilometraza` AS `Kilometraza`,`ts`.`ZapreminaMotora` AS `ZapreminaMotora`,`ts`.`VrstaGoriva` AS `VrstaGoriva`,`ts`.`Pogon` AS `Pogon`,`ts`.`Oprema` AS `Oprema`,`kp`.`NabavnaCijena` AS `NabavnaCijena`,`kp`.`ProdajnaCijena` AS `ProdajnaCijena`,`kp`.`Status` AS `Status` from (((`vozilo` `v` join `tehnicka_specifikacija` `ts` on((`v`.`VIN` = `ts`.`VIN`))) join `komercijalni_podaci` `kp` on((`v`.`VIN` = `kp`.`VIN`))) join `novo_vozilo` `nv` on((`v`.`VIN` = `nv`.`VIN`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `polovna_vozila_info`
--

/*!50001 DROP VIEW IF EXISTS `polovna_vozila_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `polovna_vozila_info` AS select `v`.`VIN` AS `VIN`,`v`.`Marka` AS `Marka`,`v`.`Model` AS `Model`,`v`.`Godiste` AS `Godiste`,`v`.`Boja` AS `Boja`,`v`.`Opis` AS `Opis`,`pv`.`BrojPrethodnihVlasnika` AS `BrojPrethodnihVlasnika`,`ts`.`Kilometraza` AS `Kilometraza`,`ts`.`ZapreminaMotora` AS `ZapreminaMotora`,`ts`.`VrstaGoriva` AS `VrstaGoriva`,`ts`.`Pogon` AS `Pogon`,`ts`.`Oprema` AS `Oprema`,`kp`.`NabavnaCijena` AS `NabavnaCijena`,`kp`.`ProdajnaCijena` AS `ProdajnaCijena`,`kp`.`Status` AS `Status` from (((`vozilo` `v` join `tehnicka_specifikacija` `ts` on((`v`.`VIN` = `ts`.`VIN`))) join `komercijalni_podaci` `kp` on((`v`.`VIN` = `kp`.`VIN`))) join `polovno_vozilo` `pv` on((`v`.`VIN` = `pv`.`VIN`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prodaja_po_agentu`
--

/*!50001 DROP VIEW IF EXISTS `prodaja_po_agentu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prodaja_po_agentu` AS select `p`.`ID_Agenta` AS `ID_Agenta`,`z`.`Ime` AS `Ime_Agenta`,`z`.`Prezime` AS `Prezime_Agenta`,count(`p`.`IdProdaje`) AS `Ukupno_Prodaja`,sum(`p`.`Cijena`) AS `Ukupna_Vrijednost` from ((`prodaja` `p` left join `agent` `a` on((`p`.`ID_Agenta` = `a`.`ID`))) left join `zaposleni` `z` on((`a`.`ID` = `z`.`ID`))) group by `p`.`ID_Agenta`,`z`.`Ime`,`z`.`Prezime` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prodaje_info`
--

/*!50001 DROP VIEW IF EXISTS `prodaje_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prodaje_info` AS select `p`.`IdProdaje` AS `IdProdaje`,`p`.`ID_Agenta` AS `ID_Agenta`,`z`.`Ime` AS `Ime_Agenta`,`z`.`Prezime` AS `Prezime_Agenta`,`p`.`JMB_Kupca` AS `JMB_Kupca`,`k`.`Ime` AS `Ime_Kupca`,`k`.`Prezime` AS `Prezime_Kupca`,`p`.`VIN` AS `VIN_Vozila`,`v`.`Marka` AS `Marka_Vozila`,`v`.`Model` AS `Model_Vozila`,`v`.`Godiste` AS `Godiste_Vozila`,`p`.`ID_Placanja` AS `ID_Placanja`,`pl`.`Tip` AS `Tip_Placanja`,`p`.`Datum` AS `Datum_Prodaje`,`p`.`Cijena` AS `Cijena` from (((((`prodaja` `p` join `agent` `a` on((`p`.`ID_Agenta` = `a`.`ID`))) join `zaposleni` `z` on((`a`.`ID` = `z`.`ID`))) join `kupac` `k` on((`p`.`JMB_Kupca` = `k`.`JMB`))) join `vozilo` `v` on((`p`.`VIN` = `v`.`VIN`))) join `placanje` `pl` on((`p`.`ID_Placanja` = `pl`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sva_vozila_info`
--

/*!50001 DROP VIEW IF EXISTS `sva_vozila_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sva_vozila_info` AS select `v`.`VIN` AS `VIN`,`v`.`Marka` AS `Marka`,`v`.`Model` AS `Model`,`v`.`Godiste` AS `Godiste`,`v`.`Boja` AS `Boja`,`v`.`Opis` AS `Opis`,`ts`.`Kilometraza` AS `Kilometraza`,`ts`.`ZapreminaMotora` AS `ZapreminaMotora`,`ts`.`VrstaGoriva` AS `VrstaGoriva`,`ts`.`Pogon` AS `Pogon`,`ts`.`Oprema` AS `Oprema`,`kp`.`NabavnaCijena` AS `NabavnaCijena`,`kp`.`ProdajnaCijena` AS `ProdajnaCijena`,`kp`.`Status` AS `Status`,(case when (`nv`.`VIN` is not null) then 'Novo' else 'Polovno' end) AS `TipVozila`,coalesce(`nv`.`PeriodGarancije`,0) AS `PeriodGarancije`,coalesce(`pv`.`BrojPrethodnihVlasnika`,0) AS `BrojPrethodnihVlasnika` from ((((`vozilo` `v` join `tehnicka_specifikacija` `ts` on((`v`.`VIN` = `ts`.`VIN`))) join `komercijalni_podaci` `kp` on((`v`.`VIN` = `kp`.`VIN`))) left join `novo_vozilo` `nv` on((`v`.`VIN` = `nv`.`VIN`))) left join `polovno_vozilo` `pv` on((`v`.`VIN` = `pv`.`VIN`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testne_voznje_info`
--

/*!50001 DROP VIEW IF EXISTS `testne_voznje_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testne_voznje_info` AS select `tv`.`VIN` AS `VIN`,`v`.`Marka` AS `Marka`,`v`.`Model` AS `Model`,`tv`.`JMB_Kupca` AS `JMB_Kupca`,`k`.`Ime` AS `Ime_Kupca`,`k`.`Prezime` AS `Prezime_Kupca`,`tv`.`ID_Agenta` AS `ID_Agenta`,`z`.`Ime` AS `Ime_Agenta`,`z`.`Prezime` AS `Prezime_Agenta`,`tv`.`DatumVoznje` AS `DatumVoznje` from ((((`testna_voznja` `tv` join `vozilo` `v` on((`tv`.`VIN` = `v`.`VIN`))) join `kupac` `k` on((`tv`.`JMB_Kupca` = `k`.`JMB`))) join `agent` `a` on((`tv`.`ID_Agenta` = `a`.`ID`))) join `zaposleni` `z` on((`a`.`ID` = `z`.`ID`))) */;
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

-- Dump completed on 2026-06-16 21:57:13
