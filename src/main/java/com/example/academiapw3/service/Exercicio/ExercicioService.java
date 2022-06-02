package com.example.academiapw3.service.Exercicio;

import com.example.academiapw3.domain.Exercicio;

import java.util.List;

public interface ExercicioService {
    Exercicio salvar(Exercicio exercicio);

    Exercicio editar(Exercicio exercicio);

    void excluir(Integer id);

    Exercicio buscarPorId(Integer id);

    List<Exercicio> buscarTodos();
}
