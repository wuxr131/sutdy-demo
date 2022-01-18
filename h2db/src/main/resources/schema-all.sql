DROP TABLE IF EXISTS students;

CREATE TABLE students
(
    stu_id  INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(128) NOT NULL,
    age     INT,
    address VARCHAR(256)
);

INSERT INTO students (name, age, address) VALUES
('Kayle', 20, 'BJ'),
('Janna', 22, 'SH'),
('Rivan', 24, 'CQ');
