create table user(
	id int(4) primary key auto_increment,
	username varchar(20),
	name varchar(20),
	pwd varchar(20),
	sex char(1)
);
--显示当前数据库下的所有表
show tables;

alter table user modify sex varchar(2);

select *from user;

delete from user where id=6;