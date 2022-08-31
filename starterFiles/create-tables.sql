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



DROP TABLE IF EXISTS `player_character`;
CREATE TABLE `rpg_helper`.`player_character` (
  `character_id` INT AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `race` VARCHAR(45) DEFAULT 'human',
  `carry_weight` INT NOT NULL DEFAULT 10,
  `flag_active` INT(1) NULL DEFAULT 0,
  `flag_dead` INT(1) NULL DEFAULT 0,
  `datetime_add` DATE,
  `user_id` INT NULL,
  PRIMARY KEY (`character_id`),
  CONSTRAINT `FK_user_character` FOREIGN KEY (`user_id`)
      REFERENCES `rpg_helper`.`user` (`user_id`)) AUTO_INCREMENT=1 CHARSET=latin1;

describe `player_character`;


DROP TABLE IF EXISTS `npc`;
CREATE TABLE `npc` (
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `name` varchar(128) DEFAULT NULL,
                       `user_id` int(11) DEFAULT NULL,

                       PRIMARY KEY (`id`),

                       UNIQUE KEY `TITLE_UNIQUE` (`name`),

                       KEY `FK_INSTRUCTOR_idx` (`user_id`),

                       CONSTRAINT `FK_USER_NPC`
                           FOREIGN KEY (`user_id`)
                               REFERENCES `user` (`user_id`)

                               ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;