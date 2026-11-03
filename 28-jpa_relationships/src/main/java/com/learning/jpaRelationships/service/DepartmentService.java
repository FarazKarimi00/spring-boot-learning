package com.learning.jpaRelationships.service;

import com.learning.jpaRelationships.model.Department;
import com.learning.jpaRelationships.model.Student;
import com.learning.jpaRelationships.repository.DepartmentRepository;
import com.learning.jpaRelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;

    public DepartmentService(
            DepartmentRepository departmentRepository,
            StudentRepository studentRepository
    ) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName) {
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);
        department.getStudents().add(student);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
