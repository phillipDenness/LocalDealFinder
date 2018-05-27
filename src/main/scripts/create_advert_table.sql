CREATE TABLE `ldf`.`advert` (
  `advert_id` int NOT NULL AUTO_INCREMENT,
  `advert_title` VARCHAR(45) NOT NULL,
  `advert_price` double NOT NULL,
  `advert_link` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`advert_id`),
  UNIQUE INDEX `advert_link_UNIQUE` (`advert_link` ASC));
