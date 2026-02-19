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

     private static void addNewStudent(Scanner scanner, Repository repository) {
        try {
            System.out.println("\n--- Add New Student ---");

            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Middle Name (press Enter if none): ");
            String middleName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

             // Using Builder pattern with method chaining
            Student student = new Student.Builder()
                    .id(id)
                    .firstName(firstName)
                    .middleName(middleName.isEmpty() ? null : middleName)
                    .lastName(lastName)
                    .age(age)
                    .gender(gender)
                    .address(address)
                    .contactNumber(contactNumber)
                    .email(email)
                    .course(course)
                    .build();

            repository.saveStudent(student);
            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.err.println("Invalid input format. Please enter valid numbers for ID and Age.");
        } catch (SQLException e) {
            System.err.println("Error saving student: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
    
    private static void viewAllStudents(Repository repository) {
        try {
            List<Student> students = repository.getStudents();

            if (students.isEmpty()) {
                System.out.println("\nNo students found in the database.");
                return;
            }

            System.out.println("\n--- All Students ---");
            for (Student student : students) {
                System.out.println(student);
                System.out.println("-------------------");
            }
            System.out.println("Total students: " + students.size());

        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }
    }
}
