CREATE SCHEMA hiper_quiz;

USE hiper_quiz; 

CREATE TABLE `users` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(15) UNIQUE NOT NULL,
`email` VARCHAR(15) UNIQUE NOT NULL,
`password` VARCHAR(15) NOT NULL, 
`gender` TINYINT(2),
`role` TINYINT(2),
`picture` VARCHAR(40),
`description` VARCHAR(25),
`metadata` VARCHAR(255),
`status` TINYINT(2),
`created` DATE NOT NULL,
`modified` DATE
);
