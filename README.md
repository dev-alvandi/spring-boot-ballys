
# Spring Boot & MySQL Configuration (WITH & Without Docker)

Clone this repository to your local machine and follow the steps below accordingly. :)

## Setting Up MySQL to Feed the Spring Boot App (Without Docker)

Log in to your MySQL database and execute the following SQL code in your local MySQL environment:


```sql
CREATE DATABASE playersdb;

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
('David', 'Smith', 'Kiruna', '1988-11-10'),
('Emma', 'Brown', 'Gothenburg', '1995-02-15'),
('Oliver', 'Williams', 'Uppsala', '1990-06-30'),
('Sophia', 'Miller', 'Lund', '1990-06-05'),
('James', 'Davis', 'Helsinki', '1985-01-22'),
('Mia', 'Wilson', 'Copenhagen', '1998-03-12'),
('Lucas', 'Martinez', 'Oslo', '1999-07-28'),
('Ava', 'Garcia', 'Aarhus', '1999-12-01'),
('Liam', 'Rodriguez', 'Reykjavik', '1989-05-19');
```


## Setting Up Spring Boot (Without Docker)

When you open the project in IntelliJ IDEA, `mvn install` runs automatically to install all dependencies listed in the `pom.xml` file.

First, navigate to the `./src/main/resources` directory and update the following MySQL configuration settings in the `application.properties` file:

```
spring.datasource.url=jdbc:mysql://localhost:3306/playersdb
spring.datasource.username=<YOUR_LOCAL_MYSQL_USERNAME>
spring.datasource.password=<YOUR_LOCAL_MYSQL_PASSWORD>
```
Next, go to the src/main/java/com/noah/spring_boot_ballys_assignment/SpringBootBallysAssignmentApplication.java file and run the application.

CORS configuration is set up to allow communication between the Vue.js application and the Spring Boot application.

# Setting Up MySQL and the Spring Boot App (With Docker)

The video attached in my email provides detailed instructions on how to run Docker to set up everything necessary for running the application. Below is a brief summary of the steps involved.

## Building the App and Running Docker Compose

After cloning the project, run `mvn clean` and `mvn install` to build the project. This step prepares the Docker setup, including assembling the MySQL image.

Next, execute the `docker-compose up` command to initialize both the MySQL database and the Spring Boot application.