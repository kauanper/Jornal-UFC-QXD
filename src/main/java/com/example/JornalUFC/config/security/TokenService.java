package com.example.JornalUFC.config.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.example.JornalUFC.modules.user.User;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return "token";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
