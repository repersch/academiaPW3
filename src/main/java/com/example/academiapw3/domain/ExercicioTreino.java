package com.example.academiapw3.domain;

import javax.persistence.*;

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

    public ExercicioTreino() {
    }

    public ExercicioTreino(Integer serie, Integer repeticao, Double carga, Treino treino, Exercicio exercicio) {
        this.serie = serie;
        this.repeticao = repeticao;
        this.carga = carga;
        this.treino = treino;
        this.exercicio = exercicio;
    }

    public ExercicioTreino(Integer id, Integer serie, Integer repeticao, Double carga, Treino treino, Exercicio exercicio) {
        this.id = id;
        this.serie = serie;
        this.repeticao = repeticao;
        this.carga = carga;
        this.treino = treino;
        this.exercicio = exercicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}
