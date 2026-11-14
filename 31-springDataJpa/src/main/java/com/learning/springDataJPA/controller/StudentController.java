package com.learning.springDataJPA.controller;

import com.learning.springDataJPA.entity.Student;
import com.learning.springDataJPA.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<Student> getStudentByEmail(@RequestParam String email) {
        Student student = studentService.fetchStudentByEmail(email);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getStudentForAllName(
            @PathVariable String name
    ) {
        List<Student> studentList = studentService.fetchAll(name);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Student>> getStudentAsPage() {
        return ResponseEntity.ok(studentService.fetchAllUsingPagination());
    }
}


