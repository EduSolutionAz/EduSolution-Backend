--liquibase formatted sql

--changeset ally:20251224-client_nverified_table_schema
CREATE TABLE IF NOT EXISTS clients_nverified(
    client_nverified_id     UUID                PRIMARY KEY            DEFAULT gen_random_uuid(),
    client_name             VARCHAR(50)         NOT NULL,
    client_email            VARCHAR(100)        NOT NULL                UNIQUE,
    client_number           VARCHAR(15)        NOT NULL                UNIQUE,
    client_code             VARCHAR(6)          NOT NULL,
    client_code_expire      TIMESTAMPTZ         NOT NULL,
    client_code_last_sent   TIMESTAMPTZ         NOT NULL,
    account_state           VARCHAR(20)         NOT NULL,
    client_created_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
    );

CREATE UNIQUE INDEX clientnv_username_index ON clients (client_name);