package com.attendanceapp.controller;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/register")
    public void registerAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        attendanceService.registerAttendance(attendanceDTO);
    }

    @GetMapping("/{id}")
    public AttendanceDTO getAttendance(@PathVariable Long id) {
        return attendanceService.getAttendance(id);
    }
}