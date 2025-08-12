drop database if exists example5;
create database example5;
use example5;

create table waiting(
	wno int auto_increment,
    phone varchar(100) not null,
    count int not null,
    w_date datetime default current_timestamp,
    constraint primary key (wno)
    );
    
INSERT INTO waiting (phone, count) VALUES ('010-1234-1234', 5);
INSERT INTO waiting (phone, count) VALUES ('010-2345-2345', 3);
INSERT INTO waiting (phone, count) VALUES ('010-3456-3456', 2);
INSERT INTO waiting (phone, count) VALUES ('010-4567-4567', 4);
INSERT INTO waiting (phone, count) VALUES ('010-5678-5678', 1);
INSERT INTO waiting (phone, count) VALUES ('010-6789-6789', 6);
INSERT INTO waiting (phone, count) VALUES ('010-7890-7890', 2);
INSERT INTO waiting (phone, count) VALUES ('010-8901-8901', 3);
INSERT INTO waiting (phone, count) VALUES ('010-9012-9012', 5);
INSERT INTO waiting (phone, count) VALUES ('010-0123-0123', 4);
INSERT INTO waiting (phone, count) VALUES ('010-1111-1111', 1);
INSERT INTO waiting (phone, count) VALUES ('010-2222-2222', 2);
INSERT INTO waiting (phone, count) VALUES ('010-3333-3333', 3);
INSERT INTO waiting (phone, count) VALUES ('010-4444-4444', 4);
INSERT INTO waiting (phone, count) VALUES ('010-5555-5555', 5);
INSERT INTO waiting (phone, count) VALUES ('010-6666-6666', 6);
INSERT INTO waiting (phone, count) VALUES ('010-7777-7777', 2);
INSERT INTO waiting (phone, count) VALUES ('010-8888-8888', 3);
INSERT INTO waiting (phone, count) VALUES ('010-9999-9999', 1);
INSERT INTO waiting (phone, count) VALUES ('010-0000-0000', 4);


select * from waiting;