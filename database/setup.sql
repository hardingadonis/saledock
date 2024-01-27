-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2024 at 10:16 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12
SET FOREIGN_KEY_CHECKS = 0;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;


/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;


/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;


/*!40101 SET NAMES utf8mb4 */
;

--
-- Database: `saledock`
--
CREATE DATABASE IF NOT EXISTS `saledock` DEFAULT CHARACTER
SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `saledock`;

-- --------------------------------------------------------
--
-- Table structure for table `category`
--
CREATE TABLE `category` (
    `id` bigint (20) NOT NULL,
    `created_at` datetime (6) DEFAULT NULL,
    `name` varchar(255) NOT NULL) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `category`
--
INSERT INTO `category` (`id`, `created_at`, `name`)
    VALUES (1, '2024-01-19 18:10:16.000000', 'Thực phẩm đóng gói'),
    (2, '2024-01-19 18:10:16.000000', 'Thực phẩm tươi sống'),
    (3, '2024-01-19 18:10:16.000000', 'Thực phẩm đông lạnh');

-- --------------------------------------------------------
--
-- Table structure for table `customer`
--
CREATE TABLE `customer` (
    `id` bigint (20) NOT NULL,
    `address` varchar(255) NOT NULL,
    `code` varchar(255) NOT NULL,
    `created_at` datetime (6) DEFAULT NULL,
    `email` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `updated_at` datetime (6) DEFAULT NULL) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--
