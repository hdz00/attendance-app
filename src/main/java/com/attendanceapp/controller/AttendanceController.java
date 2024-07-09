// AttendanceController.java
package com.attendanceapp.controller;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.dto.EmployeeDTO;
import com.attendanceapp.dto.EmployeeReportDTO;
import com.attendanceapp.dto.ManagerReportDTO;
import com.attendanceapp.service.AttendanceService;
import com.attendanceapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/checkin")
    public void checkIn(@RequestBody AttendanceDTO attendanceDTO) {
        attendanceService.checkIn(attendanceDTO);
    }

    @PostMapping("/employee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/employee-report")
    public List<EmployeeReportDTO> getEmployeeReport(@RequestParam Integer employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return attendanceService.getEmployeeReport(employeeId, startDate, endDate);
    }

    @GetMapping("/manager-report")
    public ManagerReportDTO getManagerReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return attendanceService.getManagerReport(startDate, endDate);
    }
}