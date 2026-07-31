package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeRequestDto;
import com.example.employee_management.dto.EmployeeResponseDto;
import com.example.employee_management.exception.DepartmentNotFoundException;
import com.example.employee_management.exception.EmployeeNotFoundException;
import com.example.employee_management.model.Department;
import com.example.employee_management.model.EmployeeDocument;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.example.employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeResponseDto getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with ID " + id + " not found."));
        return mapToResponseDto(employee);
    }

    private EmployeeResponseDto mapToResponseDto(Employee employee) {
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getDepartment().getDepartmentId(),
                employee.getDepartment().getDepartmentName(),
                employee.getSalary(),
                employee.getEmployeeDocument().getAadharNumber(),
                employee.getEmployeeDocument().getPanNumber(),
                employee.getEmployeeDocument().getPassportNumber(),
                employee.getEmployeeDocument().getDrivingLicenseNumber()

        );
    }

    public List<EmployeeResponseDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponseDto> response = new ArrayList<>();

        for (Employee emp : employees) {
            response.add(mapToResponseDto(emp));
        }

        return response;
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        EmployeeDocument employeeDocument= new EmployeeDocument();
        employee.setName(employeeRequestDto.getName());

        Department department =
                departmentRepository.findById(employeeRequestDto.getDepartmentId())
                        .orElseThrow(() ->
                                new DepartmentNotFoundException(
                                        "Department with ID "
                                                + employeeRequestDto.getDepartmentId()
                                                + " not found."));

        employee.setDepartment(department);
        employee.setSalary(employeeRequestDto.getSalary());
        employeeDocument.setAadharNumber(employeeRequestDto.getAadharNumber());
        employeeDocument.setPanNumber(employeeRequestDto.getPanNumber());
        employeeDocument.setPassportNumber(employeeRequestDto.getPassportNumber());
        employeeDocument.setDrivingLicenseNumber(employeeRequestDto.getDrivingLicenseNumber());

        employee.setEmployeeDocument(employeeDocument);

        Employee savedEmployee = employeeRepository.save(employee);
        return mapToResponseDto(savedEmployee);
    }

    public EmployeeResponseDto updateEmployee(Integer id, EmployeeRequestDto employeeRequestDto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with ID " + id + " not found."));

        employee.setName(employeeRequestDto.getName());

        Department department = departmentRepository.findById(employeeRequestDto.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department with ID "
                                + employeeRequestDto.getDepartmentId()
                                + " not found."));
        employee.setDepartment(department);
        employee.setSalary(employeeRequestDto.getSalary());

        EmployeeDocument employeeDocument =employee.getEmployeeDocument();
        employeeDocument.setAadharNumber(employeeRequestDto.getAadharNumber());
        employeeDocument.setPanNumber(employeeRequestDto.getPanNumber());
        employeeDocument.setPassportNumber(employeeRequestDto.getPassportNumber());
        employeeDocument.setDrivingLicenseNumber(employeeRequestDto.getDrivingLicenseNumber());
        Employee updatedEmployee = employeeRepository.save(employee);

        return mapToResponseDto(updatedEmployee);
    }

    public void deleteEmployee(Integer id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + id + " not found."));

        employeeRepository.delete(employee);
    }
}