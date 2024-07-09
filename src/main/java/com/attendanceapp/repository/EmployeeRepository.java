// EmployeeRepository.java
package com.attendanceapp.repository;

import com.attendanceapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}