package com.faraz.interceptorDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @PostMapping
    public ResponseEntity<String> createStudent() {
        System.out.println("Controller called");
        return ResponseEntity.ok("Student created");
    }
}
