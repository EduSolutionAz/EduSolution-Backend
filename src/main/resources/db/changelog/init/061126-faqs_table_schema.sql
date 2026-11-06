--liquibase formatted sql

--changeset ally:061126-faqs_table_schema

CREATE TABLE IF NOT EXISTS faqs
(
    faq_id              UUID                PRIMARY KEY             DEFAULT gen_random_uuid(),
    faq_question        TEXT                NOT NULL,
    faq_answer          TEXT                NOT NULL,
    created_at          TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),
    updated_at          TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);