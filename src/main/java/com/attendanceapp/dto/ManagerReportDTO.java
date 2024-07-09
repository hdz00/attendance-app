// ManagerReportDTO.java
package com.attendanceapp.dto;

public class ManagerReportDTO {
    private long totalEmployees;
    private long totalDays;
    private long totalWorkingHours;

    public ManagerReportDTO(long totalEmployees, long totalDays, long totalWorkingHours) {
        this.totalEmployees = totalEmployees;
        this.totalDays = totalDays;
        this.totalWorkingHours = totalWorkingHours;
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(long totalDays) {
        this.totalDays = totalDays;
    }

    public long getTotalWorkingHours() {
        return totalWorkingHours;
    }

    public void setTotalWorkingHours(long totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }
}