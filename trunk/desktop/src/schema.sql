drop table order_type;

create table order_type (
id integer not null primary key,
text varchar(30) not null
);

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

drop table trade_order;

create table trade_order (
    id integer not null primary key,
    name varchar(50),
    order_type integer not null references order_type(id),
    stock varchar(10) references stock(symbol),
    quantity integer,
    price double,
    order_time timestamp,
    remark varchar(100));