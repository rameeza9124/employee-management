package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeRequestDto;
import com.example.employee_management.dto.EmployeeResponseDto;
import com.example.employee_management.exception.EmployeeNotFoundException;
import com.example.employee_management.model.EmployeeDocument;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.example.employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    private EmployeeResponseDto mapToResponseDto(Employee employee) {
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getEmployeeDocument().getAadharNumber(),
                employee.getEmployeeDocument().getPanNumber(),
                employee.getEmployeeDocument().getPassportNumber(),
                employee.getEmployeeDocument().getDrivingLicenseNumber()
        );
    }

    public List<EmployeeResponseDto> getEmployeeResponses() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponseDto> response = new ArrayList<>();

        for (Employee emp : employees) {
            response.add(mapToResponseDto(emp));
        }

        return response;
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto) {
        Employee employee = new Employee();
        EmployeeDocument employeeDocument= new EmployeeDocument();
        employee.setName(requestDto.getName());
        employee.setDepartment(requestDto.getDepartment());
        employee.setSalary(requestDto.getSalary());
        employeeDocument.setAadharNumber(requestDto.getAadharNumber());
        employeeDocument.setPanNumber(requestDto.getPanNumber());
        employeeDocument.setPassportNumber(requestDto.getPassportNumber());
        employeeDocument.setDrivingLicenseNumber(requestDto.getDrivingLicenseNumber());

        employee.setEmployeeDocument(employeeDocument);

        Employee savedEmployee = employeeRepository.save(employee);
        return mapToResponseDto(savedEmployee);
    }

    public EmployeeResponseDto updateEmployee(int id, EmployeeRequestDto requestDto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with ID " + id + " not found."));

        employee.setName(requestDto.getName());
        employee.setDepartment(requestDto.getDepartment());
        employee.setSalary(requestDto.getSalary());

        EmployeeDocument employeeDocument =employee.getEmployeeDocument();
        employeeDocument.setAadharNumber(requestDto.getAadharNumber());
        employeeDocument.setPanNumber(requestDto.getPanNumber());
        employeeDocument.setPassportNumber(requestDto.getPassportNumber());
        employeeDocument.setDrivingLicenseNumber(requestDto.getDrivingLicenseNumber());
        Employee updatedEmployee = employeeRepository.save(employee);

        return mapToResponseDto(updatedEmployee);
    }

    public boolean deleteEmployee(int id) {

        if (!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);

        return true;
    }
}