--liquibase formatted sql

--changeset ally:20251224-client_table_schema
CREATE TABLE IF NOT EXISTS clients(
    client_id               UUID                PRIMARY KEY            DEFAULT gen_random_uuid(),
    client_name             VARCHAR(50)         NOT NULL,
    client_email            VARCHAR(50)        NOT NULL                UNIQUE,
    client_number           VARCHAR(15)        NOT NULL                UNIQUE,
    client_password         VARCHAR(72)         NOT NULL,
    client_roles            VARCHAR(30)         NOT NULL,
    client_created_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),
    client_updated_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);