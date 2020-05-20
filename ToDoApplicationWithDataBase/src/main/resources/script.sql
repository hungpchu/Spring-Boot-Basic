# CREATE SCHEMA IF NOT EXISTS todo_db;
USE todo_db;
CREATE TABLE ToDo
(
    id INT NOT NULL AUTO_INCREMENT,
    title CHAR(255) NOT NULL,
    detail CHAR(255) NOT NULL,
    primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO ToDo VALUES (1,'hung chu', 'dep trai')

