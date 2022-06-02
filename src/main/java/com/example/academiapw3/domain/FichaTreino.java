package com.example.academiapw3.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class FichaTreino {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Boolean valido;

    @Column(name = "data_inicio", columnDefinition = "DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "")
    private LocalDate dataInicio;

    @Column(name = "data_validade", columnDefinition = "DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "")
    private LocalDate validade;

    @Column
    private String aluno;

    @OneToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    public FichaTreino() {
    }

    public FichaTreino(Boolean valido, LocalDate dataInicio, LocalDate validade, String aluno, Instrutor instrutor) {
        this.valido = valido;
        this.dataInicio = dataInicio;
        this.validade = validade;
        this.aluno = aluno;
        this.instrutor = instrutor;
    }

    public FichaTreino(Integer id, Boolean valido, LocalDate dataInicio, LocalDate validade, String aluno, Instrutor instrutor) {
        this.id = id;
        this.valido = valido;
        this.dataInicio = dataInicio;
        this.validade = validade;
        this.aluno = aluno;
        this.instrutor = instrutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}
