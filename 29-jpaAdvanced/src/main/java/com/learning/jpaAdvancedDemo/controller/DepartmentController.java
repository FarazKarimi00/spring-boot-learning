package com.learning.jpaAdvancedDemo.controller;

import com.learning.jpaAdvancedDemo.model.Department;
import com.learning.jpaAdvancedDemo.service.DepartmentService;
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
            @RequestBody Department department) {
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Department created");
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long deptId) {
        departmentService.removeDepartment(deptId);
        return ResponseEntity.ok("Department deleted");
    }
}
