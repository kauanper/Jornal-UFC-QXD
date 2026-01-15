package com.example.JornalUFC.modules.auth;

import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.UserRoles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO body) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(body.username(), body.password());
            authenticationManager.authenticate(authToken);
            return ResponseEntity.ok("Login realizado com sucesso!");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }




}