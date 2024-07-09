//ReportService
package com.attendanceapp.service;

import com.attendanceapp.dto.EmployeeReportDTO;
import com.attendanceapp.dto.ManagerReportDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<EmployeeReportDTO> getEmployeeReport(Integer employeeId, LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendances = attendanceRepository.findByEmployeeIdAndDateRange(employeeId, startDate,
                endDate);
        return attendances.stream()
                .map(this::convertToEmployeeReportDTO)
                .collect(Collectors.toList());
    }

    public ManagerReportDTO getManagerReport(LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendances = attendanceRepository.findAllByDateBetween(startDate, endDate);
        return convertToManagerReportDTO(attendances);
    }

    private EmployeeReportDTO convertToEmployeeReportDTO(Attendance attendance) {
        EmployeeReportDTO dto = new EmployeeReportDTO();
        dto.setEmployeeId(attendance.getFuncionarioId());
        dto.setEmployeeName(attendance.getNome());
        dto.setDate(attendance.getData());
        dto.setCheckInTime(attendance.getHorarioEntrada().toLocalDateTime());
        dto.setCheckOutTime(
                attendance.getHorarioSaida() != null ? attendance.getHorarioSaida().toLocalDateTime() : null);
        dto.setWorkedHours(attendance.getTempoTrabalho() != null ? attendance.getTempoTrabalho().toHours() : 0);
        return dto;
    }

    private ManagerReportDTO convertToManagerReportDTO(List<Attendance> attendances) {
        ManagerReportDTO dto = new ManagerReportDTO();
        dto.setTotalEmployees(attendances.stream().map(Attendance::getFuncionarioId).distinct().count());
        dto.setTotalHoursWorked(attendances.stream()
                .map(Attendance::getTempoTrabalho)
                .filter(java.util.Objects::nonNull)
                .mapToLong(Duration::toHours)
                .sum());
        return dto;
    }
}