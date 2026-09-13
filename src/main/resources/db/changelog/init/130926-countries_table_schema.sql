--liquibase formatted sql

--changeset ally:130926-countries_table_schema

CREATE TABLE countries (
                           country_id UUID PRIMARY KEY,
                           country_name VARCHAR(255) NOT NULL UNIQUE,
                           country_flag_url VARCHAR(255) NOT NULL,
                           country_photo_url VARCHAR(255) NOT NULL,
                           university_count INTEGER NOT NULL,
                           tuition_fee_entry NUMERIC,
                           rental_fee_entry NUMERIC,
                           visa_help BOOLEAN NOT NULL,
                           dormitory_help BOOLEAN NOT NULL,
                           created_at TIMESTAMP WITH TIME ZONE NOT NULL,
                           updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);