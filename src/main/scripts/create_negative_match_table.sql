CREATE TABLE `ldf`.`negative_match` (
  `negative_id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`negative_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));
