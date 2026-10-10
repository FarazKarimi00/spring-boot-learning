package com.learning.filterDemo2.service;

import com.learning.filterDemo2.dto.Student;
import com.learning.filterDemo2.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDTO createStudent(Student student) {
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setName(student.getName());
        responseDTO.setMessage("Student is saved successfully");
        return responseDTO;
    }
}

