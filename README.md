 Mysql Database  creation and tables required....

-- Create the 'pg' database
CREATE DATABASE IF NOT EXISTS pg;

-- Switch to the 'pg' database
USE pg;


-- Table: register
CREATE TABLE register (
    name VARCHAR(255),
    age INT,
    email VARCHAR(255),
    password VARCHAR(255)
);

-- Table: roomdetails
CREATE TABLE roomdetails (
    roomno INT,
    roomtype VARCHAR(255),
    roomprice INT,
    roomloc VARCHAR(255),
    availability INT
);

-- Table: facilities
CREATE TABLE facilities (
    facility_id INT,
    facility_name VARCHAR(255),
    facility_type VARCHAR(255),
    additional_charges INT
);

-- Table: queries
CREATE TABLE queries (
    username VARCHAR(255),
    roomno INT,
    description VARCHAR(255),
    status VARCHAR(255)
);

-- Insert sample values into register table
INSERT INTO register (name, age, email, password)
VALUES
    ('John Doe', 25, 'john.doe@example.com', 'john123'),
    ('Alice Smith', 30, 'alice.smith@example.com', 'alice456');

-- Insert sample values into roomdetails table
INSERT INTO roomdetails (roomno, roomtype, roomprice, roomloc, availability)
VALUES
    (101, 'Single', 500, 'First Floor', 1),
    (102, 'Double', 800, 'Second Floor', 0);

-- Insert sample values into facilities table
INSERT INTO facilities (facility_id, facility_name, facility_type, additional_charges)
VALUES
    (1, 'Gym', 'Fitness', 20),
    (2, 'Wi-Fi', 'Internet', 10);

-- Insert sample values into queries table
INSERT INTO queries (username, roomno, description, status)
VALUES
    ('John Doe', 101, 'Issue with AC', 'Open'),
    ('Alice Smith', 102, 'Room cleaning', 'Closed');
 
