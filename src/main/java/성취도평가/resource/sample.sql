drop database if exists assessment;
create database assessment;
use assessment;

create table member(
	custno int auto_increment,		
    custname varchar(20),	
    phone varchar(13),
    address varchar(60),
    joindate date ,
    grade char(1) ,
    city char(2) ,
    constraint primary key(custno)
);

create table money(
	custno int not null,
    salenol int not null,
    pcost int,
    amount int ,
    price int ,
    pcode varchar(4) ,
    sdate datetime default current_timestamp,
    constraint primary key(salenol),
    constraint foreign key(custno) references member(custno) on update cascade on delete cascade
);

alter table member auto_increment = 100001;

DELIMITER $$

CREATE TRIGGER trg_generate_salenol
BEFORE INSERT ON money
FOR EACH ROW
BEGIN
    DECLARE max_num INT;
    DECLARE prefix VARCHAR(4);
    DECLARE next_num INT;

    -- 예: '2025'
    SET prefix = DATE_FORMAT(CURRENT_DATE, '%Y');

    -- 예: 20250001, 20250002 중 가장 큰 숫자 찾기
    SET max_num = (
        SELECT IFNULL(MAX(salenol), 0)
        FROM money
        WHERE LEFT(salenol, 4) = prefix
    );

    -- 새 번호 계산
    IF max_num = 0 THEN
        SET next_num = CAST(CONCAT(prefix, '0001') AS UNSIGNED);
    ELSE
        SET next_num = max_num + 1;
    END IF;

    SET NEW.salenol = next_num;
END $$

DELIMITER ;

insert into member( custname , phone , address, grade , city ) values
('김행복', '010-1111-2222', '서울 동대문구 휘경1동', 'A', '01'),
('이축복', '010-1111-3333', '서울 동대문구 휘경2동', 'B', '01'),
('장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', 'B', '30'),
('최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', 'A', '30'),
('진평화', '010-1111-6666', '제주도 제주시 외나무골', 'B', '60'),
('자공단', '010-1111-7777', '제주도 제주시 감나무골', 'C', '60');


INSERT INTO money ( custno , pcost, amount, price, pcode) VALUES 
(100001, 500, 5, 2500, 'A001'),
(100001, 1000, 4, 4000, 'A002'),
(100001, 500, 3, 1500, 'A008'),
(100002, 500, 1, 500, 'A001'),
(100003, 1500, 2, 3000, 'A003'),
(100004, 500, 2, 1000, 'A001'),
(100004, 300, 1, 300, 'A005'),
(100004, 600, 1, 600, 'A006'),
(100004, 3000, 1, 3000, 'A007'); 
select * from member;
select * from money;