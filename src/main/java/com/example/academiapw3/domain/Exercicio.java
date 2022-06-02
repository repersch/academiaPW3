package com.example.academiapw3.domain;

import javax.persistence.*;

public class Exercicio {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;

    @Column
    private String descricao;

    public Exercicio() {
    }

    public Exercicio(String nome, GrupoMuscular grupoMuscular, String descricao) {
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.descricao = descricao;
    }

    public Exercicio(Integer id, String nome, GrupoMuscular grupoMuscular, String descricao) {
        this.id = id;
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.descricao = descricao;
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

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
