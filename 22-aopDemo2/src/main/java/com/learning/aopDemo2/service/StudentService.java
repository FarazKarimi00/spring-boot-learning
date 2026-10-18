package com.learning.aopDemo2.service;

import com.learning.aopDemo2.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student) {
        System.out.println("Student saved(main service method called)");
//        try {
//            throw new RuntimeException("Some error occurred");
//        } catch (RuntimeException e) {
//            return "Student saved";
//        }
//        throw new RuntimeException("Some error occurred");
        return student;
    }

    public String dummyMethod(String s) {
        System.out.println("Dummy method called");
        return s;
    }
}

