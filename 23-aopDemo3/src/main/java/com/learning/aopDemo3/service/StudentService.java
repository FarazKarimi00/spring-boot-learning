package com.learning.aopDemo3.service;

import com.learning.aopDemo3.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface{

    @Override
    public Student createStudent(Student student) {
        System.out.println("Student created");
        return student;
    }

    @Override
    public String getStudent(String s) {
        System.out.println(s);
        return s;
    }

    public int dummyMethod() {
        return 0;
    }
}
