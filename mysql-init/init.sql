USE playersdb;

CREATE TABLE players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    last_name VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    city VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    birth_date DATE,
    CHECK (CHAR_LENGTH(first_name) > 0),
    CHECK (CHAR_LENGTH(last_name) > 0),
    CHECK (CHAR_LENGTH(city) > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO players (first_name, last_name, city, birth_date) VALUES
('Alice', 'Johnson', 'Stockholm', '1992-04-25'),
('David', 'Smith', 'Malmö', '1988-11-10'),
('Emma', 'Brown', 'Gothenburg', '1995-02-15'),
('Oliver', 'Williams', 'Uppsala', '1990-06-30'),
('Sophia', 'Miller', 'Luleå', '1990-06-05'),
('James', 'Davis', 'Helsinki', '1985-01-22'),
('Mia', 'Wilson', 'Copenhagen', '1998-03-12'),
('Lucas', 'Martinez', 'Oslo', '1999-07-28'),
('Ava', 'Garcia', 'Aarhus', '1999-12-01'),
('Liam', 'Rodriguez', 'Reykjavik', '1989-05-19');