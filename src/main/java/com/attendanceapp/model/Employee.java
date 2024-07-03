package com.attendanceapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String nome, String apelido, Integer cargaHoraria, LocalDate dataContratacao) {
        this.nome = nome;
        this.apelido = apelido;
        this.cargaHoraria = cargaHoraria;
        this.dataContratacao = dataContratacao;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", dataContratacao=" + dataContratacao +
                '}';
    }
}