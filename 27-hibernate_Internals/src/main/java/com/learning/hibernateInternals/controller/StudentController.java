package com.learning.hibernateInternals.controller;

import com.learning.hibernateInternals.model.Student;
import com.learning.hibernateInternals.service.StudentService;
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
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created  successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,
                                                @PathVariable Long id) {
        studentService.updateStudent(student, id);
        return ResponseEntity.ok("Student updated successfully");
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
