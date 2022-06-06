package com.example.academiapw3.service.Instrutor;

import com.example.academiapw3.domain.Instrutor;

import java.util.List;
import java.util.Optional;

public interface InstrutorService {
    Instrutor salvar(Instrutor instrutor);

    Instrutor editar(Instrutor instrutor);

    void excluir(Integer id);

    Instrutor buscarPorId(Integer id);

    Optional<Instrutor> buscarPorEmail(String email);

    List<Instrutor> buscarTodos();
}
