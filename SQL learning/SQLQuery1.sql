CREATE DATABASE MT;
USE MT;

CREATE TABLE EMP_SUP(
PERSON VARCHAR(10),
SUPERVISOR VARCHAR(10)
);

SELECT * 
FROM EMP_SUP;

INSERT INTO EMP_SUP (PERSON,SUPERVISOR) VALUES ('BOB','ALICE');

INSERT INTO EMP_SUP (PERSON,SUPERVISOR) VALUES ('MARY','SUSAN');

INSERT INTO EMP_SUP (PERSON,SUPERVISOR) VALUES ('ALICE','DAVID');

INSERT INTO EMP_SUP (PERSON,SUPERVISOR) VALUES ('DAVID','MARY');

--to find the supervisor of BOB
SELECT SUPERVISOR
FROM EMP_SUP
WHERE PERSON='bob';

--to find the supervisor of supervisor of BOB
SELECT S.SUPERVISOR 
FROM EMP_SUP F , EMP_SUP S
WHERE F.PERSON = 'BOB' AND F.SUPERVISOR = S.PERSON ;

--to find all direct or indirect supervisors of BOB
SELECT DISTINCT E2.SUPERVISOR
FROM EMP_SUP E1,EMP_SUP E2
WHERE (E1.SUPERVISOR = E2.PERSON OR E1.PERSON = E2.SUPERVISOR);


CREATE TABLE COURSE
(
COURSE_ID VARCHAR(10),
TITLE VARCHAR(10),
DEPT_NAME VARCHAR(10),
CREDITS INT
);

INSERT INTO COURSE(COURSE_ID,TITLE,DEPT_NAME,CREDITS) 
VALUES ('BIO-301','GENETICS','BIOLOGY',4);

INSERT INTO COURSE(COURSE_ID,TITLE,DEPT_NAME,CREDITS) 
VALUES ('CS-190','GAMEDESIGN','CSE',4);

INSERT INTO COURSE(COURSE_ID,TITLE,DEPT_NAME,CREDITS) 
VALUES ('CS-315','ROBOTICS','CSE',3);

SELECT *
FROM COURSE;

CREATE TABLE PREREQ
(
COURSE_ID VARCHAR(10),
PREREQ_ID VARCHAR(10),
);

INSERT INTO PREREQ VALUES ('BIO-301','BIO-101');

INSERT INTO PREREQ VALUES ('CS-190','CS-101');

INSERT INTO PREREQ VALUES ('CS-347','CS-101');


SELECT *
FROM PREREQ;

--inner join

SELECT *
FROM COURSE INNER JOIN PREREQ
ON COURSE.COURSE_ID = PREREQ.COURSE_ID;

SELECT *
FROM COURSE , PREREQ 
WHERE COURSE.COURSE_ID = PREREQ.COURSE_ID;

--left outer join

SELECT *
FROM COURSE LEFT OUTER JOIN PREREQ
ON COURSE.COURSE_ID = PREREQ.COURSE_ID;


--right outer join

SELECT *
FROM COURSE RIGHT OUTER JOIN PREREQ
ON COURSE.COURSE_ID = PREREQ.COURSE_ID;

--full outer join

SELECT *
FROM COURSE FULL OUTER JOIN PREREQ
ON COURSE.COURSE_ID = PREREQ.COURSE_ID;

