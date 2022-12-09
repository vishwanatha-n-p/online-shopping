 CREATE TABLE `wishlist` (
    `id` INT AUTO_INCREMENT,
    `user_id` INT,
    PRIMARY KEY (`id`)
  );

CREATE TABLE `wishlist_product` (
   `wishlist_id` INT,
   `product_id` INT,
   CONSTRAINT FK_product_wishlist FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
   CONSTRAINT FK_wishlist_id FOREIGN KEY (`wishlist_id`) REFERENCES `wishlist`(`id`)
 );

 CREATE TABLE `cart_list_product` (
    `cartList_id` INT,
    `product_id` INT,
    CONSTRAINT FK_product_id FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
    CONSTRAINT FK_cartList_id FOREIGN KEY (`cartList_id`) REFERENCES `cart_list`(`id`)
  );