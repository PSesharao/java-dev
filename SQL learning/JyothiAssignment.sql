show databases;
use sesharao;
show tables;
create table employee
(
Id int primary key not null, 
name varchar(10) not null,
age int not null,
salary int not null
);

insert into employee (Id,name,age,salary)
values (1,'sesharao',22,20000);

insert into employee (Id,name,age,salary)
values (2,'srinvasrao',25,30000);

insert into employee (Id,name,age,salary)
values (3,'hemanthrao',13,23000);

insert into employee (Id,name,age,salary)
values (4,'paneeshrao',10,20500);

insert into employee (Id,name,age,salary)
values (5,'gauthamrao',30,30000);

select * from
employee;

delete from employee
where age < 15;

update employee
set salary = salary + salary * 0.1
where id = 1;

create table employee1
(
Id int primary key not null, 
name varchar(10) not null,
age int not null,
salary int not null,
deptname varchar(10) not null
);


create table department
(
id int primary key not null,
deptname varchar(10) not null unique
);

select * from
employee1;

select * from
department;

alter table employee1 add foreign key (deptname)references department(deptname);

insert into department (id ,deptname )
values (101  , 'cse');

insert into department (id ,deptname )

values (102  , 'it');

insert into department (id ,deptname )
values (103  , 'ece');


insert into employee1 (Id,name,age,salary,deptname)
values (1,'sesharao',22,20000,'cse');

insert into employee1 (Id,name,age,salary,deptname)
values (2,'srinvasrao',25,25000,'it');

insert into employee1 (Id,name,age,salary,deptname)
values (3,'hemanth',27,20400,'cse');

insert into employee1 (Id,name,age,salary,deptname)
values (4,'naresh',26,28000,'ece');

select department.id , department.deptname
from  employee1 inner join department on(employee1.deptname = department.deptname)
where employee1.id = 1;

update employee1 
set salary = salary + salary * 0.1
where employee1.deptname = 'cse' ;

delete from employee1 
where employee1.deptname = 
(select department.deptname
from department
where department.id = 101) ;


