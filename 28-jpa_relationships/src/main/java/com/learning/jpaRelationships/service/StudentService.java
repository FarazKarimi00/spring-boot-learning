package com.learning.jpaRelationships.service;

import com.learning.jpaRelationships.model.Department;
import com.learning.jpaRelationships.model.Student;
import com.learning.jpaRelationships.repository.DepartmentRepository;
import com.learning.jpaRelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;

    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository
    ) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long dept_id) {
        Department department =
                departmentRepository.getDepartmentById(dept_id);

        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
//        departmentRepository.save(department);
//        No need to do bcz it's in the persistence context and automatically
//        updated/saved as methods end (flush and COMMIT)
    }

    @Transactional
    public void createStudent(Student student, String dept_name) {
        Department department = new Department();
        department.setName(dept_name);
        student.setDepartment(department);
        department.getStudents().add(student);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
