create table sale(
			id int primary key auto_increment,
			name varchar(20),
			qty int
			);
			
			insert into sale values(null,'С���ֻ�',100);
			insert into sale values(null,'С���ֻ�',90);
			insert into sale values(null,'С�׵���',99);
			insert into sale values(null,'С�׺���',102);
			insert into sale values(null,'С�׾�����',80);
			
select * from sale;

select * from sale order by qty desc limit 3;



--��������
--�γ̱�
create table course(
				id int primary key auto_increment,
				name varchar(20)
			);

			insert into course values(null,'java');
			insert into course values(null,'web');
select * from course;
--�γ����ݱ�
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





































