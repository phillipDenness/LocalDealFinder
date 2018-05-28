CREATE TABLE `ldf`.`positive_match` (
  `positive_id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`positive_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));