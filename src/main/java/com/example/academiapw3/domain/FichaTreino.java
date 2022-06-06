package com.example.academiapw3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
