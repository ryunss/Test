use gb;

create table spring_user(
	userid varchar(300) primary key,
    userpw varchar(300) not null,
    username varchar(300) not null
);

create table spring_board(
	boardnum bigint primary key auto_increment,
    boardtitle varchar(300) not null,
    boardcontents text not null,
    regdate datetime default now(),
    updatedate datetime default now(),
    userid varchar(300)
);

create table spring_reply(
	replynum bigint primary key auto_increment,
    replycontents varchar(3000) not null,
	regdate datetime default now(),
    updatedate datetime default now(),
    userid varchar(300),
    boardnum bigint
);