package com.example.JornalUFC.modules.user.dtos;

import com.example.JornalUFC.modules.user.UserRoles;

import java.time.LocalDateTime;

public record ResponseUserDTO(
        Long id,
        String nickname,
        String username, // email
        LocalDateTime createdAt,
        UserRoles role,
        Long posts
) {}
