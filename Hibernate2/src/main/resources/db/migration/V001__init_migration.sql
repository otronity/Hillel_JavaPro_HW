-- Создание схемы
 CREATE SCHEMA IF NOT EXISTS shop;

alter schema shop owner to postgres;


CREATE SEQUENCE IF NOT EXISTS shop.product_id_seq;

create table product (
    id int primary key not null DEFAULT nextval('shop.product_id_seq') primary key,
    name varchar(100) NOT NULL,
    description varchar(250) NOT NULL,
    price double NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS shop.address_id_seq;

create table address(
    id int not null DEFAULT nextval('shop.address_id_seq') primary key,
    client_id int constraint fk_address_clientid references shop.client(id),
    country varchar(250),
    city varchar(250),
    street varchar(250),
    house varchar(250)
);

CREATE SEQUENCE IF NOT EXISTS shop.client_id_seq;

create table client(
    id int NOT NULL DEFAULT nextval('shop.client_id_seq') primary key,
    name varchar(250),
    email varchar(250),
    phone varchar(25)
);

CREATE SEQUENCE IF NOT EXISTS shop.order_id_seq;

create table order (
    id int NOT NULL DEFAULT nextval('shop.order_id_seq') primary key,
    clientid int NOT NULL constraint fk_address_clientid references shop.client(id)
);

CREATE SEQUENCE IF NOT EXISTS shop.order_item_id_seq;

create table shop.order_item(
    id int NOT NULL DEFAULT nextval('shop.order_item_id_seq') primary key,
    orderId int NOT NULL constraint fk_order_id references shop.order(id),
    productid int NOT NULL constraint fk_product_id references shop.product(id),
    count int NOT NULL
);