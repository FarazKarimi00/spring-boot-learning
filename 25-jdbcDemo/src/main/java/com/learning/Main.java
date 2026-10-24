package com.learning;

import com.learning.model.Student;
import com.learning.repository.StudentRepository;


public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.createStudent(new Student("pqr",
//                "pqr@gmail.com", 98));
//        studentRepository.updateStudent(new Student("xyz", "xyx@gmail.com", 25), 4L);
//        studentRepository.deleteStudent(3L);
//        studentRepository.getStudentById(4L);
        studentRepository.getAllStudents();
    }
}



