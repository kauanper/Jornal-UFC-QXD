package com.example.JornalUFC.modules.auth;

import com.example.JornalUFC.config.security.TokenService;
import com.example.JornalUFC.modules.auth.dtos.AuthenticationDTO;
import com.example.JornalUFC.modules.auth.dtos.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO body) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(
                    body.username(),
                    body.password()
            );

            var auth = authenticationManager.authenticate(authToken);
            String token = tokenService.generateToken((UserDetails) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).build();
        }
    }


}