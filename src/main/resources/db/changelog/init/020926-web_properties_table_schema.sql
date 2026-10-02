--liquibase formatted sql

--changeset ally:020926-web_properties_table_schema

CREATE TABLE IF NOT EXISTS web_properties(
    property_id             UUID            PRIMARY KEY             DEFAULT gen_random_uuid(),
    student_helped          INT             NOT NULL,
    visa_success_rate       NUMERIC(5,2)    NOT NULL,
    admission_sent          INT             NOT NULL,
    successful_admission    INT             NOT NULL,
    visa_help               INT             NOT NULL,
    successful_visa_help    INT             NOT NULL,
    created_at              TIMESTAMPTZ     NOT NULL                DEFAULT NOW()
);