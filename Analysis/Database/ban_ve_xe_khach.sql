-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: dat_ve_xe_khach
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `chuyen_xe`
--

DROP TABLE IF EXISTS `chuyen_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuyen_xe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loai_xe` varchar(255) NOT NULL,
  `chinh_sach_huy_ve` varchar(255) NOT NULL,
  `luu_y` varchar(255) NOT NULL,
  `id_nha_xe` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ChuyenXe_fk0` (`id_nha_xe`),
  CONSTRAINT `ChuyenXe_fk0` FOREIGN KEY (`id_nha_xe`) REFERENCES `nha_xe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyen_xe`
--

LOCK TABLES `chuyen_xe` WRITE;
/*!40000 ALTER TABLE `chuyen_xe` DISABLE KEYS */;
INSERT INTO `chuyen_xe` VALUES (1,'limousine','hoàn 50%','',1);
/*!40000 ALTER TABLE `chuyen_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danh_gia`
--

DROP TABLE IF EXISTS `danh_gia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_gia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noiDung` varchar(255) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idChuyenXe` int(11) NOT NULL,
  `sao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DanhGia_fk0` (`idUser`),
  KEY `DanhGia_fk1` (`idChuyenXe`),
  CONSTRAINT `DanhGia_fk0` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`),
  CONSTRAINT `DanhGia_fk1` FOREIGN KEY (`idChuyenXe`) REFERENCES `chuyen_xe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_gia`
--

LOCK TABLES `danh_gia` WRITE;
/*!40000 ALTER TABLE `danh_gia` DISABLE KEYS */;
/*!40000 ALTER TABLE `danh_gia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nha_xe`
--

DROP TABLE IF EXISTS `nha_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nha_xe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  `url_logo` varchar(255) DEFAULT NULL,
  `phone` varchar(15) NOT NULL,
  `dia_chi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nha_xe`
--

LOCK TABLES `nha_xe` WRITE;
/*!40000 ALTER TABLE `nha_xe` DISABLE KEYS */;
INSERT INTO `nha_xe` VALUES (1,'khánh lan',NULL,'0332935959','62 Đại La, Hai Bà Trưng, Hà Nội');
/*!40000 ALTER TABLE `nha_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Order_fk0` (`id_user`),
  CONSTRAINT `Order_fk0` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_order` int(11) NOT NULL,
  `id_ve` int(11) NOT NULL,
  `id_diem_don` int(11) NOT NULL,
  `id_diem_dung` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `f_idx` (`id_order`),
  KEY `fk_order_detail_idx` (`id_ve`),
  KEY `fk_diemdon_detail_idx` (`id_diem_don`),
  KEY `fk_diendung_detail_idx` (`id_diem_dung`),
  CONSTRAINT `fk_diemdon_detail` FOREIGN KEY (`id_diem_don`) REFERENCES `vi_tri_chuyen_xe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_diendung_detail` FOREIGN KEY (`id_diem_dung`) REFERENCES `vi_tri_chuyen_xe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_detail` FOREIGN KEY (`id_order`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ve_detail` FOREIGN KEY (`id_ve`) REFERENCES `ve_xe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tien','1234',0,'Đoàn Văn Tiến','0999888777'),(2,'admin','admin',1,'Admin','0999999999');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ve_xe`
--

DROP TABLE IF EXISTS `ve_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ve_xe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `muc_gia` float NOT NULL,
  `vi_tri_ghe` int(11) NOT NULL,
  `id_chuyen_xe` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `VeXe_fk0` (`id_chuyen_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ve_xe`
--

LOCK TABLES `ve_xe` WRITE;
/*!40000 ALTER TABLE `ve_xe` DISABLE KEYS */;
/*!40000 ALTER TABLE `ve_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vi_tri`
--

DROP TABLE IF EXISTS `vi_tri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vi_tri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vi_tri` varchar(255) NOT NULL,
  `tinh` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vi_tri`
--

LOCK TABLES `vi_tri` WRITE;
/*!40000 ALTER TABLE `vi_tri` DISABLE KEYS */;
INSERT INTO `vi_tri` VALUES (1,'62 Đại La, Hai Bà Trưng, Hà Nội','Hà Nội'),(2,'62 Đại La, Hai Bà Trưng, Hà Nam','Hà Nam');
/*!40000 ALTER TABLE `vi_tri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vi_tri_chuyen_xe`
--

DROP TABLE IF EXISTS `vi_tri_chuyen_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vi_tri_chuyen_xe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_vi_tri` int(11) NOT NULL,
  `id_chuyen_xe` int(11) NOT NULL,
  `thoi_diem_du_kien` datetime NOT NULL,
  `type` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ViTriChuyenXe_fk0` (`id_vi_tri`),
  KEY `ViTriChuyenXe_fk1` (`id_chuyen_xe`),
  CONSTRAINT `ViTriChuyenXe_fk0` FOREIGN KEY (`id_vi_tri`) REFERENCES `vi_tri` (`id`),
  CONSTRAINT `ViTriChuyenXe_fk1` FOREIGN KEY (`id_chuyen_xe`) REFERENCES `chuyen_xe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vi_tri_chuyen_xe`
--

LOCK TABLES `vi_tri_chuyen_xe` WRITE;
/*!40000 ALTER TABLE `vi_tri_chuyen_xe` DISABLE KEYS */;
/*!40000 ALTER TABLE `vi_tri_chuyen_xe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-10  2:22:12
