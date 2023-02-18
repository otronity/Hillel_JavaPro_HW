-- Создание схемы
CREATE SCHEMA IF NOT EXISTS school;

-- Создание последовательности;
CREATE SEQUENCE IF NOT EXISTS school.student_id_seq;

-- Создание таблиц;
CREATE TABLE IF NOT EXISTS school.student
(
    id               integer NOT NULL DEFAULT nextval('school.student_id_seq') primary key,
    name             varchar(250) not null,
    email            varchar(250) NOT NULL
    );

CREATE TABLE IF NOT EXISTS school.mark
(
    id               integer constraint fk_mark_id references school.student(id),
    discipline       varchar(250) not null,
    value            integer NOT NULL,
    constraint pk_mark primary key(id, discipline)
    );

