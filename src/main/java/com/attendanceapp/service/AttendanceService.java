package com.attendanceapp.service;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public void checkIn(AttendanceDTO attendanceDTO) {
        // Check-in logic
    }

    public void checkOut(AttendanceDTO attendanceDTO) {
        // Check-out logic
    }

    public void registerAttendanceFromQRCode(String data) {
        // Parse the data from QR code, which can be JSON or delimited string
        String[] parts = data.split(",");
        String funcionarioId = parts[0];
        Timestamp horarioEntrada = Timestamp.valueOf(parts[1]);
        Timestamp horarioSaida = Timestamp.valueOf(parts[2]);

        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setFuncionarioId(funcionarioId);
        attendanceDTO.setHorarioEntrada(horarioEntrada);
        attendanceDTO.setHorarioSaida(horarioSaida);

        // Check if entry or exit based on business logic
        // Example: if horarioSaida is null or empty, it's a check-in, otherwise, it's a
        // check-out
        if (horarioSaida == null) {
            checkIn(attendanceDTO);
        } else {
            checkOut(attendanceDTO);
        }
    }
}