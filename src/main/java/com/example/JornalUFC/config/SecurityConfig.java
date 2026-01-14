package com.example.JornalUFC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desabilita CSRF (necessário para H2)
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // permite H2 em iframe
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // libera H2 console
                        .anyRequest().authenticated() // resto protegido
                )
                .formLogin(org.springframework.security.config.Customizer.withDefaults()); // <-- ajuste aqui

        return http.build();
    }
}
