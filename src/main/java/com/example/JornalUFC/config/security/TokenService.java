package com.example.JornalUFC.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.JornalUFC.modules.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String tokenCreated = JWT.create()
                    .withIssuer("jornal-ufc-qxd")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
            return tokenCreated;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro na geração do token", e);
        }
    }

    private Instant getExpiration() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
