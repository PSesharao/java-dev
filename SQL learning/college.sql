create database collegeDB;
use collegeDB;

create table student
(
id varchar(10) primary key,
name varchar(20) not null ,
year int not null
);

create table course
(
title varchar(20) primary key ,
type varchar(10) not null,
fee int not null
);

create table grades
(
stud_id varchar(10) not null ,
course_title varchar(20) not null,
grade char not null,
foreign key (stud_id) references student(id),
foreign key (course_title) references course(title)
);

create table teacher
(
id varchar(10)  primary key ,
name varchar(20) not null 
);

create table teaches
(
course_title varchar(20) not null,
teacher_Id varchar(10) not null,
foreign key (course_title) references course(title),
foreign key (teacher_Id) references teacher(id)
);

insert into student (id,name,year)
values('stud1','Ajay',1);

insert into student (id,name,year)
values('stud2','Babu',3);

insert into student (id,name,year)
values('stud3','Christine',4);

insert into student (id,name,year)
values('stud4','Alice',2);

insert into student (id,name,year)
values('stud5','Alex',4);

insert into course (title,type,fee)
values ('Computer Science','Practical',50000);

insert into course (title,type,fee)
values ('Maths','Theory',20000);

insert into course (title,type,fee)
values ('Physics','Theory',15000);

insert into course (title,type,fee)
values ('Chemistry','Practical',22000);

insert into course (title,type,fee)
values ('Music','Practical',21000);

insert into course (title,type,fee)
values ('Biology','Theory',18000);

insert into course (title,type,fee)
values ('Economy','Theory',19000);

insert into course (title,type,fee)
values ('OOPs','Theory',15000);


insert into grades (stud_id,course_title,grade)
values ('stud1','Computer Science','A');

insert into grades (stud_id,course_title,grade)
values ('stud1','Maths','B');

insert into grades (stud_id,course_title,grade)
values ('stud1','Physics','C');

insert into grades (stud_id,course_title,grade)
values ('stud2','Physics','B');

insert into grades (stud_id,course_title,grade)
values ('stud2','Chemistry','C');

insert into grades (stud_id,course_title,grade)
values ('stud3','Music','C');

insert into grades (stud_id,course_title,grade)
values ('stud4','Biology','A');

insert into grades (stud_id,course_title,grade)
values ('stud4','Economy','B');

insert into grades (stud_id,course_title,grade)
values ('stud5','Maths','C');

insert into grades (stud_id,course_title,grade)
values ('stud5','OOPs','D');

insert into teacher (id,name) 
values (101,'Mrs.Priya');

insert into teacher (id,name) 
values (102,'Mr.Ravi');

insert into teacher (id,name) 
values (103,'Mr.Ganesh');

insert into teacher (id,name) 
values (104,'Mrs.Kirthika');

insert into teacher (id,name) 
values (105,'Mr.Aditya');

insert into teacher (id,name) 
values (106,'Mr.Aashika');

insert into teacher (id,name) 
values (107,'Mr.Mohan');

select * from teacher;


insert into teaches (course_title,teacher_Id)
values ('Computer Science',101);

insert into teaches (course_title,teacher_Id)
values ('Maths',102);

insert into teaches (course_title,teacher_Id)
values ('Physics',103);

insert into teaches (course_title,teacher_Id)
values ('Chemistry',104);

insert into teaches (course_title,teacher_Id)
values ('Music',105);

insert into teaches (course_title,teacher_Id)
values ('Biology',106);

insert into teaches (course_title,teacher_Id)
values ('Economy',107);

insert into teaches (course_title,teacher_Id)
values ('OOPs',101);

-- get courses taken by a student

select grades.course_title 
from student inner join grades on (student.id = grades.stud_id ) 
where student.id = 'stud1';

-- get students taking particular course

select student.name
from student inner join grades on (student.id = grades.stud_id ) 
where grades.course_title= 'Physics';

-- get courses taught by a teacher 

select teaches.course_title 
from teaches inner join teacher on (teaches.teacher_Id = teacher.id)
where teacher.id = '101';

-- get teachers for a particular student 

select teacher.name 
from student inner join grades on (student.id = grades.stud_id ) 
inner join teaches on (grades.course_title = teaches.course_title )
inner join teacher on (teaches.teacher_Id = teacher.id) 
where student.id = 'stud1';
