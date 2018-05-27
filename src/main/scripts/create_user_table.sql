CREATE TABLE `ldf`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `alias` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `alias_UNIQUE` (`alias` ASC));