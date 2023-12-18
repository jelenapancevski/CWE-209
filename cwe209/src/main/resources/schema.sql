drop table if exists users;

create table users
(
    id       int          NOT NULL AUTO_INCREMENT,
    username varchar(255) not null,
    password varchar(255) not null,
    usertype    varchar(255) not null,
    PRIMARY KEY (ID)
);
