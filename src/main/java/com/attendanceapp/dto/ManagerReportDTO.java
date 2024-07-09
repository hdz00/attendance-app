//ManagerReportDTO
package com.attendanceapp.dto;

public class ManagerReportDTO {
    private long totalEmployees;
    private long totalHoursWorked;

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(long totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }
}