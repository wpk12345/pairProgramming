create schema if not exists person;
use person;

create table if not exists person (
id int (11) not null auto_increment primary key,
name varchar(25) not null,
age int (3) not null
);