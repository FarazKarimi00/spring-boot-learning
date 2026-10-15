package com.learning.aopIntroductionDemo.repository;

import com.learning.aopIntroductionDemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public void save(Student student) {
        System.out.println("Student saved");
    }
}
