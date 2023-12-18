drop table if exists users;
drop table if exists products;
create table users
(
    id       int          NOT NULL AUTO_INCREMENT,
    username varchar(255) not null,
    password varchar(255) not null,
    usertype    varchar(255) not null,
    PRIMARY KEY (ID)
);

create table products
(
    id       int          NOT NULL AUTO_INCREMENT,
    ingredients VARCHAR(255) ARRAY,
    name varchar(255) not null,
    description    varchar(500) not null,
    producttype varchar(255) not null,
    price int not null,
    image varchar(255) not null,
    PRIMARY KEY (ID)

);