package com.example.academiapw3.service.Instrutor;

import com.example.academiapw3.domain.Instrutor;

import java.util.List;

public interface InstrutorService {
    Instrutor salvar(Instrutor instrutor);

    Instrutor editar(Instrutor instrutor);

    void excluir(Integer id);

    Instrutor buscarPorId(Integer id);

    List<Instrutor> buscarTodos();
}
