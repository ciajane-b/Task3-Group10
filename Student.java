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

  @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("middleName='" + middleName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .add("gender='" + gender + "'")
                .add("address='" + address + "'")
                .add("contactNumber='" + contactNumber + "'")
                .add("email='" + email + "'")
                .add("course='" + course + "'")
                .toString();
    }

  // Static Builder Class
    public static class Builder {
        private int id;
        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private String gender;
        private String address;
        private String contactNumber;
        private String email;
        private String course;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder course(String course) {
            this.course = course;
            return this;
        }

        public Student build() {
            // Validate required fields
            if (firstName == null || lastName == null) {
                throw new IllegalStateException("First name and last name are required");
            }
            return new Student(this);
        }
    }
}
