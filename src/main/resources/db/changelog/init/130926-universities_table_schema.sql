--liquibase formatted sql

--changeset ally:130926-universities_table_schema

CREATE TABLE universities (
                              university_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                              country_id UUID,
                              university_name VARCHAR(255) NOT NULL UNIQUE,
                              university_type VARCHAR(255),
                              description VARCHAR(255) NOT NULL,
                              university_logo_url VARCHAR(255),
                              top_list BOOLEAN,
                              city VARCHAR(255) NOT NULL,

                              CONSTRAINT fk_university_country
                                  FOREIGN KEY (country_id)
                                      REFERENCES countries(country_id)
);