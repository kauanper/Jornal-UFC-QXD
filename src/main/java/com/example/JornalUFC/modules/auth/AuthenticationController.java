package com.example.JornalUFC.modules.auth;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    /*
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO body){
        var usernamePassword = new UsernamePasswordAuthenticationToken(body.username(), body.password());
        var authentication = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    */

    @PostMapping("/login")
    public String login(@RequestBody @Valid AuthenticationDTO body){
        return "foi!!";
    }
}
