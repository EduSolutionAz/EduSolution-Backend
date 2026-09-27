--liquibase formatted sql

--changeset ally:270926-admin_table_schema
CREATE TABLE IF NOT EXISTS admins(
    admin_id                UUID                PRIMARY KEY             DEFAULT gen_random_uuid(),
    admin_username          VARCHAR(50)         NOT NULL,
    admin_email             VARCHAR(50)         NOT NULL                UNIQUE,
    admin_password         VARCHAR(72)         NOT NULL,
    admin_created_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),
    admin_updated_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);