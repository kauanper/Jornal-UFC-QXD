package com.example.JornalUFC.testesExploratorios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testes-exploratorios")
public class TestesController {

    @GetMapping()
    public String testeget() {
        return "prestou";
    }

    @PostMapping()
    public String testepost() {
        return "prestou";
    }
}
