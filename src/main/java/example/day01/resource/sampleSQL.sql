drop database if exists exam10;
create database exam10;
use exam10;
create table board(
	bno int auto_increment ,
    bcontent longtext not null ,
    bwriter varchar(30) not null ,
    constraint primary key ( bno )
);

# 샘플
insert into board( bcontent , bwriter ) values( '안녕하세요' , '유재석' );
INSERT INTO board (bcontent, bwriter) VALUES ('안녕하세요', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('좋은 하루 되세요!', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('반갑습니다', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘 날씨 참 좋네요.', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('게시판 첫 글입니다.', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('점심 뭐 드셨어요?', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('즐거운 하루!', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('행복한 하루 보내세요.', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('게시글 테스트입니다.', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('다들 힘내세요~', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('SQL 연습 중입니다.', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('무한도전 최고!', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('오랜만이에요!', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('비 오네요~', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('날씨가 흐려요.', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('주말 잘 보내세요!', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘도 화이팅!', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('아침 인사드립니다.', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('글 남깁니다~', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('좋은 정보 감사합니다.', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('커피 한 잔의 여유', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('다들 건강하세요.', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘은 뭘 할까요?', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('즐거운 하루 되세요.', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('이 게시판 참 좋네요.', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('피곤하지만 힘내요!', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('일상이 소중해요.', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('주말이 기다려져요.', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('다들 잘 지내시죠?', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('좋은 아침입니다!', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('간단히 인사드려요.', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('행복하세요!', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('밥 먹었어요?', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('테스트용 글입니다.', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('반가워요~', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('이런 날엔 산책이 최고죠.', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('열심히 삽시다!', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('비가 와서 기분이 꿀꿀해요.', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('햇살이 따뜻해요.', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('퇴근하고 싶어요ㅠㅠ', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('점심 추천 좀요!', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('무더운 여름이네요.', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('시원한 커피가 땡겨요.', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('여행 가고 싶어요.', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('일이 너무 많아요ㅠ', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('모두 좋은 하루~', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('방가방가~', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('잘 지내시나요?', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('힘든 하루지만 웃어요!', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('퇴근길이에요~', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('여러분 덕분에 힘나요.', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('커뮤니티 최고~', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('피드백 환영해요!', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('소통 좋아요.', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('고맙습니다~', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('즐거운 주말 되세요!', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('좋은 정보 나눌게요.', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('새로운 시작!', '박명수');

select * from board;