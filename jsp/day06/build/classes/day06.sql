use gb;
create table test_board(
	boardnum int primary key auto_increment,
    boardtitle varchar(1000) not null,
    boardcontents varchar(4000) not null,
    regdate datetime default now(),
    userid varchar(300)
);

insert into test_board (boardtitle, boardcontents, userid)
values('더미 데이터','더미 데이터 입니다','apple');

select * from test_board;