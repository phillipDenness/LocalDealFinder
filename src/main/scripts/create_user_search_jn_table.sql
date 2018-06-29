CREATE TABLE `ldf`.`user_search_jn` (
  `user_id` INT NOT NULL,
  `search_id` INT NOT NULL,
  INDEX `fks_user_id_idx` (`user_id` ASC),
  INDEX `fks_search_id_idx` (`search_id` ASC),
  CONSTRAINT `fks_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ldf`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fks_search_id`
    FOREIGN KEY (`search_id`)
    REFERENCES `ldf`.`search` (`search_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
