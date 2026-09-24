--liquibase formatted sql

--changeset ally:130926-programs_table_schema

CREATE TABLE programs
(
    program_id     UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    university_id  UUID         NOT NULL,
    program_name   VARCHAR(255) NOT NULL,
    fee            NUMERIC,
    semester_count INTEGER      NOT NULL,
    created_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),
    updated_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),

    CONSTRAINT fk_program_university
        FOREIGN KEY (university_id)
            REFERENCES universities (university_id)
);