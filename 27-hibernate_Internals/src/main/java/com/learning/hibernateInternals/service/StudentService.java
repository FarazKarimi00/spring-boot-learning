package com.learning.hibernateInternals.service;

import com.learning.hibernateInternals.model.Student;
import com.learning.hibernateInternals.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq, Long id) {
        Student student = getStudentById(id);
        if(student == null) {
            throw new RuntimeException("Student not found");
        }

//        studentRepository.detach(student);
//        student = studentRepository.attachAgain(student);

        student.setName(studentReq.getName());
//        studentRepository.flush();

        student.setEmail(studentReq.getEmail());
//        studentRepository.flush();

        student.setAge(studentReq.getAge());
//        studentRepository.flush();

    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        if(student == null) {
            throw new RuntimeException("Student not found");
        }
    }
}


