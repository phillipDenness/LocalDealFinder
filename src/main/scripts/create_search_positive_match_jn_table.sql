CREATE TABLE `ldf`.`search_positive_match_jn` (
  `search_id` INT NOT NULL,
  `positive_id` INT NOT NULL,
  INDEX `fk_positive_id_idx` (`positive_id` ASC),
  INDEX `fk_search_id_idx` (`search_id` ASC),
  CONSTRAINT `fk_search_id`
    FOREIGN KEY (`search_id`)
    REFERENCES `ldf`.`search` (`search_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkjn_positive_id`
    FOREIGN KEY (`positive_id`)
    REFERENCES `ldf`.`positive_match` (`positive_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);