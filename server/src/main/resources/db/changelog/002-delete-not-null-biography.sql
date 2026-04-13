--liquibase formatted sql

--changeset andree:alter-column-biography
ALTER TABLE users ALTER COLUMN biography DROP NOT NULL;