CREATE TABLE `ldf`.`user_advert_jn` (
  `user_id` INT NOT NULL,
  `advert_id` INT NULL,
  INDEX `fk_user_id_idx` (`user_id` ASC),
  INDEX `fk_advert_id_idx` (`advert_id` ASC),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ldf`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_id`
    FOREIGN KEY (`advert_id`)
    REFERENCES `ldf`.`advert` (`advert_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
