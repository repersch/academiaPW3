package com.example.academiapw3.controller;

import com.example.academiapw3.dao.InstrutorDAO;
import com.example.academiapw3.domain.FichaTreino;
import com.example.academiapw3.domain.Instrutor;
import com.example.academiapw3.service.FichaTreino.FichaTreinoService;
import com.example.academiapw3.service.Instrutor.InstrutorService;
import com.example.academiapw3.service.Instrutor.InstrutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fichasTreino")
public class FichaTreinoController {

    @Autowired
    private FichaTreinoService service;

    @Autowired
    private InstrutorServiceImpl instrutorService;

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

    @ModelAttribute("instrutores")
    public List<Instrutor> getInstrutores() {
        return instrutorService.buscarTodos();
    }

}
