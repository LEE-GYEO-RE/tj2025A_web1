-- ---------------------- web ---------------------------------- --
DROP DATABASE IF EXISTS springweb;
CREATE DATABASE springweb;
USE springweb;

CREATE TABLE member (
    mno     INT AUTO_INCREMENT,                    -- 회원 번호 (기본키)
    mid     VARCHAR(50) NOT NULL UNIQUE,           -- 회원 아이디
    mpwd    VARCHAR(50) NOT NULL,                  -- 비밀번호
    mname   VARCHAR(30) NOT NULL,                  -- 회원 이름
    mphone  VARCHAR(13) NOT NULL,                  -- 회원 연락처
    mdate   DATETIME DEFAULT NOW(),                 -- 가입일
    CONSTRAINT PRIMARY KEY (mno)
);

CREATE TABLE pointlog (
    plno      INT AUTO_INCREMENT,
    mno       INT NOT NULL,
    plpoint   INT NOT NULL,
    plcomment VARCHAR(100) NOT NULL,
    pldate    DATETIME DEFAULT NOW(),
    CONSTRAINT PRIMARY KEY (plno),
    CONSTRAINT FOREIGN KEY (mno) REFERENCES member(mno) ON DELETE CASCADE
);

-- 샘플 데이터 삽입
INSERT INTO member (mid, mpwd, mname, mphone, mdate) VALUES
('qwe123',  'asd1234', '유재석', '010-1234-1234', '2025-08-01 14:10:00'),
('hong123',  'pass1234', '홍길동', '010-1234-5678', '2025-08-01 14:20:00'),
('kimlove',  'qwer5678', '김사랑', '010-9876-5432', '2025-08-02 09:15:00'),
('leepeace', 'abcd1111', '이평화', '010-2222-3333', '2025-08-03 17:45:00'),
('parkjoy',  'pass9999', '박기쁨', '010-5555-6666', '2025-08-04 08:05:00'),
('choifit',  'fit2025',  '최건강', '010-7777-8888', '2025-08-05 19:30:00');

-- ---------------------- 포인트 적립 샘플 ---------------------- --
-- 회원 1이 회원가입 포인트 지급 (+1000)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 1000, '회원가입');
-- 회원 1이 로그인 포인트 지급 (+100) 3회
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 100, '로그인');
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 100, '로그인');
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 100, '로그인');
-- ---------------------- 포인트 충전/차감 샘플 ---------------------- --
-- 회원 1이 포인트 충전 (+5000)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 5000, '포인트충전');
-- 회원 1이 제품 구매로 포인트 차감 (-6000)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, -6000, '상품구매');
-- 회원 1이 이벤트 참여로 포인트 적립 (+500)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 500, '이벤트적립');



select * from member;
select * from pointlog;