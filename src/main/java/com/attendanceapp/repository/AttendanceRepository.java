package com.attendanceapp.repository;

import com.attendanceapp.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByFuncionarioId(String funcionarioId);
    List<Attendance> findByData(LocalDate data);
    List<Attendance> findByFuncionarioIdAndData(String funcionarioId, LocalDate data);
}