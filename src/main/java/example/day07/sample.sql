DROP DATABASE IF EXISTS spring07;
CREATE DATABASE spring07;
USE spring07;

CREATE TABLE student (
    sno   INT AUTO_INCREMENT,
    sname VARCHAR(50) NOT NULL,
    skor  INT,
    smath INT,
    sdate DATETIME DEFAULT NOW(),
    CONSTRAINT PRIMARY KEY ( sno )
);

-- 10명의 학생 데이터 추가
INSERT INTO student (sname, skor, smath) VALUES ('김철수', 95, 88 );
INSERT INTO student (sname, skor, smath) VALUES ('이영희', 100, 92 );
INSERT INTO student (sname, skor, smath) VALUES ('박지성', 78, 85 );
INSERT INTO student (sname, skor, smath) VALUES ('최민준', 88, 91 );
INSERT INTO student (sname, skor, smath) VALUES ('정서연', 92, 99 );
INSERT INTO student (sname, skor, smath) VALUES ('강현우', 75, 80 );
INSERT INTO student (sname, skor, smath) VALUES ('조은지', 85, 87 );
INSERT INTO student (sname, skor, smath) VALUES ('윤도현', 98, 93 );
INSERT INTO student (sname, skor, smath) VALUES ('임하늘', 81, 79 );
INSERT INTO student (sname, skor, smath) VALUES ('한유나', 93, 96 );

SELECT * FROM student;