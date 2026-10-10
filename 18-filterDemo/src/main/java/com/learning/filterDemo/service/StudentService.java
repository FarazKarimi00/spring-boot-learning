package com.learning.filterDemo.service;

import com.learning.filterDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student) {
        System.out.println("Student created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());

//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {}
    }
}
