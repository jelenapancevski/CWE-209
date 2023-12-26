drop table if exists users;
drop table if exists products;
drop table if exists promocodes;
drop table if exists promotions;

create table users
(
    id       int          NOT NULL AUTO_INCREMENT,
    username varchar(255) not null,
    password varchar(255) not null,
    usertype    varchar(255) not null,
    firstname    varchar(255) not null,
    lastname    varchar(255) not null,
    address    varchar(255) not null,
     bankAccount    varchar(255),
    PRIMARY KEY (ID)
);

create table products
(
    id int NOT NULL AUTO_INCREMENT,
    ingredients VARCHAR(255) ARRAY,
    name varchar(255) not null,
    description    varchar(500) not null,
    producttype varchar(255) not null,
    price int not null,
    image varchar(255) not null,
    secret varchar (255) not null,
    stock int not null,
    PRIMARY KEY (ID)

);

create table promocodes
(
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) not NULL,
    discount int not NULL
);

create table promotions
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) not NULL,
    description varchar(1000) not NULL,
    image varchar(255) not NULL
);

create table questions
(
    id int NOT NULL AUTO_INCREMENT,
    email varchar(255) not NULL,
    question varchar(1000) not NULL,
);