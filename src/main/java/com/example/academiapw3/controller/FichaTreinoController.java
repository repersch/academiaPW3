package com.example.academiapw3.controller;

import com.example.academiapw3.domain.FichaTreino;
import com.example.academiapw3.service.FichaTreino.FichaTreinoService;
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
@RequestMapping("/fichasTreino")
public class FichaTreinoController {

    @Autowired
    private FichaTreinoService service;

//    @GetMapping("/")
//    public String home(ModelMap modelMap) {
//        modelMap.addAttribute("fichasTreino", service.buscarTodos());
//        return "fichaTreino/lista";
//    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("fichaTreino", new FichaTreino());
        return "fichaTreino/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(FichaTreino fichaTreino, RedirectAttributes attr){
        service.salvar(fichaTreino);
        attr.addFlashAttribute("success","Ficha treino inserida com sucesso!");
        return "redirect:/fichasTreino/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelMap){
        System.out.println(service.buscarTodos());
        modelMap.addAttribute("fichasTreino", service.buscarTodos());
        return "fichaTreino/lista";
    }

}
