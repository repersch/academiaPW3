package com.example.academiapw3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Treino {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private Integer serie;

    @Column
    private Integer repeticao;

    @Column
    private Double carga;

    @OneToOne
    @JoinColumn(name = "ficha_treino_id")
    private FichaTreino fichaTreino;
}
