DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id INT AUTO_INCREMENT NOT NULL  PRIMARY KEY,
    name VARCHAR(20),
    age INT,
    gender VARCHAR(10),
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);