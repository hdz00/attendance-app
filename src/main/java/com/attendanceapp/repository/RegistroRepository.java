//RegistroRepository.java
package com.attendanceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendanceapp.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}