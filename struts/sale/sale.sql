create table sale(
			id int primary key auto_increment,
			name varchar(20),
			qty int
			);
			
			insert into sale values(null,'小米手机',100);
			insert into sale values(null,'小米手环',90);
			insert into sale values(null,'小米电视',99);
			insert into sale values(null,'小米盒子',102);
			insert into sale values(null,'小米净化器',80);
			
select * from sale;

select * from sale order by qty desc limit 3;



--二级联动
--课程表
create table course(
				id int primary key auto_increment,
				name varchar(20)
			);

			insert into course values(null,'java');
			insert into course values(null,'web');
select * from course;
--课程内容表
create table lore(
				id int primary key auto_increment,
				name varchar(20),
				course_id int
			);
			
			insert into lore values(null,'oop',1);
			insert into lore values(null,'ajax',1);
			
			insert into lore values(null,'spring',1);
			insert into lore values(null,'nodejs',2);
			insert into lore values(null,'bootstrap',2);





































