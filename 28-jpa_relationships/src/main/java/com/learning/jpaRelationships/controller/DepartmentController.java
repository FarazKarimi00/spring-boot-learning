package com.learning.jpaRelationships.controller;

import com.learning.jpaRelationships.model.Department;
import com.learning.jpaRelationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department
    ) {
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Department created");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department,
            @RequestParam String student
    ) {
        departmentService.createDepartment(department, student);
        return ResponseEntity.ok("Department created");
    }
}
