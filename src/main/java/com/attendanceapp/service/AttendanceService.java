//AttendanceService
package com.attendanceapp.service;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void checkIn(AttendanceDTO attendanceDTO) {
        Attendance attendance = new Attendance();
        attendance.setFuncionarioId(attendanceDTO.getFuncionarioId());
        attendance.setHorarioEntrada(attendanceDTO.getHorarioEntrada());
        attendance.setHorarioSaida(attendanceDTO.getHorarioSaida());

        // Save the attendance record
        attendanceRepository.save(attendance);
    }
}