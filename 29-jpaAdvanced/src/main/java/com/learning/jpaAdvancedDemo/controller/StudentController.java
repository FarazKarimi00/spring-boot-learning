package com.learning.jpaAdvancedDemo.controller;

import com.learning.jpaAdvancedDemo.model.Student;
import com.learning.jpaAdvancedDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/withDepartmentId")
    public ResponseEntity<String> createStudent(
            @RequestBody Student student,
            @RequestParam Long deptId
    ) {
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("Student created");
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }
}
