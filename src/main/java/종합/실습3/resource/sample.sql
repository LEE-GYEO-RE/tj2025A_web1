drop database if exists mydb0805;
create database mydb0805;
use mydb0805;

create table waiting(
	wno int auto_increment not null ,
    phone varchar(15) not null ,
    count int not null,
    constraint primary key( wno )
);
select * from waiting;

insert into waiting (phone , count ) values ('010-1234-124' , 5 );
INSERT INTO waiting (phone, count) VALUES ('010-1234-0124', 5);
INSERT INTO waiting (phone, count) VALUES ('010-2345-5678', 3);
INSERT INTO waiting (phone, count) VALUES ('010-3456-7890', 2);
INSERT INTO waiting (phone, count) VALUES ('010-4567-8901', 4);
INSERT INTO waiting (phone, count) VALUES ('010-5678-9012', 1);
INSERT INTO waiting (phone, count) VALUES ('010-6789-0123', 6);
INSERT INTO waiting (phone, count) VALUES ('010-7890-1234', 2);
INSERT INTO waiting (phone, count) VALUES ('010-8901-2345', 5);
INSERT INTO waiting (phone, count) VALUES ('010-9012-3456', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1122-3344', 4);
INSERT INTO waiting (phone, count) VALUES ('010-2233-4455', 1);
INSERT INTO waiting (phone, count) VALUES ('010-3344-5566', 2);
INSERT INTO waiting (phone, count) VALUES ('010-4455-6677', 5);
INSERT INTO waiting (phone, count) VALUES ('010-5566-7788', 3);
INSERT INTO waiting (phone, count) VALUES ('010-6677-8899', 6);
INSERT INTO waiting (phone, count) VALUES ('010-7788-9900', 4);
INSERT INTO waiting (phone, count) VALUES ('010-8899-0011', 2);
INSERT INTO waiting (phone, count) VALUES ('010-9900-1122', 1);
INSERT INTO waiting (phone, count) VALUES ('010-1010-2020', 5);
INSERT INTO waiting (phone, count) VALUES ('010-2020-3030', 3);
INSERT INTO waiting (phone, count) VALUES ('010-3030-4040', 2);
INSERT INTO waiting (phone, count) VALUES ('010-4040-5050', 4);
INSERT INTO waiting (phone, count) VALUES ('010-5050-6060', 6);
INSERT INTO waiting (phone, count) VALUES ('010-6060-7070', 1);
INSERT INTO waiting (phone, count) VALUES ('010-7070-8080', 3);
INSERT INTO waiting (phone, count) VALUES ('010-8080-9090', 5);
INSERT INTO waiting (phone, count) VALUES ('010-9090-0000', 2);
INSERT INTO waiting (phone, count) VALUES ('010-0000-1111', 4);
INSERT INTO waiting (phone, count) VALUES ('010-1111-2222', 1);
INSERT INTO waiting (phone, count) VALUES ('010-2222-3333', 3);

select * from waiting;