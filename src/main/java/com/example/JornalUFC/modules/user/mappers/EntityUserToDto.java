package com.example.JornalUFC.modules.user.mappers;

import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;

public class EntityUserToDto {
    private EntityUserToDto() {}

    public static ResponseUserDTO transform(User user) {
        return new ResponseUserDTO(
                user.getId(),
                user.getNickname(),
                user.getUsername(),
                user.getCreatedAt(),
                user.getRole()
        );
    }

}
