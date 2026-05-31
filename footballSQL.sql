create database football;

use football;

CREATE TABLE user (
    id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);

CREATE TABLE training (
    id_training BIGINT AUTO_INCREMENT PRIMARY KEY,
    training_day ENUM('MONDAY', 'WEDNESDAY', 'FRIDAY') NOT NULL
);