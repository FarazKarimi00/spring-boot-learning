package com.learning.jpaRelationships.controller;

import com.learning.jpaRelationships.model.Student;
import com.learning.jpaRelationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student student,
            @RequestParam Long dept_id
    ) {
        studentService.createStudent(student, dept_id);
        return ResponseEntity.ok("Student created");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent(
            @RequestBody Student student,
            @RequestParam String dept_name
    ) {
        studentService.createStudent(student, dept_name);
        return ResponseEntity.ok("Student created");
    }
}
