package com.example.JornalUFC.modules.user.servicies;

import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.dtos.RegisterUserDTO;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import com.example.JornalUFC.modules.user.mappers.DtoToEntityUser;
import com.example.JornalUFC.modules.user.mappers.EntityUserToDto;
import com.example.JornalUFC.shared.custonExceptions.DuplicateResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class CreateUserUseCase {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO execute(RegisterUserDTO dto){
        if (userRepository.existsByUsername(dto.username())) {
            throw new DuplicateResourceException(
                    "username",
                    "Email já está em uso"
            );
        }
        User user = DtoToEntityUser.transform(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        return EntityUserToDto.transform(userRepository.save(user));
    }
}
