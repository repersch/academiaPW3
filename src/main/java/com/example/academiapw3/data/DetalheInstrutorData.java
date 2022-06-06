package com.example.academiapw3.data;

import com.example.academiapw3.domain.Instrutor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheInstrutorData implements UserDetails {
    private final Optional<Instrutor> instrutor;

    public DetalheInstrutorData(Optional<Instrutor> instrutor) {
        this.instrutor = instrutor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return instrutor.orElse(new Instrutor()).getSenha();
    }

    @Override
    public String getUsername() {
        return instrutor.orElse(new Instrutor()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}