CREATE TABLE `customer` (
  `id` int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID dùng để quản lý, tự động tăng',
  `code` varchar(255) UNIQUE NOT NULL COMMENT 'Mã khách hàng, sẽ hiện trên giao diện, ID thì không hiện',
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `product` (
  `id` int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID dùng để quản lý, tự động tăng',
  `code` varchar(255) UNIQUE NOT NULL COMMENT 'Mã sản phẩm, sẽ hiện trên giao diện, ID thì không hiện',
  `name` varchar(255) NOT NULL,
  `description` TEXT,
  `price` REAL NOT NULL,
  `category_id` int NOT NULL,
  `image_url` LONGTEXT,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `category` (
  `id` int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID dùng để quản lý, tự động tăng',
  `name` varchar(255) NOT NULL
);

CREATE TABLE `employee` (
  `id` int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID dùng để quản lý, tự động tăng',
  `code` varchar(255) UNIQUE NOT NULL COMMENT 'Mã nhân viên, sẽ hiện trên giao diện, dùng để đăng nhập, vd QE170001',
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `order` (
  `id` int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID dùng để quản lý, tự động tăng',
  `code` varchar(255) UNIQUE NOT NULL,
  `employee_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `status` ENUM ('pending', 'shipping', 'done', 'cancelled') NOT NULL,
  `total` REAL NOT NULL,
  `note` TEXT DEFAULT null,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `order_detail` (
  `order_id` int,
  `product_id` int,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`)
);

ALTER TABLE `order` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

ALTER TABLE `order_detail` ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

ALTER TABLE `product` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `order_detail` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

ALTER TABLE `order` ADD FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);
