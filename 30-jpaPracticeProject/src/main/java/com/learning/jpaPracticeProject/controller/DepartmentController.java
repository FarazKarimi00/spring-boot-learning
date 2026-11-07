package com.learning.jpaPracticeProject.controller;

import com.learning.jpaPracticeProject.dto.request.DepartmentRequestDTO;
import com.learning.jpaPracticeProject.dto.response.DepartmentDetailedResponseDTO;
import com.learning.jpaPracticeProject.dto.response.DepartmentResponseDTO;
import com.learning.jpaPracticeProject.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentReq) {
        DepartmentResponseDTO response = departmentService.createDepartment(departmentReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDetailedResponseDTO> getDepartment(@PathVariable Long id) {
        DepartmentDetailedResponseDTO response = departmentService.getDepartment(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDetailedResponseDTO>> getAllDepartments() {
        List<DepartmentDetailedResponseDTO> departmentList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(
            @Valid @RequestBody DepartmentRequestDTO departmentReq,
            @PathVariable Long id
    ) {
        DepartmentResponseDTO response = departmentService.updateDepartment(departmentReq, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted");
    }
}
