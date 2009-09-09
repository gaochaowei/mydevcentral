drop table stock_position;
drop table portfolio;
drop table trade_order;
drop table account;
drop table order_type;

create table order_type (
    id integer not null primary key generated always as identity,
    text varchar(30)
);

create table account (
    id integer not null primary key generated always as identity,
    name varchar(30),
    balance double default 0);

create table portfolio (
    id integer not null primary key generated always as identity,
    name varchar(30),
    remark varchar(100));

create table trade_order (
    id integer not null primary key generated always as identity,
    name varchar(50),
    order_type integer references order_type(id),
    stock varchar(10) references stock(symbol),
    quantity integer,
    price double,
    order_time timestamp,
    remark varchar(100));

create table stock_position (
    id integer not null primary key generated always as identity,
    portfolio integer references portfolio(id),
    stock varchar(10) references stock(symbol),
    quantity integer,
    price_paid double,
    buy_date timestamp,
    comission double);