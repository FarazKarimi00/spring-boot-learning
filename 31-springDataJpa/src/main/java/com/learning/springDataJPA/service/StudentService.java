package com.learning.springDataJPA.service;

import com.learning.springDataJPA.entity.Student;
import com.learning.springDataJPA.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id) {
        Optional<Student> student =  studentRepository.findById(id);
        return student.get();
    }

    public List<Student> fetchAll(String name) {
//        Sort sort = Sort.by("age");
//        Sort sort = Sort.by("age").descending();
//        Sort sort = Sort.by(Sort.Direction.ASC, "age");
        Sort sort = Sort.by("name").ascending()
                .and(Sort.by("age").ascending());
        List<Student> studentList = studentRepository.findByName(name, sort);
        for(Student s : studentList) {
            System.out.println(s);
        }
        return studentList;
    }

    public void updateStudent(Student studentReq, Long id) throws Exception {
        Optional<Student> studentRes = studentRepository.findById(id);
        if(studentRes.isEmpty()) {
            throw new Exception("Student not found for id: " + id);
        }
        Student student = studentRes.get();
        student.setAge(studentReq.getAge());
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
    }

    public Student fetchStudentByEmail(String email) {
        return studentRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Student not found for email: " + email)
        );
    }

    public Page<Student> fetchAllUsingPagination() {
//        Sort sort = Sort.by("age");
//        Pageable pageable = PageRequest.of(0, 2);
        Pageable pageable = PageRequest.of(1, 2);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        for(Student student : studentPage.getContent()) {
            System.out.println(student);
        }
        return studentPage;
    }
}
