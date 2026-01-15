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
        // Pega o usuario logado e a partir dai, seu id
        User user = (User) authentication.getPrincipal();
        long userId = user.getId();

        return ResponseEntity.ok("ID do usuário logado: " + userId);
    }



}
