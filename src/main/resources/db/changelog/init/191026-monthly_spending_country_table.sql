--liquibase formatted sql

--changeset ally:191026-monthly_spending_country_table

ALTER TABLE countries
ADD COLUMN monthly_spending NUMERIC(8,2);