--liquibase formatted sql

--changeset ally:020926-spin_participants_table_schema
CREATE TABLE IF NOT EXISTS spin_participants(
    participant_id      UUID                PRIMARY KEY             DEFAULT gen_random_uuid(),
    browser_id          UUID                NOT NULl,
    ip                  VARCHAR(256)        NOT NULL,
    created_at          TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);