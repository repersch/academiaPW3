package com.example.academiapw3.controller;

import com.example.academiapw3.domain.Instrutor;
import com.example.academiapw3.service.Instrutor.InstrutorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    private final InstrutorServiceImpl instrutorService;
    private final PasswordEncoder encoder;

    public InstrutorController(InstrutorServiceImpl instrutorService, PasswordEncoder encoder) {
        this.instrutorService = instrutorService;
        this.encoder = encoder;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Instrutor>> listarInstrutores() {
        return ResponseEntity.ok(instrutorService.buscarTodos());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Instrutor> salvarInstrutor(@RequestBody Instrutor instrutor) {
        instrutor.setSenha(encoder.encode(instrutor.getSenha()));
        return ResponseEntity.ok(instrutorService.salvar(instrutor));
    }

    @GetMapping("validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String email,
                                                @RequestParam String senha) {
        Optional<Instrutor> optionalInstrutor = instrutorService.buscarPorEmail(email);

        if (optionalInstrutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = encoder.matches(senha, optionalInstrutor.get().getSenha());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}