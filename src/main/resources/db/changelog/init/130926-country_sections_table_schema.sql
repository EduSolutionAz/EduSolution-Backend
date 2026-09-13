--liquibase formatted sql

--changeset ally:130926-country_sections_table_schema

CREATE TABLE country_sections (
                                  section_id UUID PRIMARY KEY,
                                  country_id UUID,
                                  title VARCHAR(255) NOT NULL,
                                  content TEXT NOT NULL,
                                  areas TEXT NOT NULL,

                                  CONSTRAINT fk_country_section_country
                                      FOREIGN KEY (country_id)
                                          REFERENCES countries(country_id)
);