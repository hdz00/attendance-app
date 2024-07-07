package com.attendanceapp.repository;

import com.attendanceapp.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    Optional<Attendance> findByFuncionarioIdAndData(String funcionarioId, Date data);
}