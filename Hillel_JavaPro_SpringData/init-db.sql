CREATE SEQUENCE IF NOT EXISTS order_store.product_id_seq;
CREATE SEQUENCE IF NOT EXISTS order_store.order_id_seq;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS order_store.product
(
    id integer NOT NULL DEFAULT nextval('order_store.product_id_seq') primary key,
    name varchar(20) not null,
    cost float NOT NULL
);

insert into order_store.product( name, cost) values ('Milk', 36);
insert into order_store.product(name, cost) values ('Cookies', 76);
insert into order_store.product(name, cost) values ('Yogurt', 25);


CREATE TABLE IF NOT EXISTS order_store.order
(
    id integer NOT NULL DEFAULT nextval('order_store.order_id_seq') primary key,
    date timestamp NOT NULL,
    cost float NOT NULL);

insert into order_store.order(date, cost) values ('20230210 14:12:04', 61);
insert into order_store.order(date, cost) values ('20230210 14:12:04', 137);
insert into order_store.order(date, cost) values ('20230210 14:12:04', 112);


create table order_store.orderproducts(
    orderid integer,
    productid integer,
constraint PK_orderproducts primary key (orderid, productid));

insert into order_store.orderproducts values(1, 1);
insert into order_store.orderproducts values(1, 3);
insert into order_store.orderproducts values(2, 1);
insert into order_store.orderproducts values(2, 2);
insert into order_store.orderproducts values(2, 3);
insert into order_store.orderproducts values(3, 1);
insert into order_store.orderproducts values(3, 2);
