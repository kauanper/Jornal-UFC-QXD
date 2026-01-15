package com.example.JornalUFC.modules.news;

import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
import com.example.JornalUFC.modules.user.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/news")
public class NewsController {

    @PreAuthorize("hasRole('EDITOR')")
    @PostMapping
    public ResponseEntity<?> testValidation(@RequestBody @Valid NewsRegisterDTO dto,
                                            Authentication authentication) {
        // Pega o principal (o usuário logado)
        User user = (User) authentication.getPrincipal();

        // Agora você tem o ID
        long userId = user.getId();

        System.out.println("ID do usuário logado: " + userId);

        return ResponseEntity.ok(dto);
    }



}
