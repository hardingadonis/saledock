-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 17, 2024 lúc 11:47 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `saledock`
--
CREATE DATABASE IF NOT EXISTS `saledock` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `saledock`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `created_at`, `name`) VALUES
(1, '2024-01-19 18:10:16.000000', 'Thực phẩm đóng gói'),
(2, '2024-01-19 18:10:16.000000', 'Thực phẩm tươi sống'),
(3, '2024-01-19 18:10:16.000000', 'Thực phẩm đông lạnh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `address`, `code`, `created_at`, `email`, `name`, `updated_at`) VALUES
(1, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00001', '2024-01-19 18:10:16.000000', 'kh00001@gmail.com', 'Công ty TNHH A', '2024-01-19 18:10:16.000000'),
(2, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00002', '2024-01-19 18:10:16.000000', 'kh00002@gmail.com', 'Công ty TNHH B', NULL),
(3, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00003', '2024-01-19 18:10:16.000000', 'kh00003@gmail.com', 'Công ty TNHH C', '2024-01-19 18:10:16.000000'),
(4, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00004', NULL, 'kh00004@gmail.com', 'Công ty TNHH D', NULL),
(5, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00005', NULL, 'kh00005@gmail.com', 'Công ty TNHH E', NULL),
(6, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00006', NULL, 'kh00006@gmail.com', 'Công ty TNHH F', NULL),
(7, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00007', NULL, 'kh00007@gmail.com', 'Công ty TNHH G', NULL),
(8, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00008', NULL, 'kh00008@gmail.com', 'Công ty TNHH H', NULL),
(9, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00009', NULL, 'kh00009@gmail.com', 'Công ty TNHH I', NULL),
(10, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00010', NULL, 'kh00010@gmail.com', 'Công ty TNHH K', NULL),
(11, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00011', NULL, 'kh00011@gmail.com', 'Công ty TNHH L', NULL),
(12, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00012', NULL, 'kh00012@gmail.com', 'Công ty TNHH M', NULL),
(13, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00013', NULL, 'kh00013@gmail.com', 'Công ty TNHH J', NULL),
(14, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00014', NULL, 'kh00014@gmail.com', 'Công ty TNHH O', NULL),
(15, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00015', NULL, 'kh00015@gmail.com', 'Công ty TNHH P', NULL),
(16, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00016', NULL, 'kh00016@gmail.com', 'Công ty TNHH T', NULL),
(17, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00017', NULL, 'kh00017@gmail.com', 'Công ty TNHH R', NULL),
(18, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00018', NULL, 'kh00018@gmail.com', 'Công ty TNHH Y', NULL),
(19, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00019', NULL, 'kh00019@gmail.com', 'Công ty TNHH X', NULL),
(20, 'Phường Nhơn Bình, Thành phố Quy Nhơn, Tỉnh Bình Định', 'KH00020', NULL, 'kh00020@gmail.com', 'Công ty TNHH Z', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `id` int(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `code`, `created_at`, `email`, `name`, `password`, `updated_at`) VALUES
(1, 'QE170148', '2024-01-19 18:10:16.000000', 'vuonglmqe170148@fpt.edu.vn', 'Lê Minh Vương', '827ccb0eea8a706c4c34a16891f84e7b', '2024-01-19 18:10:16.000000'),
(2, 'QE170033', '2024-01-19 18:10:16.000000', 'thuyntqe170033@fpt.edu.vn', 'Nguyễn Thị Thúy', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
(3, 'QE170097', '2024-01-19 18:10:16.000000', 'chuongdqqe170097@fpt.edu.vn', 'Đinh Quốc Chương', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
(4, 'QE170173', '2024-01-19 18:10:16.000000', 'nghiahtqe170173@fpt.edu.vn', 'Hồ Trọng Nghĩa', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
(5, 'QE170212', '2024-01-19 18:10:16.000000', 'sonntqe170212@fpt.edu.vn', 'Nguyễn Thái Sơn', '827ccb0eea8a706c4c34a16891f84e7b', NULL),
(6, 'QE170023', '2024-01-19 18:10:16.000000', 'linhlmqe170023@fpt.edu.vn', 'Lâm Mỹ Linh', '827ccb0eea8a706c4c34a16891f84e7b', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `id` int(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `note` longtext DEFAULT NULL,
  `status` enum('PENDING','SHIPPING','DONE','CANCELLED') NOT NULL,
  `total` double NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `customer_id` int(20) NOT NULL,
  `employee_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`id`, `code`, `created_at`, `note`, `status`, `total`, `updated_at`, `customer_id`, `employee_id`) VALUES
(1, '9423198AE8A44E7', '2024-01-19 18:10:16.000000', NULL, 'PENDING', 7078000, NULL, 3, 1),
(2, '21BD4E4E65094E6', '2024-01-19 18:10:16.000000', NULL, 'PENDING', 10290000, NULL, 1, 1),
(3, '2E31F002600A46B', '2024-03-17 17:11:26.000000', '', 'PENDING', 6275000, NULL, 5, 3),
(4, '40791F5BDA8D477', '2024-03-17 17:12:46.000000', '', 'PENDING', 4500000, NULL, 7, 3),
(5, 'E9E2BA0E17B3491', '2024-03-17 17:13:32.000000', '', 'PENDING', 50000000, NULL, 13, 3),
(6, 'BDFBD5BDD4F44FC', '2024-03-17 17:14:23.000000', '', 'PENDING', 13600000, NULL, 9, 3),
(7, '6A0EEACDE04F46B', '2024-03-17 17:15:44.000000', '', 'PENDING', 48000000, NULL, 19, 3),
(8, '7B944844ED034B4', '2024-03-17 17:16:39.000000', '', 'PENDING', 2300000, NULL, 16, 3),
(9, '7C0475BF262D457', '2024-03-17 17:17:04.000000', '', 'PENDING', 8000000, NULL, 20, 3),
(10, '2D74DAFD29F0426', '2024-03-17 17:17:29.000000', '', 'PENDING', 15450000, NULL, 11, 3),
(11, '4AA4F4893B09469', '2024-03-17 17:18:25.000000', '', 'PENDING', 4000000, NULL, 12, 3),
(12, '064487392A5740D', '2024-03-17 17:18:59.000000', '', 'PENDING', 3800000, NULL, 14, 3),
(13, 'E0388B304752421', '2024-03-17 17:19:28.000000', '', 'PENDING', 7242000, NULL, 15, 3),
(14, '4905E8ABB1DE4CC', '2024-03-17 17:19:47.000000', '', 'PENDING', 180000, NULL, 10, 3),
(15, '6D9756D62915488', '2024-03-17 17:20:06.000000', '', 'PENDING', 52000, NULL, 9, 3),
(16, 'BE5A672076CB427', '2024-03-17 17:20:29.000000', '', 'PENDING', 150000, NULL, 17, 3),
(17, 'AB8D2051AF10462', '2024-03-17 17:20:53.000000', '', 'PENDING', 110000, NULL, 8, 3),
(18, '14B5D3DC5D01484', '2024-03-17 17:21:31.000000', '', 'PENDING', 65000, NULL, 6, 3),
(19, 'AFEAD2D8D1D846A', '2024-03-17 17:21:49.000000', '', 'PENDING', 45000, NULL, 11, 3),
(20, 'B39D0AD14321471', '2024-03-17 17:22:41.000000', '', 'PENDING', 151800000000000, NULL, 3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `quantity` int(11) NOT NULL,
  `order_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`quantity`, `order_id`, `product_id`) VALUES
(341, 1, 4),
(145, 1, 9),
(34, 2, 2),
(16, 2, 3),
(334, 2, 8),
(20, 3, 13),
(20, 3, 16),
(11, 3, 17),
(4, 3, 20),
(100, 4, 11),
(200, 4, 12),
(100, 5, 15),
(100, 5, 16),
(100, 5, 20),
(50, 6, 10),
(50, 6, 14),
(50, 6, 15),
(100, 7, 5),
(100, 7, 6),
(100, 7, 13),
(100, 7, 15),
(100, 7, 17),
(100, 8, 4),
(100, 8, 11),
(100, 9, 3),
(100, 9, 7),
(100, 10, 6),
(10, 10, 17),
(100, 11, 12),
(100, 11, 13),
(10, 12, 2),
(10, 12, 6),
(10, 12, 15),
(11, 13, 10),
(100, 13, 20),
(1, 14, 6),
(2, 14, 12),
(1, 15, 10),
(1, 15, 11),
(1, 15, 12),
(1, 16, 5),
(1, 16, 14),
(1, 17, 5),
(1, 17, 11),
(1, 17, 12),
(1, 18, 3),
(2, 18, 13),
(1, 19, 4),
(1, 19, 10),
(1, 19, 12),
(1000000000, 20, 6),
(10000000, 20, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `image_url` longtext DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `category_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `code`, `created_at`, `description`, `image_url`, `name`, `price`, `updated_at`, `category_id`) VALUES
(1, 'P001', '2024-01-19 18:10:16.000000', 'Bún gạo trắng và mềm, dùng để nấu các món phở và mì Quảng', 'product_img/bun-gao.jpg', 'Bún gạo đóng gói', 20000, '2024-03-17 16:50:17.000000', 1),
(2, 'C002', '2024-01-19 18:10:16.000000', 'Thịt heo hấp nhẹ, đóng gói sẵn để sử dụng trong các món ăn nhanh', 'product_img/thit-hop-hap.jpg', 'Thịt hộp hấp', 50000, '2024-03-17 17:39:25.000000', 1),
(3, 'S003', '2024-01-19 18:10:16.000000', 'Sốt cà chua chín đỏ, thích hợp để làm nền cho các món pasta hoặc pizza', 'product_img/sot-ca-chua.jpg', 'Sốt cà chua hộp', 15000, '2024-03-17 16:51:44.000000', 1),
(4, 'V004', '2024-01-19 18:10:16.000000', 'Rau mầm cải xanh tươi ngon, giàu dinh dưỡng, thích hợp để thêm vào salad hoặc làm rau sống', 'product_img/rau-cai-xanh.jpg', 'Rau mầm cải xanh', 8000, '2024-03-17 16:52:50.000000', 2),
(5, 'T005', '2024-01-19 18:10:16.000000', 'Gà tươi ngon, có thể chế biến thành nhiều món ăn khác nhau', 'product_img/thit-ga.jpg', 'Thịt gà tươi sống', 80000, '2024-03-17 16:53:30.000000', 2),
(6, 'H006', '2024-01-19 18:10:16.000000', 'Fillet cá hồi tươi ngon, giàu axit béo omega-3', 'product_img/ca-hoi-tuoi.png', 'Cá hồi tươi sống', 150000, '2024-03-17 16:55:04.000000', 2),
(7, 'F007', '2024-01-19 18:10:16.000000', 'Pizza với hải sản tươi sống, hỗn hợp phô mai, và sốt cà chua', 'product_img/pizza.png', 'Pizza hải sản đóng gói', 65000, '2024-03-17 16:56:45.000000', 3),
(8, 'M008', '2024-01-19 18:10:16.000000', 'Mì ý tươi ngon, đóng gói sẵn để nấu chín nhanh chóng', 'product_img/my-y.jpg', 'Mì ý đóng gói', 25000, '2024-03-17 16:57:47.000000', 3),
(9, 'I009', '2024-01-19 18:10:16.000000', 'Kem vani hảo hạng, đóng gói tiện lợi để thưởng thức ngay lập tức', 'product_img/kem.jpg', 'Kem vani đóng gói', 30000, '2024-03-17 16:58:32.000000', 3),
(10, 'Q312', '2024-03-17 17:00:20.000000', '', 'product_img/chao-ca-hoi.jpg', 'Cháo Fun Cá Hồi Phô Mai', 22000, NULL, 1),
(11, 'N954', '2024-03-17 17:01:14.000000', '', 'product_img/mi-xao.jpg', 'Mì Xào Táo Quân Thập Cẩm', 15000, NULL, 1),
(12, 'Q527', '2024-03-17 17:02:03.000000', '', 'product_img/mi-omachi.jpg', 'Mì Omachi Xốt Bò Hầm Ly', 15000, NULL, 1),
(13, 'H629', '2024-03-17 17:02:42.000000', '', 'product_img/pate.jpg', 'Pate Gan Hạ Long', 25000, NULL, 1),
(14, 'C573', '2024-03-17 17:03:32.000000', '', 'product_img/cu-kieu.jpg', 'Củ Kiệu Chua Ngọt ', 70000, NULL, 1),
(15, 'G018', '2024-03-17 17:05:16.000000', '', 'product_img/heo-ba-roi.png', 'BA RỌI HEO KHÔNG DA VIETGAP 1KG', 180000, NULL, 2),
(16, 'T199', '2024-03-17 17:06:05.000000', '', 'product_img/thit-bo.png', 'NẠM BÒ ÚC 1KG', 250000, NULL, 2),
(17, 'G747', '2024-03-17 17:06:57.000000', '', 'product_img/nam.jpg', 'COMBO NẤM THỦY TIÊN MALAYSIA HỘP 200GR', 45000, NULL, 2),
(18, 'H533', '2024-03-17 17:07:42.000000', '', 'product_img/dao.jpg', 'ĐÀO ĐỎ 500G', 55000, NULL, 2),
(19, 'B617', '2024-03-17 17:09:02.000000', '', 'product_img/bo-vien-fuji.jpg', 'Bò viên Fuji', 100000, '2024-03-17 17:42:24.000000', 3),
(20, 'P387', '2024-03-17 17:09:59.000000', '', 'product_img/thanh-cua-mayumi.jpg', 'Thanh cua truyền thống Mayumi', 70000, '2024-03-17 17:45:23.000000', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rm1bp9bhtiih5foj17t8l500j` (`code`),
  ADD UNIQUE KEY `UK_dwk6cx0afu8bs9o4t536v1j5v` (`email`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_nbyivu8qgmx0r7wtbplf01gf8` (`code`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_28dgdc5siorptevhwl566i27v` (`code`),
  ADD KEY `FKk1m6gjs4m7rtgb5lw01g35yca` (`customer_id`),
  ADD KEY `FKkkkmw7q1tbeqtet9uxw2v0r1` (`employee_id`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_id`,`product_id`),
  ADD KEY `FK3dy42byw9inbi11108wxlpl36` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_h3w5r1mx6d0e5c6um32dgyjej` (`code`),
  ADD KEY `FK7l29ekt1x29jup80y2iigimyy` (`category_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FKk1m6gjs4m7rtgb5lw01g35yca` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKkkkmw7q1tbeqtet9uxw2v0r1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK3dy42byw9inbi11108wxlpl36` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FK68mf7v62attypi34kgadriu28` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK7l29ekt1x29jup80y2iigimyy` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
