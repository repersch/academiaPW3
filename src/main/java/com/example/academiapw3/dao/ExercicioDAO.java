package com.example.academiapw3.dao;

import com.example.academiapw3.domain.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioDAO extends JpaRepository<Exercicio, Integer> {
}
