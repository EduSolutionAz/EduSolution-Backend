--liquibase formatted sql

--changeset ally:130926-faculties_table_schema

CREATE TABLE faculties
(
    faculty_id    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    university_id UUID         NOT NULL,
    faculty_name  VARCHAR(255) NOT NULL,
    created_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),
    updated_at       TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),

    CONSTRAINT fk_faculty_university
        FOREIGN KEY (university_id)
            REFERENCES universities (university_id)
);