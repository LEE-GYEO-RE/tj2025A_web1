DROP DATABASE IF EXISTS exam04;
CREATE DATABASE exam04;
USE exam04;

CREATE TABLE waiting (
    wno   INT AUTO_INCREMENT,
    phone varchar(100)not null,
    count INT,
    wdate DATETIME DEFAULT NOW(),
    CONSTRAINT PRIMARY KEY ( wno )
);

insert into waiting (phone , count ) values ( '010-1234-1234' , 1);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1234', 1);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1235', 2);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1236', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1237', 1);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1238', 4);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1239', 2);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1240', 5);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1241', 1);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1242', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1243', 2);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1244', 4);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1245', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1246', 1);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1247', 5);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1248', 2);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1249', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1250', 4);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1251', 1);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1252', 2);
INSERT INTO waiting (phone, count) VALUES ('010-1234-1253', 5);

select * from waiting;
