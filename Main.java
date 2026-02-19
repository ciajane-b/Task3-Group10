import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = null;

        try {
            repository = new Repository();
            System.out.println("=== Student Information System ===");

            while (true) {
                System.out.println("\n1. Add New Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Delete All Students");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        addNewStudent(scanner, repository);
                        break;
                    case "2":
                        viewAllStudents(repository);
                        break;
                    case "3":
                        searchStudentById(scanner, repository);
                        break;
                    case "4":
                        deleteAllStudents(repository);
                        break;
                    case "5":
                        System.out.println("Exiting application...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            if (repository != null) {
                repository.closeConnection();
            }
            scanner.close();
        }
    }                  
}
