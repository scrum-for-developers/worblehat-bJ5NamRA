-- liquibase formatted sql

-- changeset action:alter_table
ALTER TABLE book ADD description TEXT NOT NULL AFTER year_of_publication;