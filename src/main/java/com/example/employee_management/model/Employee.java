package com.example.employee_management.model;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="employee_name")
    private String name;
    private String department;
    private double salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="document_id")
    private EmployeeDocument employeeDocument;

    public Employee(){}

    public Employee(Integer id, String name, String department, double salary, EmployeeDocument employeeDocument) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.employeeDocument = employeeDocument;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeeDocument getEmployeeDocument() {
        return employeeDocument;
    }

    public void setEmployeeDocument(EmployeeDocument employeeDocument) {
        this.employeeDocument = employeeDocument;
    }


}
