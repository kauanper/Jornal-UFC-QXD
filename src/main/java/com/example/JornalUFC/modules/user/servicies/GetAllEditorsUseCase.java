package com.example.JornalUFC.modules.user.servicies;

import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.UserRoles;
import com.example.JornalUFC.modules.user.dtos.ResponseUserDTO;
import com.example.JornalUFC.modules.user.mappers.EntityUserToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllEditorsUseCase {

    @Autowired
    private UserRepository userRepository;

    public List<ResponseUserDTO>execute(){
        List<User> users = userRepository.findByRole(UserRoles.EDITOR);
        List<ResponseUserDTO> responseUserDTOs = new ArrayList<>();
        for (User user : users) {
            responseUserDTOs.add(EntityUserToDto.transform(user));
        }
        return responseUserDTOs;
    }
}
