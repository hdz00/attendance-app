package com.attendanceapp.service;

import com.attendanceapp.dto.EmployeeReportDTO;
import com.attendanceapp.dto.ManagerReportDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<EmployeeReportDTO> getEmployeeReport(Integer employeeId, LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendances = attendanceRepository.findByEmployeeIdAndDateRange(employeeId, startDate,
                endDate);
        return attendances.stream().map(this::convertToEmployeeReportDTO).collect(Collectors.toList());
    }

    public ManagerReportDTO getManagerReport(LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendances = attendanceRepository.findByDateRange(startDate, endDate);
        ManagerReportDTO report = new ManagerReportDTO();
        report.setDate(LocalDate.now());
        report.setEmployeeReports(
                attendances.stream().map(this::convertToEmployeeReportDTO).collect(Collectors.toList()));
        return report;
    }

    private EmployeeReportDTO convertToEmployeeReportDTO(Attendance attendance) {
        EmployeeReportDTO dto = new EmployeeReportDTO();
        dto.setEmployeeId(attendance.getEmployee().getId().toString());
        dto.setEmployeeName(attendance.getEmployee().getName());
        dto.setDate(attendance.getDate());
        dto.setCheckInTime(attendance.getCheckInTime());
        dto.setCheckOutTime(attendance.getCheckOutTime());
        dto.setWorkedHours(Duration.between(attendance.getCheckInTime(), attendance.getCheckOutTime()).toHours());
        return dto;
    }
}