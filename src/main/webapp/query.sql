/* 계정 */ 
create user admin identified by 1234;
grant resource, dba, connect to admin;
commit;

/* 시퀀스 생성 & 리셋 */ 
create sequence it_seq 
start with 1
increment by 1
nomaxvalue
nocycle
nocache;

create sequence ps_seq 
start with 1
increment by 1
nomaxvalue
nocycle
nocache;

drop sequence it_seq;
drop sequence ps_seq;

/* DB */ 
create table itDB(
	idx number(2),
	answer varchar2(200)
);

create table psDB(
	idx number(2),
	answer varchar2(200)
);

/* DB 데이터 추가 */
insert into itDB values (default, "~~");
insert into psDB values (default, "~~");

/* DB 초기화 */
delete from itDB, psDB;

