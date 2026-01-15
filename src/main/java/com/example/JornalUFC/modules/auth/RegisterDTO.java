package com.example.JornalUFC.modules.auth;

import com.example.JornalUFC.modules.user.UserRoles;

public record RegisterDTO(String username,
        String password,
        UserRoles role) {
}
