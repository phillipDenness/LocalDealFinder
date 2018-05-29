CREATE TABLE `ldf`.`search_negative_match_jn` (
  `search_id` INT NOT NULL,
  `negative_id` INT NOT NULL,
  INDEX `nmfk_search_id_idx` (`search_id` ASC),
  INDEX `nmfk_negative_id_idx` (`negative_id` ASC),
  CONSTRAINT `nmfk_search_id`
    FOREIGN KEY (`search_id`)
    REFERENCES `ldf`.`search` (`search_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nmfk_negative_id`
    FOREIGN KEY (`negative_id`)
    REFERENCES `ldf`.`negative_match` (`negative_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
