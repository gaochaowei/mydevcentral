drop table root.account;
drop table root.stock;
drop table root.price;
drop table root.portfolio;
drop table root.trxn_type;
drop table root.trxn;
drop table root.trxn_rel;

create table root.stock (
    symbol varchar(10) not null primary key,
    name varchar(30),
    create_date date not null default current_date,
    update_date date not null default current_date);

create table root.price (
    stock_symbol varchar(10) not null,
    price_date date not null,
    price_open double,
    price_high double,
    price_low double,
    price_adj double,
    trade_volumn integer,
    create_date date not null default current_date,
    update_date date not null default current_date,
    primary key (stock,price_date));

create table root.trxn_type (
    id integer not null primary key,
    name varchar(30)
);

create table root.account (
    id integer not null primary key,
    name varchar(30),
    balance double default 0);

create table root.portfolio (
    id integer not null primary key,
    name varchar(30),
    remark varchar(100),
    benchmark varchar(10));

create table root.trxn (
    id integer not null primary key,
    portfolio_id integer,
    trxn_date date,
    trxn_type_id integer,
    stock_symbol varchar(10),
    quantity integer,
    price double,
    comission double,
    remark varchar(100));

create table root.trxn_rel (
    open_trxn_id integer,
    close_trxn_id integer,
    quantity integer,
    primary key(open_trxn_id,close_trxn_id));