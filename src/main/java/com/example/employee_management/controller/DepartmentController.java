package com.example.employee_management.controller;

import com.example.employee_management.dto.DepartmentRequestDto;
import com.example.employee_management.dto.DepartmentResponseDto;
import com.example.employee_management.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public ResponseEntity<DepartmentResponseDto> createDepartment(
            @Valid @RequestBody DepartmentRequestDto departmentRequestDto) {

        DepartmentResponseDto departmentResponseDto =
                departmentService.createDepartment(departmentRequestDto);

        return new ResponseEntity<>(departmentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {

        return ResponseEntity.ok(
                departmentService.getAllDepartments()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getDepartmentById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                departmentService.getDepartmentById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(
            @PathVariable Integer id,
            @Valid @RequestBody DepartmentRequestDto departmentRequestDto) {

        return ResponseEntity.ok(
                departmentService.updateDepartment(id, departmentRequestDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(
            @PathVariable Integer id) {

        departmentService.deleteDepartment(id);

        return ResponseEntity.noContent().build();
    }
}

