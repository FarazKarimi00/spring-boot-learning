package com.learning.aopDemo4.service;

import com.learning.aopDemo4.annotation.TrackExecutionTime;
import com.learning.aopDemo4.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 1000,
            operation = "Saving student"
    )
    public Student createStudent(Student student) {
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Getting all student data"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        System.out.println(s);
        return s;
    }
}
