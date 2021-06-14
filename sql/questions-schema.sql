CREATE TABLE `questions` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`quiz_id` INT UNSIGNED NOT NULL,
`text` VARCHAR(300) NOT NULL,
`picture` VARCHAR(300),
`created` DATE NOT NULL,
`modified` DATE,
CONSTRAINT fk_questions_quizzes
FOREIGN KEY (`quiz_id`)
REFERENCES `quizzes`(`id`)
);