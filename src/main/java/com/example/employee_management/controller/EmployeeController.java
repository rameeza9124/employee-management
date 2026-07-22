package com.example.employee_management.controller;
import java.util.List;

import com.example.employee_management.dto.EmployeeRequestDto;
import com.example.employee_management.dto.EmployeeResponseDto;
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @RequestBody EmployeeRequestDto requestDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable int id,
                                                              @RequestBody EmployeeRequestDto requestDto){
        EmployeeResponseDto response = employeeService.updateEmployee(id, requestDto);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        boolean response = employeeService.deleteEmployee(id);
        if (response==false){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.noContent().build();
    }

}
