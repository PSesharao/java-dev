create database hospitaldb;
use hospitaldb;

create table symptom
( 
id varchar(10) primary key,
name varchar(20) not null
);
create table patient
(
id varchar(10) primary key,
name varchar(20) not null ,

);