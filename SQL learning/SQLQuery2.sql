create database SESHARAO;

use SESHARAO;

Create table father(
Father_id varchar(30) primary key not null,
Father_Name varchar(30) not null
);

SELECT * FROM
father;

insert into father values('FT101', 'Will Smith');
insert into father values('FT306', 'Stellan Skarsgard');
insert into father values('FT987', 'Brendan Gleeson');
insert into father values('MT320', 'Quincy Jones');
insert into father values('MT321', 'Barry Jones');
insert into father values('MT322', 'James Jones');

Create table Celebrity(
Celeb_Id int primary key not null,
Father_id varchar(30),
CelebrityFName varchar(30) not null,
CelebrityLName varchar(30) not null,
Gender varchar(30) not null,
City varchar(30) not null,
Salary decimal (10,2) not null,
Phone_No varchar(30) not null,
foreign key (Father_id) references father(Father_id)
);

SELECT * FROM CELEBRITY;

INSERT INTO Celebrity VALUES (1001,'FT101','willow','smith','Male','New York',15000.5,'9876543210');
INSERT INTO Celebrity VALUES (1002,'FT306','Alexander','skarsgard','Male','Bhubaneswar',25000.5,'9871243211');
INSERT INTO Celebrity VALUES (1003,'FT101','Jaden','smith','Female','New York',12000.53,'9876433212');
INSERT INTO Celebrity VALUES (1004,'FT987','Domhnall','Gleeson','Male','Bangalore',18300.85,'9876543213');
INSERT INTO Celebrity (CELEB_ID ,CELEBRITYFNAME ,CELEBRITYLNAME ,GENDER ,CITY ,SALARY ,PHONE_NO ) VALUES (1005,'Lloyd','Bridges','Male','California',17540.65,'9876093214');
INSERT INTO Celebrity VALUES (1006,'MT320','Rashida','Jones','Male','Sydney',20220.65,'9876016548');
INSERT INTO Celebrity VALUES (1007,'MT320','Peggy','Lipton','Female','Sydney',34990.97,'9875846549');
INSERT INTO Celebrity (CELEB_ID ,CELEBRITYFNAME ,CELEBRITYLNAME ,GENDER ,CITY ,SALARY ,PHONE_NO ) VALUES (1008,'Lloyds','Bridg','Male','Lipton',17540.65,'9876093223');

Create table Award(
Award_Id varchar(30) not null,
Celeb_Id int not null,
AwardName varchar(30) not null,
AwardDate Date not null,
foreign key (Celeb_Id) references Celebrity(Celeb_Id)
);

INSERT INTO Award VALUES('OS-2008-01',1001,'Oscar','2008-04-30');
INSERT INTO Award VALUES('FF-2010-06',1002,'FilmFare','2010-04-30');
INSERT INTO Award VALUES('OS-2008-30',1003,'Oscar','2008-06-30');
INSERT INTO Award VALUES('BM-2008-98',1004,'BestMovie','2008-05-23');
INSERT INTO Award VALUES('BM-2009-32',1005,'BestMovie','2009-08-30');
INSERT INTO Award VALUES('FF-2008-06',1006,'FilmFare','2008-04-15');
INSERT INTO Award VALUES('OS-2008-01',1007,'Oscar','2019-04-30');

SELECT * FROM Award;

-- celebrity with no fathers
SELECT COUNT(*) FROM CELEBRITY
WHERE Father_id IS NULL;

-- father name whose child lives in sydney

SELECT DISTINCT father.Father_Name 
FROM Celebrity INNER JOIN father ON father.Father_id = Celebrity.Father_id 
WHERE Celebrity.City = 'Sydney';

--Celebrity details who's salary greater than 10000 order by celebrity name.

SELECT * 
FROM Celebrity
WHERE Salary > 10000 ORDER BY CelebrityFName  ;


--all fathers who's child have won more than one award.

select * from 
Celebrity inner join Award on (Celebrity.Celeb_Id = Award . Celeb_Id);


SELECT DISTINCT father.Father_Name 
FROM Celebrity INNER JOIN father ON father.Father_id = Celebrity.Father_id 
where not unique(select Award.Celeb_Id from Celebrity INNER JOIN Award on Celebrity.Celeb_Id = Award.Celeb_Id );