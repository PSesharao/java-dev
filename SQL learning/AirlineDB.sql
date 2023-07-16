create database AirlineDB;
use AirlineDB;

create table Flight
(
id varchar(10) primary key ,
name varchar(30) not null ,
source varchar(20) not null ,
destination varchar(20) not null
);

create table Passenger
(
id varchar(10) primary key ,
name varchar(20) not null ,
age int not null,
gender varchar(20) not null
);

create table FlightPassenger
(
flightId varchar(10) not null ,
passengerId varchar(10) not null ,
foreign key (flightId) references Flight(id),
foreign key (passengerId ) references Passenger(id)
);

drop table Flight;

drop table Passenger;

drop table FlightPassenger;

select * from Flight;

delete from Flight;

select * from Passenger;

select * from FlightPassenger;

delete from Passenger;

delete from FlightPassenger;


