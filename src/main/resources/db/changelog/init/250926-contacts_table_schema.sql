--liquibase formatted sql

--changeset ally:150926-contact_table_schema

CREATE TABLE IF NOT EXISTS contacts
(
    contact_id                  UUID            PRIMARY KEY     DEFAULT gen_random_uuid(),
    contact_phone_number        VARCHAR(13)     NOT NULL,
    contact_name                VARCHAR(100)    NOT NULL,
    contact_service             VARCHAR(20),
    created_at                  TIMESTAMPTZ     DEFAULT         CURRENT_TIMESTAMP,
    updated_at                  TIMESTAMPTZ     NOT NULL        DEFAULT NOW()
);
