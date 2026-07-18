package com.example.employee_management.service;

import org.springframework.stereotype.Service;
import com.example.employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(
                1,
                "Rahul",
                "IT",
                50000
        );
        employees.add(emp1);
        return employees;
    }



}
