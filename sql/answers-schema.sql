CREATE TABLE `hyperquiz`.`answers` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `question` INT UNSIGNED NOT NULL,
  `text` VARCHAR(150) NOT NULL,
  `picture` VARCHAR(300) NULL,
  `score` INT NOT NULL,
  `created` DATE NOT NULL,
  `modified` DATE NULL);
