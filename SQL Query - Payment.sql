CREATE DATABASE carcare;

-- service table
CREATE TABLE `carcare`.`service` (
  `service_id` INT NOT NULL AUTO_INCREMENT,
  `service_name` VARCHAR(50),
  `discount` DOUBLE(20,2) NULL,
  `price` DOUBLE(10,2) NULL,
  PRIMARY KEY (`service_id`));
  
  select * from bill where user_id = 3;
-- Search
	SELECT * FROM `carcare`.`service` where service_name LIKE "Exter%";
-- Retrieve service
-- SELECT * FROM `carcare`.`service`;

-- Insert service
-- INSERT INTO `carcare`.`service` (`service_id`, `service_name`, `discount`, `price`) VALUES ('0', 'as', '4', '3');

-- Update service
-- UPDATE `carcare`.`service` SET `service_name` = ?, `discount` = ?, `price` = ? WHERE (`service_id` = ?);

-- Delete serviceservice
-- DELETE FROM `carcare`.`service` WHERE (`service_id` = ?);

-- user table
CREATE TABLE `carcare`.`user` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50),
    PRIMARY KEY (`user_id`));
    
SELECT * FROM `carcare`.`user`
    