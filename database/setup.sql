CREATE TABLE `customer` (
  `id` VARCHAR(255) PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `fax` VARCHAR(20) NOT NULL,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `product` (
  `id` VARCHAR(255) PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT NOT NULL,
  `price` REAL NOT NULL,
  `category_id` VARCHAR(255) NOT NULL,
  `image_url` LONGTEXT,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `category` (
  `category_id` VARCHAR(255) PRIMARY KEY,
  `category_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `employee` (
  `id` VARCHAR(255) PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `order` (
  `order_id` VARCHAR(255) PRIMARY KEY,
  `employee_id` VARCHAR(255),
  `customer_id` VARCHAR(255) NOT NULL,
  `status` ENUM ('pending', 'shipping', 'done', 'canceled') NOT NULL,
  `total` REAL NOT NULL,
  `note` TEXT,
  `created_at` TIMESTAMP DEFAULT null,
  `updated_at` TIMESTAMP DEFAULT null
);

CREATE TABLE `order_detail` (
  `order_id` VARCHAR(255),
  `product_id` VARCHAR(255),
  `quantity` INT NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`)
);

ALTER TABLE `order` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

ALTER TABLE `order_detail` ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);

ALTER TABLE `product` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

ALTER TABLE `order_detail` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

ALTER TABLE `order` ADD FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);
