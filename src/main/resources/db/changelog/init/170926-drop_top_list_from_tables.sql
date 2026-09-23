--liquibase formatted sql

--changeset ally:170926-top-list-remove

ALTER TABLE countries
DROP COLUMN top_list;

ALTER TABLE universities
DROP COLUMN top_list;