package com.example.JornalUFC.testesExploratorios;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testes-exploratorios")
public class TestesController {

    @GetMapping()
    public String testeget() {
        return "prestou para get";
    }

    @PreAuthorize("hasRole('EDITOR')")
    @PostMapping()
    public String testepost() {
        return "prestou para post";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping()
    public String testedelete() {
        return "prestou para delete";
    }
}
