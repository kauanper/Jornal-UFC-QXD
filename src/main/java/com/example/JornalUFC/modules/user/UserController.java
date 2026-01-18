package com.example.JornalUFC.modules.user;

import com.example.JornalUFC.modules.user.dtos.RegisterUserDTO;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import com.example.JornalUFC.modules.user.servicies.CreateUserUseCase;
import com.example.JornalUFC.modules.user.servicies.GetAllEditorsUseCase;
import com.example.JornalUFC.modules.user.servicies.GetUserByIdUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetAllEditorsUseCase getAllEditorsUseCase;

    @Autowired
    private GetUserByIdUseCase getUserByIdUseCase;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseUserDTO> createUser(@RequestBody @Valid RegisterUserDTO dto) {
        ResponseUserDTO response = createUserUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editors")
    public ResponseEntity<List<ResponseUserDTO>> getEditors() {
        List<ResponseUserDTO> editors = getAllEditorsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(editors);
    }

    @PreAuthorize("hasRole('EDITOR')")
    @GetMapping()
    public ResponseEntity<ResponseUserDTO> getUsers(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        long userId = user.getId();
        ResponseUserDTO response = getUserByIdUseCase.execute(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
