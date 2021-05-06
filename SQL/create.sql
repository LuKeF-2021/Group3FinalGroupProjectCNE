-- drop database if exists Tickets;
create database if not exists Tickets;
use Tickets;
create table if not exists ticket (id bigint not null, cohort varchar(255), complete boolean, created_at timestamp, description varchar(255), name varchar(255), solution varchar(255), title varchar(255), urgency varchar(255), primary key (id))
-- insert into ticket (id, complete, created_at, description, name, title) values (1, false, "2010-02-11 11:30:00",  "Description of ticket", "Name Naming", "Title of ticket");
