-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `receive_address` varchar(255) DEFAULT NULL,
  `receive_name` varchar(255) DEFAULT NULL,
  `receive_phone` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'8 Pham Hung, Nam Tu Liem, Ha Noi','Nguyen Van A','0123456789',2),(2,'6A/599 Nguyễn Trãi','TRAN THI NGOC ANH','1234556789',3);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cost` double NOT NULL,
  `item_id` bigint DEFAULT NULL,
  `quantity` int NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (2,196000,2,4,3,'Trà Long Nhãn Hạt Sen'),(3,98000,5,2,3,'Trà Long Nhãn Hạt Sen');
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,NULL,'Trà Trái Cây'),(2,NULL,'Trà Sữa'),(3,NULL,'Trà Xanh'),(4,NULL,'Cà Phê'),(5,NULL,'Bánh Ngọt');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,1,'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.','https://anhtcogn.blob.core.windows.net/anhtcogn/tdcs-nong_288997.jpg','Trà Đào Cam Sả',59000),(2,1,'Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi thơm ngon. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.','https://anhtcogn.blob.core.windows.net/anhtcogn/tra-sen-nong_025153.jpg','Trà Hạt Sen',49000),(3,1,'Thức uống mang hương vị của nhãn, của sen, của trà Oolong đầy thanh mát cho tất cả các thành viên trong dịp Tết này. An lành, thư thái và đậm đà chính là những gì The Coffee House mong muốn gửi trao đến bạn và gia đình.','https://anhtcogn.blob.core.windows.net/anhtcogn/1649378747_tra-sen-nhan.jpg','Trà Long Nhãn Hạt Sen',49000),(4,1,'Trà hoa Hibiscus 0% caffeine thanh mát, hòa quyện cùng trà lên men Kombucha 100% tự nhiên và mứt Yuzu Marmalade (quýt Nhật) mang đến hương vị chua chua lạ miệng','https://anhtcogn.blob.core.windows.net/anhtcogn/1686716508_kombucha-yuzu.jpg','Hi-Tea Yuzu Kombucha',59000),(5,1,'Sự kết hợp ăn ý giữa Đào cùng trà hoa Hibiscus, tạo nên tổng thể hài hoà dễ gây “thương nhớ” cho team thích món thanh mát, có vị chua nhẹ.','https://anhtcogn.blob.core.windows.net/anhtcogn/1669737919_hi-tea-dao.jpg','Hi-Tea Đào',49000),(6,1,'Không chỉ nổi bật với sắc đỏ đặc trưng từ trà hoa Hibiscus, Hi-Tea Yuzu còn gây ấn tượng với topping Yuzu (quýt Nhật) lạ miệng, kết hợp cùng trân châu trắng dai giòn sần sật, nhai vui vui.','https://anhtcogn.blob.core.windows.net/anhtcogn/1669736859_hi-tea-yuzu-tran-chau.png','Hi-Tea Yuzu Trân Châu',49000),(7,2,'Hương vị chân ái đúng gu đậm đà với trà oolong được “sao” (nướng) lâu hơn cho hương vị đậm đà, hòa quyện với sữa thơm béo mang đến cảm giác mát lạnh, lưu luyến vị trà sữa đậm đà nơi vòm họng.','https://anhtcogn.blob.core.windows.net/anhtcogn/1669736877_tra-sua-oolong-nuong-tran-chau.png','Trà sữa Oolong Nướng Trân Châu',55000),(8,2,'Sữa hạt mắc ca thơm ngon, bổ dưỡng quyện cùng nền trà oolong cho vị cân bằng, ngọt dịu đi kèm cùng Trân châu trắng giòn dai mang lại cảm giác “đã” trong từng ngụm trà sữa.','https://anhtcogn.blob.core.windows.net/anhtcogn/tra-sua-mac-ca_377522.jpg','Trà Sữa Mắc Ca Trân Châu',55000),(9,2,'Thêm chút ngọt ngào cho ngày mới với hồng trà nguyên lá, sữa thơm ngậy được cân chỉnh với tỉ lệ hoàn hảo, cùng trân châu trắng dai giòn','https://anhtcogn.blob.core.windows.net/anhtcogn/hong-tra-sua-tran-chau_326977.jpg','Hồng Trà Sữa Trân Châu',55000),(10,2,'Trà Oolong nướng rõ hương đậm vị, quyện với sữa dừa beo béo, được xay mịn cùng đá, mát rượi trong tích tắc.','https://anhtcogn.blob.core.windows.net/anhtcogn/1675329651_bg-cloudtea-daxay.jpg','CloudTea Oolong Nướng Kem Dừa Đá Xay',55000),(11,2,'Không thể rời môi với Mochi Kem Matcha dẻo mịn, núng nính. Trà Xanh Tây Bắc vị mộc hoà quyện sữa tươi, foam phô mai beo béo và vụn bánh quy giòn tan, là lựa chọn đậm không khí lễ hội.','https://anhtcogn.blob.core.windows.net/anhtcogn/1700837665_tra-sua-tra-xanh-tay-bac-ly-thuy-tinh.jpg','CloudTea Trà Xanh Tây Bắc',69000),(12,3,'Trà Xanh Latte (Nóng) là phiên bản rõ vị trà nhất. Nhấp một ngụm, bạn chạm ngay vị trà xanh Tây Bắc chát nhẹ hoà cùng sữa nguyên kem thơm béo, đọng lại hậu vị ngọt ngào, êm dịu.','https://anhtcogn.blob.core.windows.net/anhtcogn/1699287050_tra-xanh-latte-nong.jpg','Trà Xanh Latte (Nóng)',45000),(13,3,'Bột chocolate nguyên chất hoà cùng sữa tươi béo ngậy. Vị ngọt tự nhiên, không gắt cổ, để lại một chút đắng nhẹ, cay cay trên đầu lưỡi.','https://anhtcogn.blob.core.windows.net/anhtcogn/chocolatenong_949029.jpg','Chocolate Nóng',45000),(14,3,'Trà xanh Tây Bắc vị thanh, chát nhẹ hoà cùng sữa tươi nguyên kem ngọt béo tạo nên hương vị dễ uống, dễ yêu.','https://anhtcogn.blob.core.windows.net/anhtcogn/1699287043_tra-xanh-latte.jpg','Trà Xanh Latte',45000),(15,3,'Từng ngụm là sự hài hoà từ trà xanh đậm đà, đường đen ngọt ngào, sữa tươi thơm béo. Khuấy đều trước khi dùng, để thưởng thức đúng vị','https://anhtcogn.blob.core.windows.net/anhtcogn/1699287058_tra-xanh-duong-den.jpg','Trà Xanh Đường Đen',55000),(16,4,'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn.','https://anhtcogn.blob.core.windows.net/anhtcogn/1639377816_ca-phe-den-nong.jpg','Cà Phê Đen Nóng',39000),(17,4,'Cà phê được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.','https://anhtcogn.blob.core.windows.net/anhtcogn/1639377770_cfsua-nong.jpg','Cà Phê Sữa Nóng',39000),(18,4,'Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.','https://anhtcogn.blob.core.windows.net/anhtcogn/espressoNong_612688.jpg','Espresso Nóng',45000),(19,4,'Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.','https://anhtcogn.blob.core.windows.net/anhtcogn/latte_851143.jpg','Latte Nóng',55000),(20,4,'Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.','https://anhtcogn.blob.core.windows.net/anhtcogn/1645969437_caramel-macchiato-nong-lifestyle.jpg','Caramel Macchiato Nóng',55000),(21,4,'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.','https://anhtcogn.blob.core.windows.net/anhtcogn/1636647328_arme-nong.jpg','Americano Nóng',45000),(22,4,'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.','https://anhtcogn.blob.core.windows.net/anhtcogn/1636647328_arme-nong.jpg','Americano Nóng',45000),(23,5,'Với vẻ ngoài đáng yêu và hương vị ngọt ngào, thơm béo nhất định bạn phải thử ít nhất 1 lần.','https://anhtcogn.blob.core.windows.net/anhtcogn/1638170066_gau.jpg','Mousse Gấu Chocolate',39000),(24,5,'Hương vị dễ ghiền được tạo nên bởi chút đắng nhẹ của cà phê, lớp kem trứng béo ngọt dịu hấp dẫn','https://anhtcogn.blob.core.windows.net/anhtcogn/1638170137_tiramisu.jpg','Mousse Tiramisu',35000),(25,5,'Bánh nhiều lớp được phủ lớp kem bên trên bằng Cream cheese.','https://anhtcogn.blob.core.windows.net/anhtcogn/5dd2087ff2546c2614fb08d1_Red-Velvet_087977.jpg','Mousse Red Velvet',35000),(26,5,'Bao bọc bởi lớp vỏ Mochi dẻo thơm, bên trong là lớp kem lạnh cùng nhân trà xanh đậm vị.','https://anhtcogn.blob.core.windows.net/anhtcogn/1655348113_mochi-traxanh.jpg','Mochi Kem Matcha',19000),(27,5,'Bánh nhiều lớp được phủ lớp kem bên trên bằng Cream cheese.','https://anhtcogn.blob.core.windows.net/anhtcogn/5dd2087ff2546c2614fb08d1_Red-Velvet_087977.jpg','Mousse Red Velvet',35000),(28,5,'Bao bọc bởi lớp vỏ Mochi dẻo thơm, bên trong là lớp kem lạnh cùng nhân chocolate độc đáo','https://anhtcogn.blob.core.windows.net/anhtcogn/1655348107_mochi-choco.jpg','Mochi Kem Chocolate',19000);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address_id` bigint DEFAULT NULL,
  `month` int NOT NULL,
  `order_time` datetime(6) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `voucher_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,12,'2023-12-01 18:23:31.110316','PAYPAL',5,'PAYMENT SUCCESS',177000,2,NULL),(2,1,12,'2023-12-01 18:28:11.702321','PAYPAL',0,'PAYMENT SUCCESS',167000,2,1),(3,1,12,'2023-12-01 18:30:14.960174','PAYPAL',0,'PAYMENT SUCCESS',167000,2,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` bigint NOT NULL,
  `amount` double NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `payment_date` datetime(6) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,7.54894016292063,'USD',1,'2023-12-01 18:23:45.656093','paypal','PAYMENT SUCCESS','EC-6UN863073X631035Y'),(2,7.12244636840534,'USD',2,'2023-12-01 18:28:26.053323','paypal','PAYMENT SUCCESS','EC-5HT063310H5572158'),(3,7.12244636840534,'USD',3,'2023-12-01 18:30:31.603554','paypal','PAYMENT SUCCESS','EC-8CB383959K8585300');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_entity_role`
--

DROP TABLE IF EXISTS `user_entity_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_entity_role` (
  `user_entity_id` bigint NOT NULL,
  `role` int DEFAULT NULL,
  KEY `FK9a086y3ncf4hg88364t0k1xj5` (`user_entity_id`),
  CONSTRAINT `FK9a086y3ncf4hg88364t0k1xj5` FOREIGN KEY (`user_entity_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_entity_role`
--

LOCK TABLES `user_entity_role` WRITE;
/*!40000 ALTER TABLE `user_entity_role` DISABLE KEYS */;
INSERT INTO `user_entity_role` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `user_entity_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image` longtext,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_num` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6xisn9isn9ojnu0sg9fyhaeks` (`phone_num`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,'test@gmail.com','https://anhtcogn.blob.core.windows.net/anhtcogn/a1.jpg','123','$2a$12$IcayORKTWjNQXOiNDgR4E..FZMfnfmbQmjNS.HYDUKIDBfSV39usm','0123456789','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOlt7ImF1dGhvcml0eSI6IkNMSUVOVCJ9XSwiaWF0IjoxNzAxNDE5ODYzLCJleHAiOjE3MDE0MjM0NjN9.s2O-kX4zEpP7SLkLaGx3bPEoi5Rvr4Fh2kJLMNmIaH4','admin'),(2,NULL,NULL,'https://anhtcogn.blob.core.windows.net/anhtcogn/a1.jpg',NULL,'$2a$12$C4WGUdPeO0q3BpE4hLMs2.aFYMHj0cJz6ls9Kdb1EzDl7S9ThArl6',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lcjEiLCJhdXRoIjpbeyJhdXRob3JpdHkiOiJDTElFTlQifV0sImlhdCI6MTcwMTQxOTgzOSwiZXhwIjoxNzAxNDIzNDM5fQ.iV9ooQoumzuKa4MLpwy3HGoHGr6UDbnVqYl33fsBbJ8','customer1'),(3,NULL,NULL,'https://anhtcogn.blob.core.windows.net/anhtcogn/a1.jpg',NULL,'$2a$12$NqQ/p70gVXAUAR8an9dBf.loLGzKSlIPw7FxstanGgT6Q2E7tsqWK',NULL,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lcjIiLCJhdXRoIjpbeyJhdXRob3JpdHkiOiJDTElFTlQifV0sImlhdCI6MTcwMTQxOTg1NCwiZXhwIjoxNzAxNDIzNDU0fQ.8BPfPNAk8l74aIFtKoOaJ8DoWfYTIay7ZOXIK61DqdE','customer2');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucher`
--

DROP TABLE IF EXISTS `voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` double NOT NULL,
  `end_date` date DEFAULT NULL,
  `min_billing` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucher`
--

LOCK TABLES `voucher` WRITE;
/*!40000 ALTER TABLE `voucher` DISABLE KEYS */;
INSERT INTO `voucher` VALUES (1,_binary '\0','Giảm 10k đơn từ 50k',10000,'2023-12-30',50000,'Giảm 10k đơn từ 50k'),(2,_binary '','Giảm 20k đơn từ 80k',20000,'2023-12-30',80000,'Giảm 20k đơn từ 80k'),(3,_binary '','Giảm 50k đơn từ 500k',50000,'2023-12-30',500000,'Giảm 50k đơn từ 500k'),(4,_binary '',NULL,0,NULL,0,NULL);
/*!40000 ALTER TABLE `voucher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-02  9:29:33
