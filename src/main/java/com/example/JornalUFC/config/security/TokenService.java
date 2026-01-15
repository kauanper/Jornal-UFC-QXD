package com.example.JornalUFC.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserDetails user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("jornal-ufc-qxd")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro na geração do token", e);
        }
    }

    public String verifyToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("jornal-ufc-qxd")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private Instant getExpiration() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
