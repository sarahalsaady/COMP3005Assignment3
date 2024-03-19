public class Main {
    public static void main(String[] args) {
        //Display all students
        System.out.println("Initial list of students:");
        AppFunctions.getAllStudents();

        //Add a new student
        //System.out.println("\nAdding a new student:");
        //AppFunctions.addStudent("Sarah", "Alsaady", "sarah.alsaady@example.com", "2024-03-18");
        //AppFunctions.getAllStudents();
        //AppFunctions.addStudent("Michael", "Williams", "michael.williams@example.com","2024-03-18");
        //AppFunctions.getAllStudents();

        //Update student email
        //System.out.println("\nUpdating student's email:");
        //AppFunctions.updateStudentEmail(17, "sarahalsaady@cmail.carleton.com");
        //AppFunctions.getAllStudents();

        //Delete student
        AppFunctions.deleteStudent(17);
        AppFunctions.getAllStudents();
    }
}

