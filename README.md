# Student Database Management Application

This Java application demonstrates basic CRUD (Create, Read, Update, Delete) operations on a PostgreSQL database. It
allows managing student records, including adding new students, updating student emails, deleting students, and fetching
all student records from the `students` table.

## Prerequisites

- Java JDK 8 or later
- PostgreSQL Server (Ensure it's running on localhost with the default port `5432`)
- PostgreSQL JDBC Driver (Included in the project dependencies if using Maven)

## Setup

### Database Setup

1. **Create the Database:**
    - Launch PostgreSQL on your system and create a new database named `Assignment3`.

2. **Create the `students` Table:**
    - Execute the following SQL script to create your table:

```sql
CREATE TABLE students
(
    student_id      SERIAL PRIMARY KEY,
    first_name      TEXT NOT NULL,
    last_name       TEXT NOT NULL,
    email           TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);
```

3. **Insert Initial Data (Optional):**
    - You can insert some initial records into the `students` table using the following SQL command:

```sql
INSERT INTO students (first_name, last_name, email, enrollment_date)
VALUES ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
       ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
       ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
```

### Application Setup

1. **Clone the Repository:**
    - If the project is hosted on a Git repository, provide instructions for cloning. Otherwise, instruct on how to
      download and extract the project files.

```bash
git clone <repository-url>
```

2. **Include PostgreSQL JDBC Driver:**
    - Make sure the PostgreSQL JDBC driver is included in your project. If you're using Maven, it should be in
      your `pom.xml`. Otherwise, download the driver and add it to your project's classpath.

3. **Update Database Credentials:**
    - Open `AppFunctions.java` and update the `connect` method with your actual PostgreSQL username and password.

## Compilation and Running

Compile and run the Java code using an IDE or the terminal.

## Using the Application

The application provides these functions:

- **Get All Students:** No input required. Simply runs and prints all student records.
- **Add a New Student:** Requires providing first name, last name, email, and enrollment date.
- **Update Student Email:** Requires specifying the student ID and new email address.
- **Delete a Student:** Requires specifying the student ID of the student to delete.

## Video Demonstration

Follow the video under this link for a thorough demonstration on how to use the
application:

https://youtu.be/ig9Ap64RMO8
