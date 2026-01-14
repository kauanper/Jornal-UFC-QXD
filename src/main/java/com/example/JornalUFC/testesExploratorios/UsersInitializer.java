package com.example.JornalUFC.testesExploratorios;


import com.example.JornalUFC.modules.user.User;
import com.example.JornalUFC.modules.user.UserRepository;
import com.example.JornalUFC.modules.user.UserRoles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UsersInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            // Usuário ADMIN
            User admin = new User("admin@email.com", passwordEncoder.encode("admin123"), UserRoles.ADMIN);
            User editor = new User("editor@email.com", passwordEncoder.encode("editor123"), UserRoles.EDITOR);

            userRepository.save(admin);
            userRepository.save(editor);


            System.out.println("Usuários iniciais criados no H2!");
        };
    }
}