INSERT INTO `customer` (`id`, `address`, `code`, `created_at`, `email`, `name`, `updated_at`)
    VALUES (1, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00001', '2024-01-19 18:10:16.000000', 'kh00001@gmail.com', 'Công ty TNHH A', '2024-01-19 18:10:16.000000'),
    (2, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00002', '2024-01-19 18:10:16.000000', 'kh00002@gmail.com', 'Công ty TNHH B', NULL),
    (3, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00003', '2024-01-19 18:10:16.000000', 'kh00003@gmail.com', 'Công ty TNHH C', '2024-01-19 18:10:16.000000');

-- --------------------------------------------------------
--
-- Table structure for table `employee`
--
CREATE TABLE `employee` (
    `id` bigint (20) NOT NULL,
    `code` varchar(255) NOT NULL,
    `created_at` datetime (6) DEFAULT NULL,
    `email` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `updated_at` datetime (6) DEFAULT NULL) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--
INSERT INTO `employee` (`id`, `code`, `created_at`, `email`, `name`, `password`, `updated_at`)
    VALUES (1, 'QE170148', '2024-01-19 18:10:16.000000', 'vuonglmqe170148@fpt.edu.vn', 'Lê Minh Vương', '827ccb0eea8a706c4c34a16891f84e7b', '2024-01-19 18:10:16.000000'),
    (2, 'QE170033', '2024-01-19 18:10:16.000000', 'thuyntqe170033@fpt.edu.vn', 'Nguyễn Thị Thúy', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
    (3, 'QE170097', '2024-01-19 18:10:16.000000', 'chuongdqqe170097@fpt.edu.vn', 'Đinh Quốc Chương', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
    (4, 'QE170173', '2024-01-19 18:10:16.000000', 'nghiahtqe170173@fpt.edu.vn', 'Hồ Trọng Nghĩa', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
    (5, 'QE170212', '2024-01-19 18:10:16.000000', 'sonntqe170212@fpt.edu.vn', 'Nguyễn Thái Sơn', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
    (6, 'QE170023', '2024-01-19 18:10:16.000000', 'linhlmqe170023@fpt.edu.vn', 'Lâm Mỹ Linh', '827ccb0eea8a706c4c34a16891f84e7b', NULL);

-- --------------------------------------------------------
--
-- Table structure for table `order`
--
CREATE TABLE `order` (
    `id` bigint (20) NOT NULL,
    `code` varchar(255) NOT NULL,
    `created_at` datetime (6) DEFAULT NULL,
    `note` longtext DEFAULT NULL,
    `status` enum ('PENDING', 'SHIPPING', 'DONE', 'CANCELLED') NOT NULL,
    `total` double NOT NULL,
    `updated_at` datetime (6) DEFAULT NULL,
    `customer_id` bigint (20) NOT NULL,
    `employee_id` bigint (20) NOT NULL) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `order`
--
INSERT INTO `order` (`id`, `code`, `created_at`, `note`, `status`, `total`, `updated_at`, `customer_id`, `employee_id`)
    VALUES (1, '9423198AE8A44E7', '2024-01-19 18:10:16.000000', NULL, 'PENDING', 7078000, NULL, 3, 1),
    (2, '21BD4E4E65094E6', '2024-01-19 18:10:16.000000', NULL, 'PENDING', 10290000, NULL, 1, 1);

-- --------------------------------------------------------
--
-- Table structure for table `order_detail`
--
CREATE TABLE `order_detail` (
    `quantity` int(11) NOT NULL,
    `order_id` bigint (20) NOT NULL,
    `product_id` bigint (20) NOT NULL) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `order_detail`
--
INSERT INTO `order_detail` (`quantity`, `order_id`, `product_id`)
    VALUES (341, 1, 4),
    (145, 1, 9),
    (34, 2, 2),
    (16, 2, 3),
    (334, 2, 8);

-- --------------------------------------------------------
--
-- Table structure for table `product`
--
CREATE TABLE `product` (
    `id` bigint (20) NOT NULL,
    `code` varchar(255) NOT NULL,
    `created_at` datetime (6) DEFAULT NULL,
    `description` longtext DEFAULT NULL,
    `image_url` longtext DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `price` double NOT NULL,
    `updated_at` datetime (6) DEFAULT NULL,
    `category_id` bigint (20) NOT NULL) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `product`
--
INSERT INTO `product` (`id`, `code`, `created_at`, `description`, `image_url`, `name`, `price`, `updated_at`, `category_id`)
    VALUES (1, 'P001', '2024-01-19 18:10:16.000000', 'Bún gạo trắng và mềm, dùng để nấu các món phở và mì Quảng', NULL, 'Bún gạo đóng gói', 20000, NULL, 1),
    (2, 'C002', '2024-01-19 18:10:16.000000', 'Thịt heo hấp nhẹ, đóng gói sẵn để sử dụng trong các món ăn nhanh', NULL, 'Thịt hộp hấp', 50000, NULL, 1),
    (3, 'S003', '2024-01-19 18:10:16.000000', 'Sốt cà chua chín đỏ, thích hợp để làm nền cho các món pasta hoặc pizza', NULL, 'Sốt cà chua hộp', 15000, NULL, 1),
    (4, 'V004', '2024-01-19 18:10:16.000000', 'Rau mầm cải xanh tươi ngon, giàu dinh dưỡng, thích hợp để thêm vào salad hoặc làm rau sống', NULL, 'Rau mầm cải xanh', 8000, NULL, 2),
    (5, 'T005', '2024-01-19 18:10:16.000000', 'Gà tươi ngon, có thể chế biến thành nhiều món ăn khác nhau', NULL, 'Thịt gà tươi sống', 80000, NULL, 2),
    (6, 'H006', '2024-01-19 18:10:16.000000', 'Fillet cá hồi tươi ngon, giàu axit béo omega-3', NULL, 'Cá hồi tươi sống', 150000, NULL, 2),
    (7, 'F007', '2024-01-19 18:10:16.000000', 'Pizza với hải sản tươi sống, hỗn hợp phô mai, và sốt cà chua', NULL, 'Pizza hải sản đóng gói', 65000, NULL, 3),
    (8, 'M008', '2024-01-19 18:10:16.000000', 'Mì ý tươi ngon, đóng gói sẵn để nấu chín nhanh chóng', NULL, 'Mì ý đóng gói', 25000, NULL, 3),
    (9, 'I009', '2024-01-19 18:10:16.000000', 'Kem vani hảo hạng, đóng gói tiện lợi để thưởng thức ngay lập tức', NULL, 'Kem vani đóng gói', 30000, NULL, 3);

--
-- Indexes for dumped tables
--
--
-- Indexes for table `category`
--
ALTER TABLE `category`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK_rm1bp9bhtiih5foj17t8l500j` (`code`),
    ADD UNIQUE KEY `UK_dwk6cx0afu8bs9o4t536v1j5v` (`email`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK_nbyivu8qgmx0r7wtbplf01gf8` (`code`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK_28dgdc5siorptevhwl566i27v` (`code`),
    ADD KEY `FKk1m6gjs4m7rtgb5lw01g35yca` (`customer_id`),
    ADD KEY `FKkkkmw7q1tbeqtet9uxw2v0r1` (`employee_id`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
    ADD PRIMARY KEY (`order_id`, `product_id`),
    ADD KEY `FK3dy42byw9inbi11108wxlpl36` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK_h3w5r1mx6d0e5c6um32dgyjej` (`code`),
    ADD KEY `FK7l29ekt1x29jup80y2iigimyy` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 7;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 10;

--
-- Constraints for dumped tables
--
--
-- Constraints for table `order`
--
ALTER TABLE `order`
    ADD CONSTRAINT `FKk1m6gjs4m7rtgb5lw01g35yca` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
    ADD CONSTRAINT `FKkkkmw7q1tbeqtet9uxw2v0r1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
    ADD CONSTRAINT `FK3dy42byw9inbi11108wxlpl36` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    ADD CONSTRAINT `FK68mf7v62attypi34kgadriu28` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
    ADD CONSTRAINT `FK7l29ekt1x29jup80y2iigimyy` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

COMMIT;

SET FOREIGN_KEY_CHECKS = 0;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;


/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;


/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;
