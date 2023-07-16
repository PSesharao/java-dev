create database HotelDB;
use HotelDB;
show tables ;
create table hotel
(
	id varchar(10) primary key ,
    name varchar(20) not null ,
    location varchar(20) not null 
);


create table room
(
     id varchar(10) primary key ,
     type varchar(20) not null ,
     price int not null ,
     hotel_id  varchar(10) not null ,
     foreign key (hotel_id) references hotel(id)
);

select * from hotel;

select * from room;

drop table hotel ;

drop table room;

DELIMITER #
CREATE PROCEDURE inserttoHotel(id varchar(10) , name varchar(20) , location varchar(20) )
begin
	insert into hotel (id ,name , location) 
    values  (id ,name , location) ;
END #

DELIMITER ;

DELIMITER #
CREATE PROCEDURE inserttoRoom(id varchar(10) , type varchar(20) ,price int , hotel_id  varchar(10))
begin
	insert into room (id , type ,price ,hotel_id )
    values(id , type ,price ,hotel_id );
end#

DELIMITER ;


DELIMITER #
CREATE PROCEDURE getHotelsFromCity(location varchar(20))
begin 
	select hotel.id , hotel.name , hotel.location 
    from hotel 
    where hotel.location = location;
end#
DELIMITER ;

call getHotelsFromCity();

DELIMITER #
CREATE PROCEDURE getRoomFromHotel(hotel_id  varchar(10))
begin 
    select id , type , price 
    from room 
    where hotel_id = hotel_id;
end#
DELIMITER ;

call getRoomFromHotel('hotel1');


CREATE TABLE Students(
Student_ID int AUTO_INCREMENT PRIMARY KEY, 
First_Name varchar(25),
Last_Name varchar(25)
); 


INSERT INTO Students(First_Name, Last_Name ) 
VALUES ('Deeksha', 'Jain');

DELIMITER #
create procedure populateStudent(firstname varchar(20) ,  lastname varchar(20) )
begin 
		INSERT INTO Students(First_Name, Last_Name )  values (firstname , lastname );
end#
DELIMITER ;

call populateStudent('sesharao' , 'paritala');


DELIMITER #
create procedure studentInfo( )
begin 
		select  Student_ID ,fullName(First_Name , Last_Name ) as fullname from Students;
end#
DELIMITER ;

call studentInfo();

DELIMITER $$
CREATE FUNCTION fullName (firstName VARCHAR(20) , lastname varchar(20) )
  RETURNS VARCHAR(40)
	deterministic
    BEGIN 
       RETURN (SELECT  CONCAT(firstName , ' ' , lastName)  ) ;
END$$
DELIMITER ;

select fullName( 'sesharao' , 'paritala' ) as fullname;


