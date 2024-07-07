package com.attendanceapp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String funcionarioId;
    
    private Date data;
    
    private String nome;
    
    private Timestamp horarioEntrada;
    
    private Timestamp horarioSaida;
    
    private Duration tempoTrabalho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return tempoTrabalho;
    }

    public void setTempoTrabalho(Duration tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }
}