package com.example.academiapw3.service.ExercicioTreino;

import com.example.academiapw3.dao.ExercicioTreinoDAO;
import com.example.academiapw3.domain.ExercicioTreino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioTreinoImpl implements ExercicioTreinoService {
    @Autowired
    private ExercicioTreinoDAO exercicioTreinoDAO;

    @Override
    public ExercicioTreino salvar(ExercicioTreino exercicioTreino) {
        return exercicioTreinoDAO.save(exercicioTreino);
    }

    @Override
    public ExercicioTreino editar(ExercicioTreino exercicioTreino) {
        return exercicioTreinoDAO.save(exercicioTreino);
    }

    @Override
    public void excluir(Integer id) {
        exercicioTreinoDAO.deleteById(id);
    }

    @Override
    @Deprecated
    public ExercicioTreino buscarPorId(Integer id) {
        return exercicioTreinoDAO.getById(id);
    }

    @Override
    public List<ExercicioTreino> buscarTodos() {
        return exercicioTreinoDAO.findAll();
    }
}
