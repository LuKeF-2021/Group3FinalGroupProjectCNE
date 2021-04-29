drop database if exists Tickets;
create database Tickets;
use Tickets;
create table ticket (id bigint not null, complete boolean, created_at timestamp, description varchar(255), name varchar(255), title varchar(255), primary key (id));
insert into ticket (id, complete, created_at, description, name, title) values (1, false, "2010-02-11 11:30:00",  "Description of ticket", "Name Naming", "Title of ticket");
