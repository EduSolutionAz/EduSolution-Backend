--liquibase formatted sql

--changeset ally:090926-drop-ip

ALTER TABLE table_name
    ALTER COLUMN column_name DROP NOT NULL;