drop table if exists book;

create table book (
    id int primary key,
    title varchar(50) not null,
    author varchar(50) not null
);
