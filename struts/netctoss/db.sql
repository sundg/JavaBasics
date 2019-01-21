create table cost(
	id int(4) primary key auto_increment,
	name varchar(50) not null,
	base_duration int(11),
	base_cost double(7,2),
	unit_cost double(7,4),
	status char(1),
	description varchar(100),
	createtime datetime,
	startetime datetime,
	costtype char(1) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

desc cost;

insert into cost values (null,'5.9元套餐',20,5.9,0.4,1,'5.9元20小时/月,超出部分0.4元/时',now(),null,'1');
insert into cost values (null,'6.9元套餐',40,6.9,0.3,1,'6.9元40小时/月,超出部分0.3元/时',now(),null,'2');
insert into cost values (null,'8.5元套餐',100,8.5,0.2,1,'8.5元100小时/月,超出部分0.2元/时',now(),null,'3');
insert into cost values (null,'10.5元套餐',200,10.5,0.1,1,'10.5元200小时/月,超出部分0.1元/时',now(),null,'3');
insert into cost values (null,'计时收费',null,null,0.5,1,'0.5元/时,不使用不收费',now(),null,'1');
insert into cost values (null,'包月',null,20,null,1,'每月20元,不限制使用时间',now(),null,'2');

select * from cost;

select count(*) from cost;



create table admin_msg(
	id int(11) primary key auto_increment,
	admin_code varchar(30) unique not null,
	password varchar(30) not null,
	name varchar(30) not null,
	telephone varchar(30),
	email varchar(50),
	registerdate datetime not null
);

insert into admin_msg values(1001,'admin','123456','张三丰','15966668888','zhangsanfeng@163.com',now());
insert into admin_msg values(1002,'zhangsan','111111','张三','13688997766','zhangsan@sin.com',now());

select * from admin_msg;






















