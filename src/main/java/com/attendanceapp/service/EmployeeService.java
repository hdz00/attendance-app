// EmployeeService.java
package com.attendanceapp.service;

import com.attendanceapp.dto.EmployeeDTO;
import com.attendanceapp.model.Employee;
import com.attendanceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setNome(employeeDTO.getNome());
        employee.setApelido(employeeDTO.getApelido());
        employee.setDataContratacao(employeeDTO.getDataContratacao());
        employee.setCargaHoraria(employeeDTO.getCargaHoraria());
        employee = employeeRepository.save(employee);
        employeeDTO.setId(employee.getId());
        return employeeDTO;
    }
}