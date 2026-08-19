package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("""
        SELECT e
        FROM Employee e
        JOIN FETCH e.department
       """)
    List<Employee> findAllWithDepartment();
}
