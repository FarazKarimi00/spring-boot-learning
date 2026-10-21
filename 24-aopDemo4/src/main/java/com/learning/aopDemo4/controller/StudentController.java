package com.learning.aopDemo4.controller;

import com.learning.aopDemo4.dto.Student;
import com.learning.aopDemo4.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
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
