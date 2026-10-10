--liquibase formatted sql

--changeset ally:101026-link_columns_ads
ALTER TABLE ads
ADD COLUMN ad_link VARCHAR(256);