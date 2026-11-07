package com.learning.jpaPracticeProject.service;

import com.learning.jpaPracticeProject.dto.request.ProfileRequestDTO;
import com.learning.jpaPracticeProject.dto.request.StudentRequestDTO;
import com.learning.jpaPracticeProject.dto.response.*;
import com.learning.jpaPracticeProject.model.Department;
import com.learning.jpaPracticeProject.model.Profile;
import com.learning.jpaPracticeProject.model.Student;
import com.learning.jpaPracticeProject.repository.DepartmentRepository;
import com.learning.jpaPracticeProject.repository.StudentRepository;
//import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository
    ) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE STUDENT
    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO studentReq) {
        Student student = mapToStudent(studentReq);
        student.getDepartment().getStudentList().add(student);
        Student savedStudent = studentRepository.save(student);
        return mapToStudentResponse(savedStudent);
    }

    // GET A STUDENT
    @Transactional(readOnly = true)
    public StudentResponseDTO getStudent(Long id) {
        Student student = studentRepository.find(id);
        if(student == null) {
            throw new RuntimeException("Student not found for id: " + id);
        }
        return mapToStudentResponse(student);
    }

    // GET ALL STUDENTS
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> getAllStudents() {
        List<StudentResponseDTO> studentResponseList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for(Student student : studentList) {
            studentResponseList.add(mapToStudentResponse(student));
        }
        return studentResponseList;
    }

    // UPDATE STUDENT
    @Transactional
    public StudentResponseDTO updateStudent(StudentRequestDTO studentReq, Long id) {
        Student student = studentRepository.find(id);
        if(student == null) {
            throw new RuntimeException("Student not found for id: " + id);
        }
        Profile profile = mapToProfile(studentReq.getProfile());
        Department oldDepartment = student.getDepartment();
        Department department = departmentRepository.find(studentReq.getDepartmentId());
        if(department == null) {
            throw new RuntimeException
                    ("Department not found for id: " + studentReq.getDepartmentId());
        }
        student.setProfile(null);
        entityManager.flush();
        if(oldDepartment != null) {
            oldDepartment.getStudentList().remove(student);
        }
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());
        student.setProfile(profile);
        student.setDepartment(department);
        department.getStudentList().add(student);
        return mapToStudentResponse(student);
    }

    // DELETE STUDENT
    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.find(id);
        if(student == null) {
            throw new RuntimeException("Student not found for id: " + id);
        }
        studentRepository.remove(student);
    }

    // MAPPING METHODS

    // request dto's mappings
    private Student mapToStudent(StudentRequestDTO studentReq) {
        Student student = new Student();
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());
        student.setProfile(mapToProfile(studentReq.getProfile()));
        Department department = departmentRepository
                .find(studentReq.getDepartmentId());
        if(department == null) {
            throw new RuntimeException
                    ("Department not found for id: " + studentReq.getDepartmentId());
        }
        student.setDepartment(department);
        return student;
    }
    private Profile mapToProfile(ProfileRequestDTO profileReq) {
        Profile profile = new Profile();
        profile.setPhoneNumber(profileReq.getPhoneNumber());
        profile.setAddress(profileReq.getAddress());
        profile.setBio(profileReq.getBio());
        return profile;
    }

    // response dto's mappings
    private ProfileResponseDTO mapToProfileResponse(Profile profile) {
        ProfileResponseDTO response = new ProfileResponseDTO();
        response.setId(profile.getId());
        response.setPhoneNumber(profile.getPhoneNumber());
        response.setAddress(profile.getAddress());
        response.setBio(profile.getBio());
        return response;
    }
    private DepartmentResponseDTO mapToDepartmentResponse(Department department) {
        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(department.getId());
        response.setName(department.getName());
        response.setCode(department.getCode());
        response.setDescription(department.getDescription());
        return response;
    }
    private StudentResponseDTO mapToStudentResponse(Student student) {
        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setAge(student.getAge());
        response.setProfile(
                student.getProfile() != null
                ? mapToProfileResponse(student.getProfile()) : null
        );
        response.setDepartment(
                student.getDepartment() != null
                ? mapToDepartmentResponse(student.getDepartment()) : null
        );
        return response;
    }
}

