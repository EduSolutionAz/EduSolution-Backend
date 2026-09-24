--liquibase formatted sql

--changeset ally:240926-applicant_generations_table_schema

CREATE TABLE IF NOT EXISTS applicant_generations(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    token_hash VARCHAR(64) NOT NULL,
    client_name VARCHAR(100) NOT NULL,
    client_email VARCHAR(100) NOT NULL,
    expires_at TIMESTAMPTZ NOT NULL,
    is_used BOOLEAN NOT NULL,
    created_at TIMESTAMPTZ         NOT NULL                DEFAULT NOW()
);