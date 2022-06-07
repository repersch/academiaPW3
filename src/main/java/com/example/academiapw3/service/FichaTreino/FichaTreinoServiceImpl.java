package com.example.academiapw3.service.FichaTreino;

import com.example.academiapw3.dao.FichaTreinoDAO;
import com.example.academiapw3.domain.FichaTreino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaTreinoServiceImpl implements FichaTreinoService {
    @Autowired
    private FichaTreinoDAO fichaTreinoDAO;


    @Override
    public FichaTreino salvar(FichaTreino fichaTreino) {
        return fichaTreinoDAO.save(fichaTreino);
    }

    @Override
    public FichaTreino editar(FichaTreino fichaTreino) {
        return fichaTreinoDAO.save(fichaTreino);
    }

    @Override
    public void excluir(Integer id) {
        fichaTreinoDAO.deleteById(id);
    }

    @Override
    @Deprecated
    public FichaTreino buscarPorId(Integer id) {
        return fichaTreinoDAO.getById(id);
    }

    @Override
    public List<FichaTreino> buscarTodos() {
        return fichaTreinoDAO.findAll();
    }
}
