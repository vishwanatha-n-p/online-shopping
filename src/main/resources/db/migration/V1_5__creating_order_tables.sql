DROP TABLE order_details;

CREATE TABLE `products_order` (
  `id` INT AUTO_INCREMENT,
  `customer_detail_id` INT,
  `total_cost` INT NOT NULL,
  `payment_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT FK_customer_detail_id FOREIGN KEY (`customer_detail_id`) REFERENCES `customer_detail`(`id`),
  CONSTRAINT FK_payment_id FOREIGN KEY (`payment_id`) REFERENCES `payment`(`id`)
);

CREATE TABLE `order_details` (
  `id` INT AUTO_INCREMENT,
  `product_id` INT,
  `quantity` SMALLINT NOT NULL,
  `cost` INT NOT NULL,
  `order_status` VARCHAR(45) NOT NULL,
  `order_date` DATETIME,
  `ship_date` DATE,
  `delivery_date` DATE,
  `products_order_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT FK_ordered_product FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
  CONSTRAINT FK_products_order_id FOREIGN KEY (`products_order_id`) REFERENCES `products_order`(`id`)
);