package com.example.employee_management.dto;

public class EmployeeRequestDto {
    private String name;
    private String department;
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


