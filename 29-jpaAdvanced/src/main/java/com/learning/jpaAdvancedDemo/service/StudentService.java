package com.learning.jpaAdvancedDemo.service;

import com.learning.jpaAdvancedDemo.model.Department;
import com.learning.jpaAdvancedDemo.model.Profile;
import com.learning.jpaAdvancedDemo.model.Student;
import com.learning.jpaAdvancedDemo.repository.DepartmentRepository;
import com.learning.jpaAdvancedDemo.repository.ProfileRepository;
import com.learning.jpaAdvancedDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;
    ProfileRepository profileRepository;
    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository,
            ProfileRepository profileRepository
    ) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId) {

    }

    @Transactional
    public void createStudent(Student student) {
        Department department = new Department();
        department.setName("CSE");

        Profile profile = new Profile();
        profile.setBio("I am a backend engineer");

        student.setDepartment(department);
        student.setProfile(profile);

        departmentRepository.save(department);
        profileRepository.save(profile);
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        Student student = studentRepository.fetch(id);
        System.out.println("Lazily fetched Department");

        Department department = student.getDepartment();
        System.out.println("Lazily fetched department");

        Profile profile = student.getProfile();
        System.out.println("Lazily fetched profile");

        return student;
    }

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
