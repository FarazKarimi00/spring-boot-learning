package in.strikes.crudDTODemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {

    @NotBlank(message = "Name cannot be empty or null or blank")
    @Size(min = 2, max = 50, message = "Student name must be 2-50 character long")
    private String name;

    @Min(value = 15, message = "Student must be at least 18 year old")
    @NotNull(message = "Age is required")
    private Integer age;

    @NotNull(message = "Roll number is required")
    private Integer rollNo;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Student email must be valid")
    private String email;

    @NotBlank(message = "Subject number is required")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
