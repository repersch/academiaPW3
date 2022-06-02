package com.example.academiapw3.service.ExercicioTreino;


import com.example.academiapw3.domain.ExercicioTreino;

import java.util.List;

public interface ExercicioTreinoService {
    ExercicioTreino salvar(ExercicioTreino exercicioTreino);

    ExercicioTreino editar(ExercicioTreino exercicioTreino);

    void excluir(Integer id);

    ExercicioTreino buscarPorId(Integer id);

    List<ExercicioTreino> buscarTodos();
}
