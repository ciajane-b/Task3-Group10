import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
  private static final String DB_URL = "jdbc:sqlite:students.db";
  private Connection connection;
  public Repository() throws SQLException {
  connection = DriverManager.getConnection(DB_URL);
  createTable();
  addDefaultStudent(); // Added this line to insert default student
 }
  
  private void createTable() throws SQLException {
  String sql = "CREATE TABLE IF NOT EXISTS students (" +
    "student_id INTEGER PRIMARY KEY, " +
    "first_name TEXT NOT NULL, " +
    "middle_name TEXT, " +
    "last_name TEXT NOT NULL, " +
    "age INTEGER NOT NULL, " +
    "gender TEXT NOT NULL, " +
    "address TEXT NOT NULL, " +
    "contact_number TEXT NOT NULL, " +
    "email TEXT NOT NULL, " +
    "course TEXT NOT NULL" +
    ")";
    
  try (Statement stmt = connection.createStatement()) {
  stmt.execute(sql);
 }

 // New method to add a default student
 private void addDefaultStudent() throws SQLException {
   // Check if table is empty
     String countSql = "SELECT COUNT(*) FROM students";
     try (Statement stmt = connection.createStatement();
       ResultSet rs = stmt.executeQuery(countSql)) {
       
       if (rs.next() && rs.getInt(1) == 0) {
         // Create a default student using Builder pattern
         Student defaultStudent = new Student.Builder()
           .id(1001)
           .firstName("Juan")
           .middleName("Santos")
           .lastName("Dela Cruz")
           .age(20)
           .gender("Male")
           .address("123 Rizal St., Manila")
           .contactNumber("09123456789")
           .email("juan.delacruz@email.com")
           .course("Computer Science")
           .build();
         
         // Save the default student
         saveStudent(defaultStudent);
         System.out.println("Default student added to database successfully!");
      }    
    }
 }

  public void saveStudent(Student student) throws SQLException {
     String sql = """
       INSERT INTO students (student_id, first_name, middle_name, last_name, age, gender,
                             address, contact_number, email, course)
       VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
       """;
    
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
       pstmt.setInt(1, student.getId());
       pstmt.setString(2, student.getFirstName());
       pstmt.setString(3, student.getMiddleName());
       pstmt.setString(4, student.getLastName());
       pstmt.setInt(5, student.getAge());
       pstmt.setString(6, student.getGender());
       pstmt.setString(7, student.getAddress());
       pstmt.setString(8, student.getContactNumber());
       pstmt.setString(9, student.getEmail());
       pstmt.setString(10, student.getCourse());
       pstmt.executeUpdate();
     } 
  }

  public List<Student> getStudents() throws SQLException {
     List<Student> students = new ArrayList<>();
     String sql = "SELECT * FROM students ORDER BY student_id";
    
     try (Statement stmt = connection.createStatement();
          ResultSet rs = stmt.executeQuery(sql)) {
       
       while (rs.next()) {
         Student student = new Student.Builder()
                 .id(rs.getInt("student_id"))
                 .firstName(rs.getString("first_name"))
                 .middleName(rs.getString("middle_name"))
                 .lastName(rs.getString("last_name"))
                 .age(rs.getInt("age"))
                 .gender(rs.getString("gender"))
                 .address(rs.getString("address"))
                 .contactNumber(rs.getString("contact_number"))
                 .email(rs.getString("email"))
                 .course(rs.getString("course"))
                 .build();
        students.add(student);
     }
   }
   return students;
 }
  
 public Student getStudentById(int id) throws SQLException {
   String sql = "SELECT * FROM students WHERE student_id = ?";
   
   try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
           if (rs.next()) {
             return new Student.Builder()
                       .id(rs.getInt("student_id"))
                       .firstName(rs.getString("first_name"))
                       .middleName(rs.getString("middle_name"))
                       .lastName(rs.getString("last_name"))
                       .age(rs.getInt("age"))
                       .gender(rs.getString("gender"))
                       .address(rs.getString("address"))
                       .contactNumber(rs.getString("contact_number"))
                       .email(rs.getString("email"))
                       .course(rs.getString("course"))
                       .build();
         }
       }
   }
   return null;
 }

  
}
