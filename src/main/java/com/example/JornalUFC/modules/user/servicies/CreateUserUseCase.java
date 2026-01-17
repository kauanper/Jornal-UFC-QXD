package com.example.JornalUFC.modules.user.servicies;

import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.dtos.RegisterUserDTO;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO execute(RegisterUserDTO dto){
        //talvez validação de user


        return null;
    }
}
