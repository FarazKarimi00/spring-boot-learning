package com.learning.jpaPracticeProject.service;

import com.learning.jpaPracticeProject.dto.request.DepartmentRequestDTO;
import com.learning.jpaPracticeProject.dto.response.DepartmentDetailedResponseDTO;
import com.learning.jpaPracticeProject.dto.response.DepartmentResponseDTO;
import com.learning.jpaPracticeProject.dto.response.StudentSummaryResponseDTO;
import com.learning.jpaPracticeProject.model.Department;
import com.learning.jpaPracticeProject.model.Student;
import com.learning.jpaPracticeProject.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // CREATE DEPARTMENT
    @Transactional
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentReq) {
        Department department = mapToDepartment(departmentReq);
        departmentRepository.save(department);
        return mapToDepartmentResponse(department);
    }

    // GET DEPARTMENT
    @Transactional(readOnly = true)
    public DepartmentDetailedResponseDTO getDepartment(Long id) {
        Department department = departmentRepository.find(id);
        if(department == null) {
            throw new RuntimeException("Department not found for id: " + id);
        }
        return mapToDetailedDepartmentResponse(department);
    }

    // GET ALL DEPARTMENTS
    @Transactional(readOnly = true)
    public List<DepartmentDetailedResponseDTO> getAllDepartments() {
        List<DepartmentDetailedResponseDTO> responseList =
                new ArrayList<>();
        List<Department> departmentList = departmentRepository.findAll();
        for(Department department : departmentList) {
            responseList.add(mapToDetailedDepartmentResponse(department));
        }
        return responseList;
    }

    // UPDATE DEPARTMENT
    @Transactional
    public DepartmentResponseDTO updateDepartment(DepartmentRequestDTO departmentReq, Long id) {
        Department department = departmentRepository.find(id);
        if(department == null) {
            throw new RuntimeException("Department not found for id: " + id);
        }
        department.setName(departmentReq.getName());
        department.setCode(departmentReq.getCode());
        department.setDescription(departmentReq.getDescription());
        return mapToDepartmentResponse(department);
    }

    // DELETE DEPARTMENT
    @Transactional
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.find(id);
        if(department == null) {
            throw new RuntimeException("Department not found for id: " + id);
        }
        if(!department.getStudentList().isEmpty()) {
            throw new RuntimeException("Department contains student, can't be deleted");
        }
        departmentRepository.remove(department);
    }

    // MAPPING METHODS
    // request dto's
    private Department mapToDepartment(DepartmentRequestDTO departmentReq) {
        Department department = new Department();
        department.setName(departmentReq.getName());
        department.setCode(departmentReq.getCode());
        department.setDescription(departmentReq.getDescription());
        return department;
    }

    // response dto's
    private DepartmentResponseDTO mapToDepartmentResponse(Department department) {
        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(department.getId());
        response.setName(department.getName());
        response.setCode(department.getCode());
        response.setDescription(department.getDescription());
        return response;
    }
    private StudentSummaryResponseDTO mapToStudentSummaryResponse(Student student) {
        StudentSummaryResponseDTO response = new StudentSummaryResponseDTO();
        response.setId(student.getId());
        response.setName(student.getName());
        return response;
    }
    private DepartmentDetailedResponseDTO mapToDetailedDepartmentResponse(Department department) {
        DepartmentDetailedResponseDTO response = new DepartmentDetailedResponseDTO();
        response.setId(department.getId());
        response.setName(department.getName());
        response.setCode(department.getCode());
        response.setDescription(department.getDescription());
        List<StudentSummaryResponseDTO> studentList =
                new ArrayList<>();
        List<Student> list = department.getStudentList();
        for(Student student : list) {
            studentList.add(mapToStudentSummaryResponse(student));
        }
        response.setStudents(studentList);
        return response;
    }
}
