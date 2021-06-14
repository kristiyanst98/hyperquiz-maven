CREATE TABLE `quizzes` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(80) UNIQUE NOT NULL,
`author` INT UNSIGNED NOT NULL ,
`description` VARCHAR(250), 
`expected_duration` INT,
`picture` VARCHAR(300),
`tags` VARCHAR(80),
`created` DATE NOT NULL,
`modified` DATE
);

ALTER TABLE `quizzes`
ADD CONSTRAINT fk_quizzes_users
FOREIGN KEY (`author`)
REFERENCES `users` (`id`);
