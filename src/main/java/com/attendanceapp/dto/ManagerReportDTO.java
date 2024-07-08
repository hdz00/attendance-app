//ManagerReportDTO.java

package com.attendanceapp.dto;

import java.time.LocalDate;
import java.util.List;

public class ManagerReportDTO {
    private LocalDate date;
    private List<EmployeeReportDTO> employeeReports;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<EmployeeReportDTO> getEmployeeReports() {
        return employeeReports;
    }

    public void setEmployeeReports(List<EmployeeReportDTO> employeeReports) {
        this.employeeReports = employeeReports;
    }
}