-- liquibase formatted sql

-- changeset action:alter_table
ALTER TABLE `test` ADD `description` TEXT CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL AFTER `test`;