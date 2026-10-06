--liquibase formatted sql

--changeset ally:020926-spin_results_table_schema
CREATE TABLE IF NOT EXISTS spin_results(
    spin_result_id      UUID                PRIMARY KEY             DEFAULT gen_random_uuid(),
    participant_id      UUID                NOT NULl,
    spin_prize_id       UUID                NOT NULL,
    email               VARCHAR(75),
    reward_id           UUID                NOT NULL,
    created_at          TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),
    updated_at          TIMESTAMPTZ         NOT NULL                DEFAULT NOW(),

    CONSTRAINT fk_participant
    FOREIGN KEY (participant_id)
    REFERENCES spin_participants (participant_id),

    CONSTRAINT fk_prize
    FOREIGN KEY (spin_prize_id)
    REFERENCES spin_prizes (spin_prize_id)
    );