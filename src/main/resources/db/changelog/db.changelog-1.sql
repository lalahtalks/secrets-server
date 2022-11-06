--liquibase formatted sql

--changeset author:dlesignac id:create_secret_table

create table if not exists secret
(
    id         varchar(50) primary key,
    account_id varchar(50) not null,
    name       text not null,
    url        text,
    username   text,
    password   text not null,
    created_at timestamp with time zone not null
);

--rollback drop table if exists secret;
