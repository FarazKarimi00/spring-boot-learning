package com.learning.hibernateFundamentals.service;

import com.learning.hibernateFundamentals.model.Student;
import com.learning.hibernateFundamentals.repository.StudentRepository;
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
        studentRepository.saveStudent(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq, Long id) {
        Student student = studentRepository.findById(id);
        if(student == null) {
            throw new RuntimeException("Student not found");
        }
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());
        student.setAddresses(studentReq.getAddresses());
        student.setSkills(studentReq.getSkills());
//        student.setSkills(studentReq.getSkills());
//        student.setCurrentAddress(studentReq.getCurrentAddress());
//        student.setPermanentAddress(studentReq.getPermanentAddress());
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);
        if(student == null) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.remove(student);
    }
}


