package com.example.JornalUFC.modules.user.servicies;

import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEditorsUseCase {

    @Autowired
    private UserRepository userRepository;

    public List<ResponseUserDTO>execute(){

        return null;
    }
}
