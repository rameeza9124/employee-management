package com.example.employee_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDto {

    @NotBlank(message= "Employee name is required")
    @Size(min=3, max= 50, message= "Name must be Between 3 and 50 characters")
    private String name;

    @NotNull(message = "DepartmentId is required")
    private Integer departmentId;

    @Positive(message= "Salary must be greater than zero")
    private Double salary;

    @NotBlank(message= "aadharNumber is required")
    @Size(min=12, max=12)
    private String aadharNumber;

    @NotBlank
    private String panNumber;

    @NotBlank
    private String passportNumber;

    @NotBlank
    private String drivingLicenseNumber;

    public EmployeeRequestDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public EmployeeRequestDto(String name, Integer departmentId, Double salary, String aadharNumber, String panNumber, String passportNumber, String drivingLicenseNumber) {
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.passportNumber = passportNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}


