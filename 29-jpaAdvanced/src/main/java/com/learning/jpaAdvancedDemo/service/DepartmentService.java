package com.learning.jpaAdvancedDemo.service;

import com.learning.jpaAdvancedDemo.model.Department;
import com.learning.jpaAdvancedDemo.model.Student;
import com.learning.jpaAdvancedDemo.repository.DepartmentRepository;
import com.learning.jpaAdvancedDemo.repository.StudentRepository;
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
        Student s1 = new Student();
        s1.setName("Alice");
        s1.setDepartment(department);

        Student s2 = new Student();
        s2.setName("Bob");
        s2.setDepartment(department);

        Student s3 = new Student();
        s3.setName("Charles");
        s3.setDepartment(department);

        Student s4 = new Student();
        s4.setName("Denver");
        s4.setDepartment(department);

//        department.getStudents().addAll(List.of(s1, s2, s3, s4));
//        departmentRepository.save(department);
//        studentRepository.save(s1);
//        studentRepository.save(s2);
//        studentRepository.save(s3);
//        studentRepository.save(s4);
    }

    @Transactional
    public void removeDepartment(Long id) {
        Department department = departmentRepository.find(id);
        departmentRepository.removeDepartment(department);
    }
}
