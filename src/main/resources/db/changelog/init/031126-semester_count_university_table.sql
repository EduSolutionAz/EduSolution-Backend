--liquibase formatted sql

--changeset ally:191026-semester_count_university_table

ALTER TABLE universities
    ADD COLUMN semester_count INT;