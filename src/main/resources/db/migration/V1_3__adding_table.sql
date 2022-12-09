CREATE TABLE `currency` (
   `id` INT AUTO_INCREMENT,
   `currency_name` VARCHAR(45) UNIQUE,
   `last_update` DATETIME,
   PRIMARY KEY (`id`)
 );

 ALTER TABLE price_detail
 ADD currency_id INT,
 ADD CONSTRAINT FK_currency_id FOREIGN KEY(currency_id) REFERENCES currency(id);
