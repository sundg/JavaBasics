create table computer(
			id int(4) primary key auto_increment,
			model varchar(20),
			pic varchar(20),
			proDesc text,
			price double
		);
		
		insert into computer values(null,'x200','x200.jpg','�۸����',2000);
		insert into computer values(null,'x500','x500.jpg','�Լ۱Ȳ���',5000);
		insert into computer values(null,'x600','x600.jpg','�ʺ�����Ϸ',6000);
select * from computer;