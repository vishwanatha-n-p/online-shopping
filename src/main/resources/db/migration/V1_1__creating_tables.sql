CREATE TABLE `product_category` (
  `id` INT AUTO_INCREMENT,
  `category_name` VARCHAR(45),
  `last_update` DATETIME,
  PRIMARY KEY (`id`),
  KEY `UN` (`category_name`),
  KEY `NL` (`last_update`)
);

CREATE TABLE `product_subcategory` (
  `id` INT AUTO_INCREMENT,
  `subcategory_name` VARCHAR(45),
  `last_update` DATETIME,
  `product_category_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT FK_product_category_id FOREIGN KEY (`product_category_id`) REFERENCES `product_category`(`id`),
  KEY `UN` (`subcategory_name`),
  KEY `NL` (`last_update`)
);

CREATE TABLE `product_types` (
  `id` INT AUTO_INCREMENT,
  `product_type` VARCHAR(45),
  `product_subcategory_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT FK_product_subcategory_id FOREIGN KEY (`product_subcategory_id`) REFERENCES `product_subcategory`(`id`),
  KEY `NN` (`product_type`)
);