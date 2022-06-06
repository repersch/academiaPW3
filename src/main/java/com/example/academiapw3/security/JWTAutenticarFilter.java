package com.example.academiapw3.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.academiapw3.data.DetalheInstrutorData;
import com.example.academiapw3.domain.Instrutor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
    // Token válido por 10 minutos
    public static final int TOKEN_EXPIRACAO = 600_000;

    // Variável que transforma o token único. O ideal é deixar separado em um arquivo de configuração, porém
    // para fins de desenvolvimento está no meio do código
    public static final String TOKEN_SENHA = "22589581-8285-4888-8134-adc4f33eee33";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            Instrutor instrutor = new ObjectMapper().readValue(request.getInputStream(), Instrutor.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    instrutor.getEmail(),
                    instrutor.getSenha(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar instrutor ", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        DetalheInstrutorData instrutorData = (DetalheInstrutorData) authResult.getPrincipal();

        String token = JWT.create().withSubject(instrutorData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
