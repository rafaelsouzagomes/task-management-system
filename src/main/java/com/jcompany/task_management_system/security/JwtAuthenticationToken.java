package com.jcompany.task_management_system.security;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import io.jsonwebtoken.Claims;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final Claims claims;

    public JwtAuthenticationToken(Claims claims) {
        super(null);
        this.claims = claims;
        setAuthenticated(true); // Esta chamada é necessária, caso contrário, será considerado não autenticado
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // Retorne as autoridades associadas ao JWT, caso tenha
        return null; // Substitua com autoridades reais, se aplicável
    }

    @Override
    public Object getCredentials() {
        return null; // JWT não precisa de credenciais
    }

    @Override
    public Object getPrincipal() {
        return this.claims;
    }
}
