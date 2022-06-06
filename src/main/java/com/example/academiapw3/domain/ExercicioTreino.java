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
public class ExercicioTreino {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer serie;

    @Column
    private Integer repeticao;

    @Column
    private Double carga;

    @OneToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    @OneToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;
}
