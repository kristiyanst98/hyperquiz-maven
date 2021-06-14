CREATE TABLE `hyperquiz`.`quizresults` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `player_id` INT UNSIGNED NOT NULL,
  `quiz_id` INT UNSIGNED NOT NULL,
  `created` DATE NOT NULL,
  `modified` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_quizresults_users_id_idx` (`player_id` ASC) VISIBLE,
  INDEX `fk_quizresults_quizzes_id_idx` (`quiz_id` ASC) VISIBLE,
  CONSTRAINT `fk_quizresults_users_id`
    FOREIGN KEY (`player_id`)
    REFERENCES `hyperquiz`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_quizresults_quizzes_id`
    FOREIGN KEY (`quiz_id`)
    REFERENCES `hyperquiz`.`quizzes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);