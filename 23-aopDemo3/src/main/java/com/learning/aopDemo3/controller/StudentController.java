package com.learning.aopDemo3.controller;

import com.learning.aopDemo3.dto.Student;
import com.learning.aopDemo3.service.StudentService;
import com.learning.aopDemo3.service.StudentServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentServiceInterface studentService;
    public StudentController(StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> getStudent() {
        String s = "All students data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
