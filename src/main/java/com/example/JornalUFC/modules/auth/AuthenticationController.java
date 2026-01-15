package com.example.JornalUFC.modules.auth;

import com.example.JornalUFC.config.security.TokenService;
import com.example.JornalUFC.modules.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
    private TokenService tokenService;


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO body) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(body.username(), body.password());
            var auth = authenticationManager.authenticate(authToken);
            String token = tokenService.generateToken((UserDetails) auth.getPrincipal());

            return ResponseEntity.ok(token);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }




}