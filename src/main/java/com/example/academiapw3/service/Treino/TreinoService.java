package com.example.academiapw3.service.Treino;

import com.example.academiapw3.domain.Treino;

import java.util.List;

public interface TreinoService {
    Treino salvar(Treino treino);

    Treino editar(Treino treino);

    void excluir(Integer id);

    Treino buscarPorId(Integer id);

    List<Treino> buscarTodos();
}
