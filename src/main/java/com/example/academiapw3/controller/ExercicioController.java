package com.example.academiapw3.controller;

import com.example.academiapw3.domain.Exercicio;
import com.example.academiapw3.domain.GrupoMuscular;
import com.example.academiapw3.service.Exercicio.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {
    @Autowired
    private ExercicioService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("exercicio", new Exercicio());
        return "exercicio/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Exercicio exercicio, RedirectAttributes attr){
        service.salvar(exercicio);
        attr.addFlashAttribute("success","Exercicio inserido com sucesso!");
        return "redirect:/exercicios/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelMap){
        modelMap.addAttribute("exercicios", service.buscarTodos());
        return "exercicio/lista";
    }

    @ModelAttribute("gruposMuscular")
    public GrupoMuscular[] getGruposMuscular() {
        return GrupoMuscular.values();
    }
}
