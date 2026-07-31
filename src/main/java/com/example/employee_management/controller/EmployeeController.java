package com.example.employee_management.controller;
import java.util.List;

import com.example.employee_management.dto.EmployeeRequestDto;
import com.example.employee_management.dto.EmployeeResponseDto;
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
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
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Integer id) {

        EmployeeResponseDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody EmployeeRequestDto requestDto
    ) {
        System.out.println("Controller method executed!");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable Integer id,
                                                              @RequestBody EmployeeRequestDto requestDto){
        EmployeeResponseDto response = employeeService.updateEmployee(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
