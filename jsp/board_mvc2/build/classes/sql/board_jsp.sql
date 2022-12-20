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