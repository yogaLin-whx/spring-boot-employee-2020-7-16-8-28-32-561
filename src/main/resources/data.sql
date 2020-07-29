DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(20),
    age INT,
    gender VARCHAR(10)
);

INSERT INTO employee(name, age, gender)
VALUES('Eric', 18, 'male'),
('Chris', 18, 'male'),
('Ang', 18, 'female'),
('Hai feng', 18, 'male');