SHOW DATABASES;
CREATE DATABASE netctoss;
USE netctoss;
DROP TABLE IF EXISTS account;
CREATE TABLE account (
	id INT(9) PRIMARY KEY AUTO_INCREMENT,
	recommender_id INT(9) REFERENCES account(id),
	login_name VARCHAR(30) NOT NULL UNIQUE,
	login_pwd VARCHAR(8) NOT NULL,
	status CHAR(1) NOT NULL,
	create_date DATETIME,
	pause_date DATETIME,
	close_date DATETIME,
	real_name VARCHAR(20) NOT NULL,
	idcard_no CHAR(18) NOT NULL UNIQUE,
	birthdate DATETIME,
	gender CHAR(1),
	occupation VARCHAR(50),
	telephone VARCHAR(15) NOT NULL,
	email VARCHAR(50),
	address VARCHAR(50),
	zipcode CHAR(6),
	qq VARCHAR(15),
	last_login_time DATETIME,
	last_login_ip VARCHAR(15)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1005,null,'zhangsanfeng','256528',1,'2008-03-15','������','19430225','410381194302256528',13669351234);

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1010,null,'guojing','190613',1,'2009-01-10','����','19690319','330682196903190613',13338924567);

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1011,1010,'huangrong','270429',1,'2009-03-01','����','19710827','330902197108270429',13637811357);

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1015,1005,'zhangwuji','041115',1,'2010-03-12','���޼�','19890604','610121198906041115',13572952468);

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1018,1011,'guofurong','010322',1,'2011-01-01','��ܽ��','19960101','350581200201010322',18617832562);

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1019,1011,'luwushuang','310346',1,'2012-02-01','½��˫','19930731','320211199307310346',13186454984);

insert into account(id,recommender_id,login_name,login_pwd,status,create_date,real_name,birthdate,idcard_no,telephone)
values(1020,null,'weixiaobao','012115',1,'2012-02-20','ΤС��','20001001','321022200010012115',13953410078);

