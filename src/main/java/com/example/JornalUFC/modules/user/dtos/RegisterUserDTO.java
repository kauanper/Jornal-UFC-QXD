package com.example.JornalUFC.modules.user.dtos;

import com.example.JornalUFC.modules.user.UserRoles;
import jakarta.validation.constraints.*;

public record RegisterUserDTO(

        @NotBlank(message = "O nickname é obrigatório")
        @Size(min = 3, max = 30, message = "O nickname deve ter entre 3 e 30 caracteres")
        String nickname,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        @Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
        String username,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String password,

        @NotNull(message = "O papel do usuário é obrigatório")
        UserRoles role
) {}
