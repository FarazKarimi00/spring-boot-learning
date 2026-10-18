package com.learning.aopDemo2.controller;

import com.learning.aopDemo2.dto.Student;
import com.learning.aopDemo2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student studentResp = studentService.createStudent(student);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod() {
        String s = "abcd";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
