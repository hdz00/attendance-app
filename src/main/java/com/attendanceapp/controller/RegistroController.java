//RegistroController

package com.attendanceapp.controller;

import com.attendanceapp.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping("/checkin")
    public void checkIn(@RequestBody Map<String, Integer> request) {
        Integer funcionarioId = request.get("funcionarioId");
        registroService.checkIn(funcionarioId);
    }
}