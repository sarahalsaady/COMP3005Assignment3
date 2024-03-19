import java.sql.*;

/**
 * The AppFunctions class includes methods for connecting to a PostgreSQL database
 * and performing CRUD operations on the `students` table.
 */

public class AppFunctions {
    /**
     * Establishes a connection to the PostgreSQL database.
     *
     * @return A Connection object to the database.
     */
    public static Connection connect(){
        String url = "jdbc:postgresql://localhost:5432/Assignment3";
        String user = "postgres";
        String password = "hanfoosh";
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null){
                System.out.println("Connected to the database");
            }
            else{
                System.out.println("Failed to connect to the database");
            }
        }
        catch (Exception e){};
        return connection;
    }
    /**
     * Retrieves all students from the `students` table and prints their details.
     */
    public static void getAllStudents() {
        //SQl query to select all students
        String SQL = "SELECT * FROM students";
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(SQL)) {

            //Print each student's details
            while (result.next()) {
                System.out.println(result.getInt("student_id") + " " +
                        result.getString("first_name") + " " +
                        result.getString("last_name") + " " +
                        result.getString("email") + " " +
                        result.getDate("enrollment_date"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Inserts a new student into the `students` table.
     *
     * @param first_name The first name of the student.
     * @param last_name The last name of the student.
     * @param email The email of the student.
     * @param enrollment_date The enrollment date of the student.
     */
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        //Query to insert a new student
        String SQL = "INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES(?,?,?,?)";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(SQL)) {

            //Set parameters for the prepared statement
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, email);
            statement.setDate(4, Date.valueOf(enrollment_date));
            int affectedRow = statement.executeUpdate(); //Execute the update
            //Check if adding student was successful
            if (affectedRow > 0){
                System.out.println("Student was added successfully.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Updates the email address of a specific student in the `students` table.
     *
     * @param student_id The ID of the student whose email is to be updated.
     * @param new_email The new email address.
     */
    public static void updateStudentEmail(int student_id, String new_email) {
        //Query to update a student's email
        String SQL = "UPDATE students SET email = ? WHERE student_id = ?";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(SQL)) {

            //Set parameters for the prepared statement
            statement.setString(1, new_email);
            statement.setInt(2, student_id);
            int affectedRow = statement.executeUpdate();
            //Check if update was successful
            if (affectedRow > 0){
                System.out.println("Student email updated successfully.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Deletes a student from the `students` table based on the student ID.
     *
     * @param student_id The ID of the student to delete.
     */
    public static void deleteStudent(int student_id) {
        //Query to delete a student
        String SQL = "DELETE FROM students WHERE student_id = ?";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(SQL)) {

            //Set the parameter for he prepared statement
            statement.setInt(1, student_id);

            int affectedRows = statement.executeUpdate();

            //Check if delete wasz successful
            if (affectedRows > 0) {
                System.out.println("Student deleted successfully.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

