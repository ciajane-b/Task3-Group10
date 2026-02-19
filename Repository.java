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
 
  
}
