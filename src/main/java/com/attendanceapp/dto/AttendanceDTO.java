package com.attendanceapp.dto;

import java.sql.Timestamp;

public class AttendanceDTO {
    private String funcionarioId;
    private Timestamp horarioEntrada;
    private Timestamp horarioSaida;

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Timestamp getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Timestamp horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Timestamp getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Timestamp horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}