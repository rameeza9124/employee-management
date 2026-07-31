package com.example.employee_management.service;

import com.example.employee_management.dto.DepartmentRequestDto;
import com.example.employee_management.dto.DepartmentResponseDto;
import com.example.employee_management.model.Department;
import com.example.employee_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto){
        Department department = new Department();
        department.setDepartmentName(departmentRequestDto.getDepartmentName());
        Department savedDepartment = departmentRepository.save(department);

        return new DepartmentResponseDto(
                savedDepartment.getDepartmentId(),
                savedDepartment.getDepartmentName()
        );
    }

    public List<DepartmentResponseDto> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(department -> new DepartmentResponseDto(
                        department.getDepartmentId(),
                        department.getDepartmentName()
                ))
                .collect(Collectors.toList());
    }

    public DepartmentResponseDto getDepartmentById(Integer id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));

        return new DepartmentResponseDto(
                department.getDepartmentId(),
                department.getDepartmentName()
        );
    }

    public DepartmentResponseDto updateDepartment(Integer id,
                                                  DepartmentRequestDto requestDto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));

        department.setDepartmentName(requestDto.getDepartmentName());

        Department updatedDepartment = departmentRepository.save(department);

        return new DepartmentResponseDto(
                updatedDepartment.getDepartmentId(),
                updatedDepartment.getDepartmentName()
        );
    }

    public void deleteDepartment(Integer id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));

        departmentRepository.delete(department);
    }
}
