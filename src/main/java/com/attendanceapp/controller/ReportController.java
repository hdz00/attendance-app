package com.attendanceapp.controller;

import com.attendanceapp.dto.EmployeeReportDTO;
import com.attendanceapp.dto.ManagerReportDTO;
import com.attendanceapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeReportDTO>> getEmployeeReport(
            @RequestParam Integer employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<EmployeeReportDTO> report = reportService.getEmployeeReport(employeeId, startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/manager")
    public ResponseEntity<ManagerReportDTO> getManagerReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        ManagerReportDTO report = reportService.getManagerReport(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}