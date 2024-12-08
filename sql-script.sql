create database travelmanagementsystem;
show databases;
use travelmanagementsystem;
create table account(username varchar(20), name varchar(20), password varchar(20), security varchar(100), answer varchar(100));
show tables;
select * from account;
create table customer(username varchar(20), id varchar(30), number varchar(30), name varchar(20), gender varchar(20), country varchar(30), address varchar(50), phone varchar(15), email varchar(50))
select * from customer;
create table bookpackage(Username varchar(20),Package varchar(30),Persons Varchar(5),Id varchar(30),Number varchar(30),Phone varchar(20),Price varchar(20), BookingId varchar(5));
select * from bookpackage;
create table hotel(name varchar(30), costperperson varchar(20), acroom varchar(20), foodincluded varchar(10)); 
insert into hotel values('Raddison Blue Hotel', '3400','1000','1700');
insert into hotel values('River View Hotel', '2400','1600','1000');
insert into hotel values('The Taj Hotel', '4800','1290','2900');
create table bookhotel(username varchar(20), name varchar(20), persons varchar(10), days varchar(10), ac varchar(10), food varchar(10), id varchar(20), number varchar(20), phone varchar(20), price varchar(20), bookingId varchar(5));
select * from bookhotel;
create table admin(username varchar(20), password varchar(20));
insert into admin values('Admin','Admin@1234');