package com.example.reactivecrud.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class JwtAuthenticationConverter implements ServerAuthenticationConverter {

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        // Extract the JWT token from the request and validate it
        // Return an Authentication object if valid, or Mono.empty() if invalid
        return Mono.empty();
    }
}
