package com.example.JornalUFC.modules.user.servicies;

import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.dtos.RegisterUserDTO;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import com.example.JornalUFC.modules.user.mappers.DtoToEntityUser;
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

        //talvez add validação de email

        User user = DtoToEntityUser.tranform(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));

        userRepository.save(user);

        return null;
    }
}
