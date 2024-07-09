//ReportController.java

package com.attendanceapp.controller;

import com.attendanceapp.dto.EmployeeReportDTO;
import com.attendanceapp.dto.ManagerReportDTO;
import com.attendanceapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/employee")
    public List<EmployeeReportDTO> getEmployeeReport(@RequestParam Integer employeeId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return reportService.getEmployeeReport(employeeId, startDate, endDate);
    }

    @GetMapping("/manager")
    public ManagerReportDTO getManagerReport(@RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return reportService.getManagerReport(startDate, endDate);
    }
}