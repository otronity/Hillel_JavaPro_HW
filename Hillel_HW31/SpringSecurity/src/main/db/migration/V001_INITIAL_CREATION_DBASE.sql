-- Создание схемы
CREATE SCHEMA IF NOT EXISTS user_shema;

-- Создание таблицы Product
CREATE TABLE IF NOT EXISTS user_shema.product
(
    id   serial           NOT NULL primary key,
    name varchar(250)     NOT NULL,
    cost double precision NOT NULL
    );

-- Создание таблицы User
CREATE TABLE IF NOT EXISTS user_shema.user
(
    id       serial,
    name     varchar(250) NOT NULL primary key,
    password varchar(25)  NOT NULL,
    user_role varchar(5)   NOT NULL
    );
