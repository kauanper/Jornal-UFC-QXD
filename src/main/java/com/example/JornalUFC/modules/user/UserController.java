package com.example.JornalUFC.modules.user;

import com.example.JornalUFC.modules.user.dtos.RegisterUserDTO;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import com.example.JornalUFC.modules.user.servicies.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid RegisterUserDTO dto) {
        ResponseUserDTO response = createUserUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
