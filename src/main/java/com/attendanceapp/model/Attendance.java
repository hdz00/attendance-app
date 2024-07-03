package com.attendanceapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

@Entity
@Table(name = "frequencia")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "funcionario_id", nullable = false)
    private String funcionarioId;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "horario_entrada")
    private LocalDateTime horarioEntrada;

    @Column(name = "horario_saida")
    private LocalDateTime horarioSaida;

    @Column(name = "tempo_trabalho")
    private Duration tempoTrabalho;

    // Default constructor
    public Attendance() {
    }

    // Parameterized constructor
    public Attendance(String funcionarioId, LocalDate data, String nome, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, Duration tempoTrabalho) {
        this.funcionarioId = funcionarioId;
        this.data = data;
        this.nome = nome;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.tempoTrabalho = tempoTrabalho;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Duration getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(Duration tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }

    // Calculate tempoTrabalho
    @PreUpdate
    public void calculateTempoTrabalho() {
        if (this.horarioEntrada != null && this.horarioSaida != null) {
            this.tempoTrabalho = Duration.between(this.horarioEntrada, this.horarioSaida);
        }
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", funcionarioId='" + funcionarioId + '\'' +
                ", data=" + data +
                ", nome='" + nome + '\'' +
                ", horarioEntrada=" + horarioEntrada +
                ", horarioSaida=" + horarioSaida +
                ", tempoTrabalho=" + tempoTrabalho +
                '}';
    }
}