-- liquibase formatted sql

-- changeset action:alter_table
ALTER TABLE book ADD description VARCHAR(255) NOT NULL AFTER year_of_publication;