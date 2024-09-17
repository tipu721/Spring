package com.example.reactivecrud.config;

import com.example.reactivecrud.service.JwtAuthenticationConverter;
import com.example.reactivecrud.service.JwtReactiveAuthenticationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final JwtReactiveAuthenticationManager reactiveAuthenticationManager;
    private final JwtAuthenticationConverter authenticationConverter;
    private final JwtAuthenticationFailureHandler authenticationFailureHandler;

    public SecurityConfig(JwtReactiveAuthenticationManager reactiveAuthenticationManager, JwtAuthenticationConverter authenticationConverter, JwtAuthenticationFailureHandler authenticationFailureHandler) {
        this.reactiveAuthenticationManager = reactiveAuthenticationManager;
        this.authenticationConverter = authenticationConverter;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Bean
    public AuthenticationWebFilter authenticationWebFilter () {
        AuthenticationWebFilter jwtAuthenticationWebFilter = new AuthenticationWebFilter(reactiveAuthenticationManager);
        jwtAuthenticationWebFilter.setServerAuthenticationConverter(authenticationConverter);
        jwtAuthenticationWebFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        return jwtAuthenticationWebFilter;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf().disable()
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/signup", "/login").permitAll()
                        .anyExchange().authenticated()
                )
                .addFilterAt(authenticationWebFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }
}