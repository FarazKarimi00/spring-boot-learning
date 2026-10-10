package com.exceptionHandling.exceptionHandlingPractice.service;

import com.exceptionHandling.exceptionHandlingPractice.dto.*;
import com.exceptionHandling.exceptionHandlingPractice.entity.Student;
import com.exceptionHandling.exceptionHandlingPractice.exception.DuplicateResourceException;
import com.exceptionHandling.exceptionHandlingPractice.exception.ResourceNotFoundException;
import com.exceptionHandling.exceptionHandlingPractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public CreateStudentResponseDTO createStudent
    (CreateStudentRequestDTO studentRequestDTO) {

        Student student = mapToEntity(studentRequestDTO);

        if(emailExists(student.getEmail())) {
            throw new DuplicateResourceException
                    ("Student with email: " + student.getEmail() + " already exists");
        }

        Student studentResp = studentRepository.save(student);

        return mapToCreateStudentResponseDTO(studentResp);

    }

    // GET
    public StudentResponseDTO getStudent(Long id) {
        // Bad approach
//        Student student = studentRepository.findByIdAndDeletedIsFalse(id)
//                .orElse(null);
//        return mapToStudentResponseDTO(student);

        // Better approach
        Student student = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException
                                ("Student with id " + id + " not found"));
        return mapToStudentResponseDTO(student);

    }

    // GET ALL
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();
        for(Student student : studentList) {
            studentResponseDTOList.add(mapToStudentResponseDTO(student));
        }
        return studentResponseDTOList;
    }

    // UPDATE
    public UpdateStudentResponseDTO updateStudent
    (Long id, UpdateStudentRequestDTO studentReq) {

        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Student with id " + id + " not found"));

        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(existingStudent);

        return mapToUpdateStudentResponseDTO(updatedStudent);
    }

    // Delete
    public void deleteStudent(Long id) {
        Student studentToDelete = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Student with id " + id + " not found"));

        studentRepository.delete(studentToDelete);
    }

    // SOFT DELETE
    public void deleteStudentSoftly(Long id){
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Student for id " + id + " not found"));

        existingStudent.setDeleted(true);
        existingStudent.setUpdatedAt(LocalDateTime.now());
        studentRepository.save(existingStudent);
    }


    // MAPPING METHODS

    private Student mapToEntity(CreateStudentRequestDTO requestDTO) {
        Student student = new Student();
        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        student.setEmail(requestDTO.getEmail());
        student.setRollNo(requestDTO.getRollNo());
        student.setSubject(requestDTO.getSubject());
        LocalDateTime now = LocalDateTime.now();
        student.setCreatedAt(now);
        student.setUpdatedAt(now);
        student.setDeleted(false);
        return student;
    }

    private CreateStudentResponseDTO mapToCreateStudentResponseDTO(Student student) {
        CreateStudentResponseDTO responseDTO = new CreateStudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        responseDTO.setMessage("Student created successfully");
        return responseDTO;
    }

    private StudentResponseDTO mapToStudentResponseDTO(Student student) {
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        return responseDTO;
    }

    private UpdateStudentResponseDTO mapToUpdateStudentResponseDTO(Student student) {
        UpdateStudentResponseDTO responseDTO = new UpdateStudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        responseDTO.setMessage("Student updated Successfully");
        return responseDTO;
    }

    //

    private boolean emailExists(String email) {
        return studentRepository.existsByEmail(email);
    }
}




