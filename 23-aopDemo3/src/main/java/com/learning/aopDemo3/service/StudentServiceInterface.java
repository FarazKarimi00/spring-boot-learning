package com.learning.aopDemo3.service;

import com.learning.aopDemo3.dto.Student;

public interface StudentServiceInterface {
    Student createStudent(Student student);
    String getStudent(String s);
}

