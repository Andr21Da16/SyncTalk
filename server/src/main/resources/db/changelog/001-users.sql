--liquibase formatted sql

--changeset andree:create-pgcrypto
CREATE EXTENSION IF NOT EXISTS pgcrypto;

--changeset andree:create-users-table
CREATE TABLE users (
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    first_name VARCHAR(120) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    username VARCHAR(40) NOT NULL,
    email TEXT NOT NULL,
    phone TEXT NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    biography TEXT NOT NULL DEFAULT '.',
    profile_photo_url TEXT,
    is_online BOOLEAN DEFAULT FALSE,
    last_seen TIMESTAMPTZ,
    created_at TIMESTAMPTZ DEFAULT now(),
    updated_at TIMESTAMPTZ,
    CONSTRAINT user_id_pk PRIMARY KEY (id),
    CONSTRAINT user_username_uk UNIQUE (username),
    CONSTRAINT user_email_uk UNIQUE (email)
);

--changeset andree:003-users-indexes
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);