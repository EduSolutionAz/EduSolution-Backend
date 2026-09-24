--liquibase formatted sql

--changeset ally:150926-applicants_table_schema

CREATE TABLE IF NOT EXISTS applicants
(
    applicant_id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    applicant_email        VARCHAR(100) NOT NULL,
    applicant_name         VARCHAR(100) NOT NULL,
    applicant_service_type VARCHAR(20),
    comment                TEXT        NOT NULL,
    created_at             TIMESTAMPTZ      DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);
