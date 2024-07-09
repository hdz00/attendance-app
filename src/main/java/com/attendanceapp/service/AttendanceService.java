// AttendanceService.java
package com.attendanceapp.service;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.dto.EmployeeReportDTO;
import com.attendanceapp.dto.ManagerReportDTO;
import com.attendanceapp.model.Attendance;
import com.attendanceapp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void checkIn(AttendanceDTO attendanceDTO) {
        Attendance attendance = new Attendance();
        attendance.setFuncionarioId(attendanceDTO.getEmployeeId());
        attendance.setDate(LocalDate.now());
        attendance.setCheckInTime(LocalTime.now());
        attendance.setStatus("Checked In");
        attendanceRepository.save(attendance);
    }

    public List<EmployeeReportDTO> getEmployeeReport(Integer employeeId, LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendanceRecords = attendanceRepository.findByEmployeeIdAndDateRange(employeeId, startDate,
                endDate);
        return attendanceRecords.stream()
                .map(record -> new EmployeeReportDTO(
                        record.getFuncionarioId(),
                        record.getDate(),
                        record.getCheckInTime(),
                        record.getCheckOutTime(),
                        record.getStatus()))
                .collect(Collectors.toList());
    }

    public ManagerReportDTO getManagerReport(LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendanceRecords = attendanceRepository.findAllByDateBetween(startDate, endDate);

        Map<Integer, List<Attendance>> attendanceByEmployee = attendanceRecords.stream()
                .collect(Collectors.groupingBy(Attendance::getFuncionarioId));

        long totalEmployees = attendanceByEmployee.size();
        long totalDays = startDate.datesUntil(endDate.plusDays(1)).count();

        long totalWorkingHours = attendanceRecords.stream()
                .mapToLong(record -> {
                    if (record.getCheckInTime() != null && record.getCheckOutTime() != null) {
                        return java.time.Duration.between(record.getCheckInTime(), record.getCheckOutTime()).toHours();
                    }
                    return 0;
                }).sum();

        return new ManagerReportDTO(totalEmployees, totalDays, totalWorkingHours);
    }
}