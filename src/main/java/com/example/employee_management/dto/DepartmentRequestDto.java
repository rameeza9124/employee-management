package com.example.employee_management.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDto {

    @NotBlank(message = "Department name is required")
    private String departmentName;

    public DepartmentRequestDto() {
    }

    public DepartmentRequestDto(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
