package com.example.JornalUFC.modules.user.mappers;

import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.dtos.RegisterUserDTO;

public class DtoToEntityUser {

    private DtoToEntityUser() {
    }

    public static User transform(RegisterUserDTO dto) {
        return new User(
                dto.nickname(),
                dto.username(),
                dto.password(),
                dto.role()
        );
    }
}
