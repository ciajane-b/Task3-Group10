import java.util.StringJoiner;

public class Student {
  
    private final int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final String address;
    private final String contactNumber;
    private final String email;
    private final String course;

  private Student(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
        this.course = builder.course;
    }
  
  // Getters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }

}
