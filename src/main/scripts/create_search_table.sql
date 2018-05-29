CREATE TABLE `ldf`.`search` (
  `search_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `min_price` DOUBLE NULL,
  `max_price` DOUBLE NULL,
  PRIMARY KEY (`search_id`));
