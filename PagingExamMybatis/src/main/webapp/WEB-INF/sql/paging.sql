drop table item_tb;
create table item_tb(
	num number primary key,
	item varchar2(100) not null
);

drop sequence item_tb_num_seq;
create sequence item_tb_num_seq;

select * from item_tb;
select count(*) from item_tb;

select rn, num, item	-- 최종 조회
	from (
		select rownum rn, num, item		--rownum(1~마지막 item까지 조회)
		from (
			select num, item from item_tb order by num desc
		) 
	where rownum <= 20
	)
where rn >= 11;