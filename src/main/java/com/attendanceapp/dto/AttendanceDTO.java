// AttendanceDTO.java
package com.attendanceapp.dto;

public class AttendanceDTO {
    private Integer employeeId;

    public AttendanceDTO(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}