package com.example.employee_management.service;

import com.example.employee_management.dto.EmployeeRequestDto;
import com.example.employee_management.dto.EmployeeResponseDto;
import com.example.employee_management.exception.DepartmentNotFoundException;
import com.example.employee_management.exception.EmployeeNotFoundException;
import com.example.employee_management.model.Department;
import com.example.employee_management.model.EmployeeDocument;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeService.class);
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
        logger.info("Fetching employee with ID: {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee with ID " + id + " not found.")
                );
//        logger.info("Employee retrieved successfully with ID: {}", employee.getId());

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
        logger.info("Fetching all employees.");


        List<Employee> employees = employeeRepository.findAll();
        logger.info("Retrieved {} employees from the database.", employees.size());

        List<EmployeeResponseDto> response = new ArrayList<>();

        for (Employee emp : employees) {
            response.add(mapToResponseDto(emp));
        }

        return response;
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        logger.info("Creating employee with name: {}", employeeRequestDto.getName());
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
        logger.info(
                "Employee '{}' created successfully with ID: {}",
                savedEmployee.getName(),
                savedEmployee.getId()
        );
        return mapToResponseDto(savedEmployee);
    }

    public EmployeeResponseDto updateEmployee(Integer id, EmployeeRequestDto employeeRequestDto) {
        logger.info("Updating employee with id:{}",id);

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

        logger.info("Employee with id '{}' updated successfully ",updatedEmployee.getId());

        return mapToResponseDto(updatedEmployee);
    }

    public void deleteEmployee(Integer id) {
        logger.info("Deleting Employee with ID:{}",id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + id + " not found."));

        employeeRepository.delete(employee);
        logger.info("Employee with Id '{}' deleted successfully",id);

    }

    public void testLazyLoading(Integer id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        System.out.println(employee.getName());

        // Uncomment later
         System.out.println(employee.getDepartment().getDepartmentName());
    }

    public void testJoinFetch() {

        List<Employee> employees = employeeRepository.findAllWithDepartment();

        for (Employee employee : employees) {

            System.out.println(employee.getName());

            System.out.println(employee.getDepartment().getDepartmentName());

        }

    }
}