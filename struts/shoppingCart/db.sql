create table computer(
			id int(4) primary key auto_increment,
			model varchar(20),
			pic varchar(20),
			proDesc text,
			price double
		);
		
		insert into computer values(null,'x200','x200.jpg','价格便宜',2000);
		insert into computer values(null,'x500','x500.jpg','性价比不错',5000);
		insert into computer values(null,'x600','x600.jpg','适合玩游戏',6000);
select * from computer;