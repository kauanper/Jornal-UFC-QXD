package com.example.JornalUFC.modules.user.servicies;

import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import com.example.JornalUFC.modules.user.mappers.EntityUserToDto;
import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdUseCase {

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO execute(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "id",
                                "Usuário não encontrado com id: " + id
                        )
                );
        return EntityUserToDto.transform(user);
    }
}
