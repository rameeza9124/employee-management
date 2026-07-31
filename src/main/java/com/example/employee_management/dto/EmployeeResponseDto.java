package com.example.employee_management.dto;

public class EmployeeResponseDto {
    private Integer id;
    private String name;
    private Integer departmentId;
    private String departmentName;
    private Double salary;
    private String aadharNumber;
    private String panNumber;
    private String passportNumber;
    private String drivingLicenseNumber;

    public EmployeeResponseDto() {
    }

    public EmployeeResponseDto(Integer id, String name, Integer departmentId, String departmentName, Double salary, String aadharNumber, String panNumber, String passportNumber, String drivingLicenseNumber) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.salary = salary;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.passportNumber = passportNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
}
