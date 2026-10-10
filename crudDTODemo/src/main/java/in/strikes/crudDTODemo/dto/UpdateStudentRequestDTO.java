package in.strikes.crudDTODemo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateStudentRequestDTO {

    @NotBlank(message = "Name cannot be empty or null or blank")
    @Size(min = 2, max = 50, message = "Student name must be 2-50 character long")
    private String name;

    @Min(value = 15, message = "Student must be al least 15 years old")
    @NotNull(message = "Age is required")
    private Integer age;

    @NotNull(message = "Roll number is required")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