DROP TABLE IF EXISTS cost;
CREATE TABLE cost(
	id int(4) primary key auto_increment,
	name varchar(50) not null,
	base_duration int(11),
	base_cost double(7,2),
	unit_cost double(7,4),
	status char(1),
	description varchar(100),
	createtime datetime,
	starttime datetime,
	costtype char(1) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

desc cost;

insert into cost values (null,'5.9Ԫ�ײ�',20,5.9,0.4,1,'5.9Ԫ20Сʱ/��,��������0.4Ԫ/ʱ',now(),null,'2');
insert into cost values (null,'6.9Ԫ�ײ�',40,6.9,0.3,1,'6.9Ԫ40Сʱ/��,��������0.3Ԫ/ʱ',now(),null,'2');
insert into cost values (null,'8.5Ԫ�ײ�',100,8.5,0.2,0,'8.5Ԫ100Сʱ/��,��������0.2Ԫ/ʱ',now(),now(),'2');
insert into cost values (null,'10.5Ԫ�ײ�',200,10.5,0.1,0,'10.5Ԫ200Сʱ/��,��������0.1Ԫ/ʱ',now(),now(),'2');
insert into cost values (null,'��ʱ�շ�',null,null,0.5,1,'0.5Ԫ/ʱ,��ʹ�ò��շ�',now(),null,'3');
insert into cost values (null,'����',null,20,null,0,'ÿ��20Ԫ,������ʹ��ʱ��',now(),now(),'1');

select * from cost;

create table host(
	id varchar(15) primary key,
	name varchar(20),
	location varchar(30)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into host values ('192.168.0.26','˼��','����');
insert into host values('192.168.0.20','��Ϊ','�Ͼ�');
insert into host values ('192.168.0.23','����','�Ϻ�');
insert into host values ('192.168.0.200','΢��','����');

select * from host;

create table service(
	id int(10) primary key auto_increment,
	account_id int(9) not null,
	unix_host varchar(15) not null,
	os_username varchar(18) not null,
	login_pwd varchar(18) not null,
	status char(1),
	create_date datetime,
	pause_date datetime,
	close_date datetime,
	cost_id int(4) not null,
	constraint fk_serv_acc_id foreign key(account_id) references netctoss.account(id),
	constraint fk_serv_host_uhost foreign key(unix_host) references netctoss.host(id),
	constraint fk_serv_cost_id foreign key(cost_id) references netctoss.cost(id),
	unique(unix_host,os_username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into service values (2001,1010,'192.168.0.26','����','guojing',1,'2009-03-10 10:00:00',null,null,3);
insert into service values (2002,1011,'192.168.0.26','����','huangrong',1,'2009-03-01 15:30:05',null,null,3);
insert into service values (2003,1011,'192.168.0.20','����','huangrong',1,'2009-03-01 15:30:10',null,null,3);
insert into service values (2004,1011,'192.168.0.23','����','huangrong',1,'2009-03-01 15:30:15',null,null,6);
insert into service values (2005,1019,'192.168.0.26','½��˫','luwushuang',2,'2012-02-10 23:50:55',null,null,4);
insert into service values (2006,1019,'192.168.0.20','½��˫','luwushuang',2,'2012-02-10 00:00:00',null,null,4);
insert into service values (2007,1020,'192.168.0.20','ΤС��','weixiaobao',2,'2012-02-10 11:05:20',null,null,6);
insert into service values (2008,1010,'192.168.0.20','����','guojing',3,'2012-02-11 12:05:21',null,null,6);
insert into service values (2009,1010,'192.168.0.23','����','guojing',3,'2012-02-11 12:05:21',null,null,6);
-----------------------------------------------------------------------------------------------------------------------------------------------
create table user(
	id int(11) primary key auto_increment,
	username varchar(30) unique not null,
	password varchar(30) not null,
	name varchar(30) not null,
	telephone varchar(30),
	email varchar(50),
	registerdate datetime not null
);

insert into user values(1001,'admin','123456','������','15966668888','zhangsanfeng@163.com',now());

create table role(
	id int(9) primary key auto_increment,
	name varchar(20)
);

insert into role (id,name) values (1, '��������Ա');
insert into role (id,name) values (2, '�ʷ��˺Ź���Ա');
insert into role (id,name) values (3, '�����˺Ź���Ա');
insert into role (id,name) values (4, 'ҵ���˺Ź���Ա');
insert into role (id,name) values (5, '��ɫ����Ա');
insert into role (id,name) values (6, '�˵�����Ա');
insert into role (id,name) values (7, '�������Ա');

create table user_role(
	user_id int(11) not null,
	role_id int(9) not null,
	constraint ar_pk primary key(user_id,role_id)
);

insert into user_role(user_id,role_id) values(1001,1);
insert into user_role(user_id,role_id) values(1001,2);
insert into user_role(user_id,role_id) values(1001,3);
insert into user_role(user_id,role_id) values(1001,4);
insert into user_role(user_id,role_id) values(1001,5);
insert into user_role(user_id,role_id) values(1001,6);
insert into user_role(user_id,role_id) values(1001,7);

create table privilege(
	id int(9) primary key auto_increment,
	name varchar(20)
);
insert into privilege value(1,"��ɫ����ģ��");
insert into privilege value(2,"����Աģ��");
insert into privilege value(3,"�ʷѹ���ģ��");
insert into privilege value(4,"�����˺�ģ��");
insert into privilege value(5,"ҵ���˺�ģ��");
insert into privilege value(6,"�˵�����ģ��");
insert into privilege value(7,"����ģ��");

create table role_privilege(
	role_id int(9) not null,
	privilege_id int(9) not null,
	constraint rp_pk primary key(role_id,privilege_id)
);

insert into role_privilege (role_id, privilege_id) values (1, 1);
insert into role_privilege (role_id, privilege_id) values (1, 2);
insert into role_privilege (role_id, privilege_id) values (1, 3);
insert into role_privilege (role_id, privilege_id) values (1, 4);
insert into role_privilege (role_id, privilege_id) values (1, 5);
insert into role_privilege (role_id, privilege_id) values (1, 6);
insert into role_privilege (role_id, privilege_id) values (1, 7);
insert into role_privilege (role_id, privilege_id) values (2, 3);
insert into role_privilege (role_id, privilege_id) values (3, 4);
insert into role_privilege (role_id, privilege_id) values (4, 5);
insert into role_privilege (role_id, privilege_id) values (5, 1);
insert into role_privilege (role_id, privilege_id) values (6, 6);
insert into role_privilege (role_id, privilege_id) values (7, 7);

-----------------------------------------------------------------------------------------------------------------------------------------------
create table month_duration (
	service_id int(10),
	month_id char(6),
	service_detail_id int(11),
	sofar_duration int(11)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table bill (
	id int(11) primary key auto_increment,
	account_id int(9) not null,
	bill_month char(6) not null,
	cost double(13,2) not null,
	payment_mode char(1),
	pay_state char(1) default '0',
	constraint fk_bill_acc_id foreign key(account_id) references netctoss.account(id)
);

create table bill_item (
	item_id int(11) primary key,
	bill_id int(11) not null,
	service_id not null,
	cost double(13,2),
	constraint fk_billitem_bill_id foreign key(bill_id) references netctoss.bill(id),
	constraint fk_billitem_service_id foreign key(service_id) references netctoss.service(id)
);

create table service_detail (
	id int(11) primary key auto_increment,
	service_id int(10) not null,
	client_host varchar(15),
	os_username varchar(8),
	pid int(11),
	login_time datetime,
	logout_time datetime,
	duration double(20,9),
	cost double(20,6),
	constraint fk_servicedetail_service_id foreign key(service_id) references netctoss.service(id)
);
-----------------------------------------------------------------------------------------------------------------------------------------------
