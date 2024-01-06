CREATE TABLE `customer` (
  `customer_id` VARCHAR(255) PRIMARY KEY,
  `company_name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `company_address` VARCHAR(255),
  `fax` VARCHAR(20),
  `created_at` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
);

CREATE TABLE `product` (
  `product_id` VARCHAR(255) PRIMARY KEY,
  `product_name` VARCHAR(255) NOT NULL,
  `description` TEXT NOT NULL,
  `price` REAL NOT NULL,
  `category_id` VARCHAR(255) NOT NULL,
  `image_url` TEXT NOT NULL,
  `created_at` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
);

CREATE TABLE `category` (
  `category_id` VARCHAR(255) PRIMARY KEY,
  `category_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `employee` (
  `employee_id` VARCHAR(255) PRIMARY KEY,
  `employee_name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255),
  `address` VARCHAR(255),
  `createdAt` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
);

CREATE TABLE `warehouse` (
  `warehouse_id` VARCHAR(255) PRIMARY KEY,
  `warehouse_name` VARCHAR(255) NOT NULL,
  `employee_id` VARCHAR(255),
  `address` VARCHAR(255),
  `createdAt` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
);

CREATE TABLE `warehouse_stock` (
  `warehouse_id` VARCHAR(255),
  `product_id` VARCHAR(255),
  `quantity` INT
);

CREATE TABLE `order` (
  `order_id` VARCHAR(255) PRIMARY KEY,
  `employee_id` VARCHAR(255),
  `customer_id` VARCHAR(255) NOT NULL,
  `orderDate` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP),
  `order_status_id` VARCHAR(255) NOT NULL,
  `total` REAL NOT NULL,
  `note` TEXT
);

CREATE TABLE `order_status` (
  `order_status_id` VARCHAR(255) PRIMARY KEY,
  `order_status_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `order_details` (
  `order_detail_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `order_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `quantity` INT NOT NULL,
  `price_order` REAL NOT NULL
);

ALTER TABLE `order` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);

ALTER TABLE `order` ADD FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`order_status_id`);

ALTER TABLE `product` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

ALTER TABLE `warehouse_stock` ADD FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`);

ALTER TABLE `warehouse_stock` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

ALTER TABLE `order` ADD FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

ALTER TABLE `warehouse` ADD FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);
