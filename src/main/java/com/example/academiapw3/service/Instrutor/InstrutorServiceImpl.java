package com.example.academiapw3.service.Instrutor;

import com.example.academiapw3.dao.InstrutorDAO;
import com.example.academiapw3.domain.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorServiceImpl implements InstrutorService {
    @Autowired
    private InstrutorDAO instrutorDAO;

    @Override
    public Instrutor salvar(Instrutor instrutor) {
        return instrutorDAO.save(instrutor);
    }

    @Override
    public Instrutor editar(Instrutor instrutor) {
        return instrutorDAO.save(instrutor);
    }

    @Override
    public void excluir(Integer id) {
        instrutorDAO.deleteById(id);
    }

    @Override
    @Deprecated
    public Instrutor buscarPorId(Integer id) {
        return instrutorDAO.getById(id);
    }

    @Override
    public Optional<Instrutor> buscarPorEmail(String email) {
        return instrutorDAO.findByEmail(email);
    }

    @Override
    public List<Instrutor> buscarTodos() {
        return instrutorDAO.findAll();
    }
}
