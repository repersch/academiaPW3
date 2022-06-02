package com.example.academiapw3.domain;

import javax.persistence.*;

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

    public Treino() {
    }

    public Treino(String nome, Integer serie, Integer repeticao, Double carga, FichaTreino fichaTreino) {
        this.nome = nome;
        this.serie = serie;
        this.repeticao = repeticao;
        this.carga = carga;
        this.fichaTreino = fichaTreino;
    }

    public Treino(Integer id, String nome, Integer serie, Integer repeticao, Double carga, FichaTreino fichaTreino) {
        this.id = id;
        this.nome = nome;
        this.serie = serie;
        this.repeticao = repeticao;
        this.carga = carga;
        this.fichaTreino = fichaTreino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public FichaTreino getFichaTreino() {
        return fichaTreino;
    }

    public void setFichaTreino(FichaTreino fichaTreino) {
        this.fichaTreino = fichaTreino;
    }
}
