package com.example.academiapw3.service.Exercicio;

import com.example.academiapw3.dao.ExercicioDAO;
import com.example.academiapw3.domain.Exercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioServiceImpl implements ExercicioService {
    @Autowired
    private ExercicioDAO exercicioDAO;

    @Override
    public Exercicio salvar(Exercicio exercicio) {
        return exercicioDAO.save(exercicio);
    }

    @Override
    public Exercicio editar(Exercicio exercicio) {
        return exercicioDAO.save(exercicio);
    }

    @Override
    public void excluir(Integer id) {
        exercicioDAO.deleteById(id);
    }

    @Override
    @Deprecated
    public Exercicio buscarPorId(Integer id) {
        return exercicioDAO.getById(id);
    }

    @Override
    public List<Exercicio> buscarTodos() {
        return exercicioDAO.findAll();
    }
}
