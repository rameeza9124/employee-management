package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeRequestDto;
import com.example.employee_management.dto.EmployeeResponseDto;
import org.springframework.stereotype.Service;
import com.example.employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    public EmployeeService(){
        employees.add(
                new Employee(
                        1,
                        "Rahul",
                        "IT",
                        50000
                )
        );
    }
    public List<Employee>getEmployee(){
        return employees;
    }



//    public List<Employee> getEmployees(){
//        List<Employee> employees = new ArrayList<>();
//        Employee emp1 = new Employee(
//                1,
//                "Rahul",
//                "IT",
//                50000
//        );
//        employees.add(emp1);
//        return employees;
//    }
    public Employee getEmployeeById(Long id){
        List<Employee>employees = getEmployee();
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

        List<Employee> employees = getEmployee();

        List<EmployeeResponseDto> response = new ArrayList<>();

        for (Employee emp : employees) {
            response.add(maptoResponseDto(emp));
        }

        return response;
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto){
        Employee employee = new Employee();
        employee.setName(requestDto.getName());
        employee.setDepartment(requestDto.getDepartment());
        employee.setSalary(requestDto.getSalary());
        employee.setId((int) (employees.size() + 1));
        employees.add(employee);
        return maptoResponseDto(employee);
    }



}
