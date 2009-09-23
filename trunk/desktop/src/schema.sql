drop table trade_transaction_close;
drop table trade_transaction;
drop table account;
drop table transaction_type;
drop table price;
drop table portfolio;
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

create table transaction_type (
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

create table trade_transaction (
    id integer not null primary key generated always as identity,
    portfolio integer references portfolio(id),
    transaction_date date,
    transaction_type integer references transaction_type(id),
    stock varchar(10) references stock(symbol),
    quantity integer,
    price double,
    comission double,
    remark varchar(100));

create table trade_transaction_relation (
    open_transaction integer references trade_transaction(id),
    close_transaction integer references trade_transaction(id),
    quantity integer,
    primary key(open_transaction,close_transaction));