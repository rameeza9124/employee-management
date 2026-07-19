package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeResponseDto;
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
    public Employee getEmployeeById(Long id){
        List<Employee>employees = getEmployees();
        for( Employee emp:employees){
            if(emp.getId()==(id)){
                return emp;
            }
        }
        return null;
    }

    private EmployeeResponseDto maptoResponseDto(Employee employee){
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    public List<EmployeeResponseDto> getEmployeeResponses() {

        List<Employee> employees = getEmployees();

        List<EmployeeResponseDto> response = new ArrayList<>();

        for (Employee emp : employees) {
            response.add(maptoResponseDto(emp));
        }

        return response;
    }


}
