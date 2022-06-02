package com.example.academiapw3.service.Treino;

import com.example.academiapw3.dao.TreinoDAO;
import com.example.academiapw3.domain.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoServiceImpl implements TreinoService {
    @Autowired
    private TreinoDAO treinoDAO;

    @Override
    public Treino salvar(Treino treino) {
        return treinoDAO.save(treino);
    }

    @Override
    public Treino editar(Treino treino) {
        return treinoDAO.save(treino);
    }

    @Override
    public void excluir(Integer id) {
        treinoDAO.deleteById(id);
    }

    @Override
    @Deprecated
    public Treino buscarPorId(Integer id) {
        return treinoDAO.getById(id);
    }

    @Override
    public List<Treino> buscarTodos() {
        return treinoDAO.findAll();
    }
}
