//Attendance
package com.attendanceapp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer funcionarioId;

    private String nome;

    private LocalDate data;

    private Timestamp horarioEntrada;

    private Timestamp horarioSaida;

    @Transient
    private Duration tempoTrabalho;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

    public Duration getTempoTrabalho() {
        if (horarioEntrada != null && horarioSaida != null) {
            return Duration.between(horarioEntrada.toInstant(), horarioSaida.toInstant());
        }
        return null;
    }

    public void setTempoTrabalho(Duration tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }
}