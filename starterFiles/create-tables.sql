CREATE DATABASE  IF NOT EXISTS `rpg_helper`;
USE `rpg_helper`;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) AUTO_INCREMENT PRIMARY KEY,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (first_name, last_name, username, password, email)VALUES
	('David','Adams', 'd.adams', 'test123', 'david@luv2code.com'),
	('John','Doe', 'j.doe', 'test123', 'john@luv2code.com'),
	('Mary','Jane', 'm.jane', 'test123', 'mary@luv2code.com');


DROP TABLE IF EXISTS `characters`;
CREATE TABLE `rpg_helper`.`characters` (
   `characters_id` INT AUTO_INCREMENT,
   `name` VARCHAR(45) NOT NULL,
   `race` VARCHAR(45) NOT NULL,
   `encumbrance` INT NOT NULL,
   `flag_active` INT(1) NULL DEFAULT 0,
   `flag_dead` INT(1) NULL DEFAULT 0,
   `user_id` INT NULL,
   PRIMARY KEY (`characters_id`),
   INDEX `id_user_idx` (`user_id` ASC) VISIBLE,
   CONSTRAINT `id_user`
       FOREIGN KEY (`user_id`)
           REFERENCES `rpg_helper`.`user` (`user_id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION);