--liquibase formatted sql

--changeset ally:130926-university_sections_table_schema

CREATE TABLE university_sections (
                                     section_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     university_id UUID NOT NULL,
                                     faculty_id UUID,
                                     title VARCHAR(255) NOT NULL,
                                     content TEXT NOT NULL,
                                     areas TEXT NOT NULL,

                                     CONSTRAINT fk_university_section_university
                                         FOREIGN KEY (university_id)
                                             REFERENCES universities(university_id),

                                     CONSTRAINT fk_university_section_faculty
                                         FOREIGN KEY (faculty_id)
                                             REFERENCES faculties(faculty_id)
);