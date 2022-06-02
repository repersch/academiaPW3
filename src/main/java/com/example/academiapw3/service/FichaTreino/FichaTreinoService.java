package com.example.academiapw3.service.FichaTreino;

import com.example.academiapw3.domain.FichaTreino;

import java.util.List;

public interface FichaTreinoService {
    FichaTreino salvar(FichaTreino fichaTreino);

    FichaTreino editar(FichaTreino fichaTreino);

    void excluir(Integer id);

    FichaTreino buscarPorId(Integer id);

    List<FichaTreino> buscarTodos();
}
