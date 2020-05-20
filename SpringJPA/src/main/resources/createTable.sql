# khởi tạo 1 lân thôi nhá
CREATE DATABASE micro_db;
use micro_db;
CREATE TABLE user
(
  id        bigint(20) NOT NULL      AUTO_INCREMENT,
  hp   		int  NULL          DEFAULT NULL,
  stamina    int                  DEFAULT NULL,
  atk     int                    DEFAULT NULL,
  def      int                    DEFAULT NULL,
  agi      int                    DEFAULT NULL,
  PRIMARY KEY (id)
);


DELIMITER $$
CREATE PROCEDURE generate_data()
BEGIN
  DECLARE i INT DEFAULT 0;
  WHILE i < 100 DO
    INSERT INTO user (hp,stamina,atk,def,agi) VALUES (i,i,i,i,i);
    SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;

CALL generate_data();