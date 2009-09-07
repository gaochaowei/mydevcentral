drop table account;

create table account (
    id integer not null primary key,
    name varchar(30) not null,
    balance double default 0);

drop table portfolio;

create table portfolio (
    id integer not null primary key,
    name varchar(30) not null,
    remark varchar(100));

drop table stock_order;

create table stock_order (
    id integer not null primary key,
    name varchar(50),
    Order_type integer not null,
    stock_symbol varchar(10),
    quantity integer,
    price double,
    order_time timestamp,
    remark varchar(100));
