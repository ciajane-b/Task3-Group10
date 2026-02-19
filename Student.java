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

}
