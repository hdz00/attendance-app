package com.attendanceapp.repository;

import com.attendanceapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNome(String nome);
    List<Employee> findByApelido(String apelido);
    List<Employee> findByCargaHoraria(Integer cargaHoraria);
}