package com.example.JornalUFC.testesExploratorios;


import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.UserRoles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UsersInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("admin@email.com")) {
                User admin = new User("adm", "admin@email.com", passwordEncoder.encode("admin123"), UserRoles.ADMIN);
                userRepository.save(admin);
                System.out.println("Admin user created!");
            }

            if (!userRepository.existsByUsername("editor@email.com")) {
                User editor = new User("ed","editor@email.com", passwordEncoder.encode("editor123"), UserRoles.EDITOR);
                userRepository.save(editor);
                System.out.println("Editor user created!");
            }
            
            System.out.println("Inicialização de usuários concluída!");
        };
    }

}
