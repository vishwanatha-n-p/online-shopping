CREATE TABLE `price_detail` (
  `id` INT AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  `currency_name` VARCHAR(45) NOT NULL,
  `quantityType` VARCHAR(10),
  `price` BIGINT NOT NULL,
  `availability_count` INT NOT NULL,
  `discount` INT,
  `special_offer_discount` INT,
  `delivery_charge` INT,
  `final_price` INT NOT NULL,
  `last_update` DATETIME ,
  PRIMARY KEY (`id`)
);

CREATE TABLE `highlights` (
   `id` INT AUTO_INCREMENT,
   `product_name` VARCHAR(45) NOT NULL,
   `features` MEDIUMTEXT NOT NULL,
   `size` VARCHAR(200) NOT NULL,
   `last_update` DATETIME,
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `product` (
   `id` INT AUTO_INCREMENT,
   `model_number` VARCHAR(45) UNIQUE,
   `color` VARCHAR(45) NOT NULL,
   `price_detail_id` INT,
   `highlights_id` INT,
   `description` MEDIUMTEXT,
   `product_type_id` INT,
   PRIMARY KEY (`id`),
   CONSTRAINT FK_highlights_id FOREIGN KEY (`highlights_id`) REFERENCES `highlights`(`id`),
   CONSTRAINT FK_price_detail_id FOREIGN KEY (`price_detail_id`) REFERENCES `price_detail`(`id`),
   CONSTRAINT FK_product_type_id FOREIGN KEY (`product_type_id`) REFERENCES `product_types`(`id`)
 );

 CREATE TABLE `seller` (
   `id` INT AUTO_INCREMENT,
   `seller_name` VARCHAR(45) NOT NULL,
   `service` VARCHAR(45),
   `contact_number` VARCHAR(13) NOT NULL,
   `email` VARCHAR(45) UNIQUE,
   `street` VARCHAR(45),
   `city` VARCHAR(45) NOT NULL,
   `state` VARCHAR(45) NOT NULL,
   `postal_code` CHAR(8) NOT NULL,
   `country` VARCHAR(45) NOT NULL,
   `last_update` DATETIME,
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `seller_product` (
   `seller_id` INT,
   `product_id` INT,
   CONSTRAINT FK_product_id FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
   CONSTRAINT FK_seller_id FOREIGN KEY (`seller_id`) REFERENCES `seller`(`id`)
 );

 CREATE TABLE `cart_list` (
   `id` INT AUTO_INCREMENT,
   `product_id` INT,
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `wish_list` (
   `id` INT AUTO_INCREMENT,
   `product_id` INT,
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `role` (
   `id` INT AUTO_INCREMENT,
   `role_name` VARCHAR(45),
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `user` (
   `id` INT AUTO_INCREMENT,
   `username` VARCHAR(45) NOT NULL,
   `password` VARCHAR(60) UNIQUE,
   `role_id` INT,
   PRIMARY KEY (`id`),
   CONSTRAINT FK_role_customer FOREIGN KEY (`role_id`) REFERENCES `role`(`id`)
 );

 CREATE TABLE `address` (
   `id` INT AUTO_INCREMENT,
   `street` VARCHAR(45),
   `city` VARCHAR(45) NOT NULL,
   `state` VARCHAR(45) NOT NULL,
   `postal_code` CHAR(6) NOT NULL,
   `country` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `customer_detail` (
   `id` INT AUTO_INCREMENT,
   `first_name` VARCHAR(45) NOT NULL,
   `last_name` VARCHAR(45) NOT NULL,
   `email` VARCHAR(45) UNIQUE,
   `contact_number` VARCHAR(13) NOT NULL,
   `shipping_address_id` INT,
   `billing_address_id` INT,
   `user_id` INT,
   PRIMARY KEY (`id`),
   CONSTRAINT FK_user_customer_detail FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
   CONSTRAINT FK_shipping_address_id FOREIGN KEY (`shipping_address_id`) REFERENCES `address`(`id`),
   CONSTRAINT FK_billing_address_id FOREIGN KEY (`billing_address_id`) REFERENCES `address`(`id`)
 );

 CREATE TABLE `my_orders` (
   `id` INT AUTO_INCREMENT,
   `name` VARCHAR(45) NOT NULL,
   `model_number` VARCHAR(45) UNIQUE,
   `image` MEDIUMBLOB,
   `color` VARCHAR(45) NOT NULL,
   `price` INT NOT NULL,
   `quantity` INT NOT NULL,
   `discount` INT,
   `special_offer_discount` INT,
   `delivery_charge` INT,
   `final_price` INT NOT NULL,
   `order_status` VARCHAR(45) NOT NULL,
   `order_date` DATETIME,
   `user_id` INT,
   PRIMARY KEY (`id`),
   CONSTRAINT FK_user_my_orders FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
 );

 CREATE TABLE `payment_mode` (
   `id` INT AUTO_INCREMENT,
   `mode_name` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`id`)
 );

 CREATE TABLE `payment` (
   `id` INT AUTO_INCREMENT,
   `payment_mode_id` INT,
   `amount` INT NOT NULL,
   `payment_date` DATETIME,
   `payment_status` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT FK_payment_mode_id FOREIGN KEY (`payment_mode_id`) REFERENCES `payment_mode`(`id`)
 );

 CREATE TABLE `order_details` (
   `id` INT AUTO_INCREMENT,
   `product_id` INT,
   `quantity` SMALLINT NOT NULL,
   `customer_detail_id` INT,
   `payment_id` INT,
   `order_status` VARCHAR(45) NOT NULL,
   `order_date` DATETIME,
   `ship_date` DATE,
   `delivery_date` DATE,
   PRIMARY KEY (`id`),
   CONSTRAINT FK_product_order_details FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
   CONSTRAINT FK_customer_detail_order_details FOREIGN KEY (`customer_detail_id`) REFERENCES `customer_detail`(`id`),
   CONSTRAINT FK_payment_order_details FOREIGN KEY (`payment_id`) REFERENCES `payment`(`id`)
 );