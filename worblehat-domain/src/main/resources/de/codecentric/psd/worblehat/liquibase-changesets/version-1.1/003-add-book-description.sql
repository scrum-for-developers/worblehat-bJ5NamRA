-- liquibase formatted sql

-- changeset action:alter_table
ALTER TABLE book ADD description VARCHAR(4000) NOT NULL AFTER year_of_publication;