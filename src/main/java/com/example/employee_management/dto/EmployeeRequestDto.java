package com.example.employee_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDto {

    @NotBlank(message= "Employee name is requires")
    @Size(min=3, max= 50, message= "Name must be Between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Department name is required")
    @Size(min=2, max=30, message= "department size must be between 2 to 30 characters")
    private String department;

    @Positive(message= "Salary must be greater than zero")
    private Double salary;

    public EmployeeRequestDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeRequestDto(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}


