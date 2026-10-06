--liquibase formatted sql

--changeset ally:060926-ads_table_schema
CREATE TABLE IF NOT EXISTS ads(
    ad_id                  UUID                PRIMARY KEY             DEFAULT gen_random_uuid(),
    title                  VARCHAR(75)         NOT NULl                UNIQUE,
    content                TEXT                NOT NULL,
    title_not_changed      TEXT                NOT NULL,
    ad_url                 VARCHAR(512)        NOT NULL,
    created_at          TIMESTAMPTZ            NOT NULL                DEFAULT NOW()
    );