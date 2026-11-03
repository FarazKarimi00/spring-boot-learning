package com.learning.jpaRelationships.controller;

import com.learning.jpaRelationships.model.Student2;
import com.learning.jpaRelationships.service.Student2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students2")
public class Student2Controller {
    Student2Service studentService;
    public Student2Controller(Student2Service studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student2 student,
            @RequestParam List<Long> courseIds
    ) {
        studentService.createStudent2(student, courseIds);
        return ResponseEntity.ok("Student created");
    }
}
