CREATE TABLE `shopper`.`advert` (
  `advert_id` INT NOT NULL,
  `advert_title` VARCHAR(45) NOT NULL,
  `advert_price` VARCHAR(45) NOT NULL,
  `advert_link` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`advert_id`),
  UNIQUE INDEX `advert_link_UNIQUE` (`advert_link` ASC));
