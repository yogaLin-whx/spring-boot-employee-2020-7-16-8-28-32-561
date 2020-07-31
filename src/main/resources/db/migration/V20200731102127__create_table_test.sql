DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(20),
    age INT,
    gender VARCHAR(10),
    company_id INT
);