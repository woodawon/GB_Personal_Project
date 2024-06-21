/* 계정 */ 
create user admin identified by 1234;
grant resource, dba, connect to admin;
commit;

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
insert into itDB values (idx, answer);
insert into psDB values (idx, answer);

/* DB 초기화 */
delete from itDB, psDB;
