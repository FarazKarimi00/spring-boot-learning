package com.learning.jpaPracticeProject.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Min(18)
    @Max(25)
    private Integer age;
    @NotNull
    private Long departmentId;
    @NotNull
    @Valid
    private ProfileRequestDTO profile;
}
