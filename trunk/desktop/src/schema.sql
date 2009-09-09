drop table stock_position;
drop table portfolio;
drop table trade_order;
drop table account;
drop table order_type;
drop table price;
drop table stock;

create table stock (
    symbol varchar(10) not null primary key,
    name varchar(30),
    create_date date not null default current_date,
    update_date date not null default current_date);

create table price (
    stock varchar(10) not null references stock(symbol),
    price_date date not null,
    price_open double,
    price_high double,
    price_low double,
    price_adj double,
    trade_volumn integer,
    create_date date not null default current_date,
    update_date date not null default current_date,
    primary key (stock,price_date));

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
    order_date date,
    remark varchar(100));

create table stock_position (
    id integer not null primary key generated always as identity,
    portfolio integer references portfolio(id),
    stock varchar(10) references stock(symbol),
    quantity integer,
    price_paid double,
    buy_date date,
    comission double);