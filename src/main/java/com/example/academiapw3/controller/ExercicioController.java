package com.example.academiapw3.controller;

import com.example.academiapw3.domain.Exercicio;
import com.example.academiapw3.domain.FichaTreino;
import com.example.academiapw3.service.Exercicio.ExercicioService;
import com.example.academiapw3.service.FichaTreino.FichaTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {
    @Autowired
    private ExercicioService service;

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "exercicio/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Exercicio exercicio, RedirectAttributes attr){
        service.salvar(exercicio);
        attr.addFlashAttribute("success","Exercicio inserido com sucesso!");
        return "redirect:/exercicios/listar";
    }

    @GetMapping("/listar")
    public String listar(){
        return "exercicio/lista";
    }

}
