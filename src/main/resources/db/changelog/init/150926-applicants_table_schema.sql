--liquibase formatted sql

--changeset ally:150926-applicants_table_schema

CREATE TABLE applicants
(
    applicant_id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    applicant_name         VARCHAR(50) NOT NULL,
    applicant_service_type VARCHAR(20),
    comment                TEXT        NOT NULL,
    created_at             TIMESTAMPTZ      DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);
