package com.example.academiapw3.service.Instrutor;

import com.example.academiapw3.data.DetalheInstrutorData;
import com.example.academiapw3.domain.Instrutor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheInstrutorServiceImpl implements UserDetailsService {
    private final InstrutorServiceImpl instrutorService;

    public DetalheInstrutorServiceImpl(InstrutorServiceImpl instrutorService) {
        this.instrutorService = instrutorService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Instrutor> instrutorOptional = instrutorService.buscarPorEmail(email);

        if (instrutorOptional.isEmpty()) {
            throw new UsernameNotFoundException("E-mail [" + email + "] não encontrado!");
        }
        return new DetalheInstrutorData(instrutorOptional);
    }
}