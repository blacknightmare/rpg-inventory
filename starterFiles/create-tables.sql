CREATE DATABASE  IF NOT EXISTS `rpg_helper`;
USE `rpg_helper`;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` int(11) AUTO_INCREMENT PRIMARY KEY,
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


CREATE TABLE `rpg_helper`.`characters` (
   `id_characters` INT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(45) NOT NULL,
   `race` VARCHAR(45) NOT NULL,
   `encumbrance` INT NOT NULL,
   `flag_active` INT(1) NULL DEFAULT 0,
   `flag_dead` INT(1) NULL DEFAULT 0,
   `id_user` INT NULL,
   PRIMARY KEY (`id_characters`),
   INDEX `id_user_idx` (`id_user` ASC) VISIBLE,
   CONSTRAINT `id_user`
       FOREIGN KEY (`id_user`)
           REFERENCES `rpg_helper`.`user` (`id_user`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION);