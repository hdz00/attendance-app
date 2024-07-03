package com.attendanceapp.service;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.model.Employee;
import com.attendanceapp.repository.AttendanceRepository;
import com.attendanceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void registerAttendance(AttendanceDTO attendanceDTO) {
        Optional<Employee> employeeOpt = employeeRepository.findById(Long.parseLong(attendanceDTO.getFuncionarioId()));
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();

            Attendance attendance = new Attendance();
            attendance.setFuncionarioId(attendanceDTO.getFuncionarioId());
            attendance.setData(attendanceDTO.getData());
            attendance.setNome(employee.getNome());
            attendance.setHorarioEntrada(attendanceDTO.getHorarioEntrada());
            attendance.setHorarioSaida(attendanceDTO.getHorarioSaida());

            if (attendance.getHorarioEntrada() != null && attendance.getHorarioSaida() != null) {
                attendance.setTempoTrabalho(Duration.between(attendance.getHorarioEntrada(), attendance.getHorarioSaida()));
            }

            attendanceRepository.save(attendance);
        } else {
            throw new IllegalArgumentException("Employee not found with id: " + attendanceDTO.getFuncionarioId());
        }
    }

    public AttendanceDTO getAttendance(Long id) {
        Optional<Attendance> attendanceOpt = attendanceRepository.findById(id);
        if (attendanceOpt.isPresent()) {
            Attendance attendance = attendanceOpt.get();
            return new AttendanceDTO(attendance.getId(), attendance.getFuncionarioId(), attendance.getNome(),
                                      attendance.getHorarioEntrada(), attendance.getHorarioSaida());
        } else {
            throw new IllegalArgumentException("Attendance not found with id: " + id);
        }
    }

    public void registerAttendanceFromQRCode(String qrCodeData) {
        // Implementation to parse QR code data and register attendance
        // This method would need to be implemented based on the QR code data format and logic
        // For demonstration purposes, let's assume it sets current time as check-in time
        Optional<Employee> employeeOpt = employeeRepository.findById(Long.parseLong(qrCodeData));
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();

            Attendance attendance = new Attendance();
            attendance.setFuncionarioId(qrCodeData);
            attendance.setData(LocalDateTime.now().toLocalDate());
            attendance.setNome(employee.getNome());
            attendance.setHorarioEntrada(LocalDateTime.now());

            attendanceRepository.save(attendance);
        } else {
            throw new IllegalArgumentException("Employee not found with id: " + qrCodeData);
        }
    }
}