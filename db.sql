drop database tedu;
create database tedu default character set utf8;
use tedu;
create table emp(
	id int primary key auto_increment,
	name varchar(50),
	salary double,
	age int
);
insert into emp values(1,'张三',3000,25);
insert into emp values(2,'李四',4000,30);
insert into emp(name,salary,age) values('王五',2500,20);
insert into emp(name,salary,age) values('小红',5000,35);
select * from emp;