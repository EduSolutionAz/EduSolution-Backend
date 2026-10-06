--liquibase formatted sql

--changeset ally:020926-spin_prizes_table_schema
CREATE TABLE IF NOT EXISTS spin_prizes(
    spin_prize_id       UUID                PRIMARY KEY             DEFAULT gen_random_uuid(),
    spin_prize_name     VARCHAR(50)         NOT NULl,
    spin_prize_weight   INT        NOT NULL,
    created_at          TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);