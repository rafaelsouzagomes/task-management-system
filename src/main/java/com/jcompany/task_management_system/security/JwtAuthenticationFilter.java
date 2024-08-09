package com.jcompany.task_management_system.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        Claims claims = Jwts.parser()
                .setSigningKey("your_secret_key")  // Alterar para sua chave secreta
                .parseClaimsJws(token)
                .getBody();

        if (claims != null) {
            SecurityContextHolder.getContext().setAuthentication(
                    new JwtAuthenticationToken(claims)
            );
        }

        chain.doFilter(request, response);
    }
}