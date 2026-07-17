package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
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
