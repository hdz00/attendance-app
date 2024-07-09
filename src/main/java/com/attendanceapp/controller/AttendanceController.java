//AttendanceController

package com.attendanceapp.controller;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin_old")
    public ResponseEntity<Void> checkIn(@RequestBody AttendanceDTO attendanceDTO) {
        attendanceService.checkIn(attendanceDTO);
        return ResponseEntity.ok().build();
    }
}