user xe;
DROP TABLE day02;
CREATE TABLE `day02` (
	`num` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NULL DEFAULT NULL,
	`sub` VARCHAR(40) NULL DEFAULT  ���� ���� ,
	`content` TEXT NULL,
	`nalja` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`num`)
)
ENGINE=InnoDB
;