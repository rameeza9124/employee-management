package com.example.employee_management.controller;
import java.util.List;

import com.example.employee_management.dto.EmployeeResponseDto;
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping
    public List<EmployeeResponseDto> getEmployees(){
        return employeeService.getEmployeeResponses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }
//    @GetMapping
//    public String getemployees(){
//        return "All Employees";
//    }
//
//    @GetMapping("/about")
//    public String about(){
//        return "Employee Module";
//    }
//
//    @PostMapping
//    public String addEmployee(){
//        return "Employee Added";
//    }
//
//    @GetMapping("/{id}")
//    public String getemployeeid(@PathVariable int id){
//        return "Employee Id:" +id;
//    }
//
//    @GetMapping("/{department}/{id}")
//    public String employee(@PathVariable String department, @PathVariable int id){
//        return department +" "+id;
//    }
//
//    @GetMapping("/search")
//    public String searchemployee(@RequestParam String department, @RequestParam String city){
//        return department + " " +city;
//    }
//
//    @PostMapping("/create")
//    public Employee createemployee(@RequestBody Employee employee ){
//        return employee;
//    }
}
