show databases;
use test;
CREATE TABLE todo
(
    id        int(20) NOT NULL      AUTO_INCREMENT,
    tittle      char  NOT NULL,
    detail     char  NOT NULL,
    PRIMARY KEY (id)
);