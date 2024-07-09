// RegistroController.java
package com.attendanceapp.controller;

import com.attendanceapp.dto.AttendanceDTO;
import com.attendanceapp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin")
    public void checkIn(@RequestBody Map<String, Object> payload) {
        Integer employeeId = (Integer) payload.get("employeeId");
        attendanceService.checkIn(new AttendanceDTO(employeeId));
    }
}