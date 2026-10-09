--liquibase formatted sql

--changeset ally:090926-drop-ip

ALTER TABLE spin_participants
    ALTER COLUMN ip DROP NOT NULL;