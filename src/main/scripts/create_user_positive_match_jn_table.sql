CREATE TABLE `ldf`.`user_positive_match_jn` (
  `user_id` INT NOT NULL,
  `positive_id` INT NOT NULL,
  INDEX `fk_positive_id_idx` (`positive_id` ASC),
  CONSTRAINT `upmj_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ldf`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `upmj_positive_id`
    FOREIGN KEY (`positive_id`)
    REFERENCES `ldf`.`positive_match` (`positive_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);