package com.example.academiapw3.dao;

import com.example.academiapw3.domain.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrutorDAO extends JpaRepository<Instrutor, Integer> {
    public Optional<Instrutor> findByEmail(String email);
}
