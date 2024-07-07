package com.attendanceapp.service;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public void checkIn(AttendanceDTO attendanceDTO) {
        Optional<Attendance> existingAttendance = attendanceRepository.findByFuncionarioIdAndData(attendanceDTO.getFuncionarioId(), new Date());
        if (existingAttendance.isPresent()) {
            Attendance attendance = existingAttendance.get();
            attendance.setHorarioSaida(attendanceDTO.getHorarioSaida());
            attendance.setTempoTrabalho(Duration.between(attendance.getHorarioEntrada().toLocalDateTime(), attendanceDTO.getHorarioSaida().toLocalDateTime()));
            attendanceRepository.save(attendance);
        } else {
            Attendance attendance = new Attendance();
            attendance.setFuncionarioId(attendanceDTO.getFuncionarioId());
            attendance.setData(new Date());
            attendance.setNome(""); // fetch employee name logic
            attendance.setHorarioEntrada(attendanceDTO.getHorarioEntrada());
            attendanceRepository.save(attendance);
        }
    }
}