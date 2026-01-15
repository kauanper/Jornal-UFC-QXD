package com.example.JornalUFC.modules.news;

import com.example.JornalUFC.modules.news.dtos.NewsRegisterDTO;
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


    @PostMapping
    public ResponseEntity<?> testValidation(@RequestBody String rawBody) {
        return ResponseEntity.ok(rawBody);
    }

}
