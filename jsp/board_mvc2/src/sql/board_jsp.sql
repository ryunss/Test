use gb;

create table t_user(
	userid varchar(300) primary key,
    userpw varchar(300) not null,
    username varchar(300) not null,
    usergender enum('M','W'),
    zipcode varchar(300) not null,
    addr varchar(1000),
    addrdetail varchar(1000) not null,
    addretc varchar(300),
    userhobby varchar(2000)
);

create table t_board(
	boardnum bigint primary key auto_increment,
    boardtitle varchar(300) not null,
    boardcontents text not null,
    regdate datetime default now(),
    updatedate datetime default now(),
    readcount int default 0,
    userid varchar(300)
);

insert into t_board (boardtitle, boardcontents, userid) values('테스트제목1','테스트내용1','asdf');
insert into t_board (boardtitle, boardcontents, userid) values('테스트제목2','테스트내용2','banana');
insert into t_board (boardtitle, boardcontents, userid) values('테스트제목3','테스트내용3','cherry');

## 서브쿼리 사용
insert into t_board (boardtitle, boardcontents, userid) 
	(select boardtitle, boardcontents, userid from t_board);

select * from t_board;
select * from t_user;