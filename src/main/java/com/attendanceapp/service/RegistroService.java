//RegistroService

package com.attendanceapp.service;

import com.attendanceapp.model.Registro;
import com.attendanceapp.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public void checkIn(Integer funcionarioId) {
        Registro registro = new Registro();
        registro.setFuncionarioId(funcionarioId);
        registro.setTimestamp(LocalDateTime.now()); // Set the timestamp
        registroRepository.save(registro);
    }
}