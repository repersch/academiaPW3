package com.example.academiapw3.controller;

import com.example.academiapw3.domain.Exercicio;
import com.example.academiapw3.domain.Instrutor;
import com.example.academiapw3.service.Instrutor.InstrutorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/instrutores")
public class InstrutorController {
    private final InstrutorServiceImpl service;
    private final PasswordEncoder encoder;

    public InstrutorController(InstrutorServiceImpl service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("instrutor", new Instrutor());
        return "instrutor/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Instrutor instrutor, RedirectAttributes attr){
        service.salvar(instrutor);
        attr.addFlashAttribute("success","Instrutor inserido com sucesso!");
        return "redirect:/instrutores/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelMap) {
        modelMap.addAttribute("instrutores", service.buscarTodos());
        return "instrutor/lista";
    }

//    @PostMapping("/cadastrar")
//    public ResponseEntity<Instrutor> salvarInstrutor(@RequestBody Instrutor instrutor) {
//        instrutor.setSenha(encoder.encode(instrutor.getSenha()));
//        return ResponseEntity.ok(instrutorService.salvar(instrutor));
//    }

//    @GetMapping("/cadastrar")
//    public String cadastrar(Model model) {
//        model.addAttribute("instrutor", new Instrutor());
//        return "instrutor/cadastro";
//    }

//    @PostMapping("/salvar")
//    public String salvarInstrutor(Instrutor instrutor, RedirectAttributes attr) {
//        instrutor.setSenha(encoder.encode(instrutor.getSenha()));
//        service.salvar(instrutor);
//        attr.addFlashAttribute("success", "Instrutor salvo com sucesso!");
//        return "redirect:/instrutores/listar";
//    }

    @GetMapping("validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String email,
                                                @RequestParam String senha) {
        Optional<Instrutor> optionalInstrutor = service.buscarPorEmail(email);

        if (optionalInstrutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = encoder.matches(senha, optionalInstrutor.get().getSenha());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}