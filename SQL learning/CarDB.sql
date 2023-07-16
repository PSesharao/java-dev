create database CarDB;
use CarDB;

create table car
(
id int primary key ,
name varchar(20) not null ,
price double not null,
color varchar(10) not null
);

select * from car;

DELIMITER #

CREATE PROCEDURE GetAllcarsByPriceAndColor(price1 double ,price2 double , color varchar(10))
BEGIN
	select * from car where car.price >=price1 and car.price <= (price2) and car.color = (color);
END #

DELIMITER ;


CALL GetAllcarsByPriceAndColor();



DELIMITER #

CREATE PROCEDURE GetAllcars()
BEGIN
	select * from car;
END #

DELIMITER ;

CALL GetAllcars() ;

show databases;