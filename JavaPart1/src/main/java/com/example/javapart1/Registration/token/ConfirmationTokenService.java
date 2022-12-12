package com.example.javapart1.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final TokenRepository tokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        tokenRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token){
        return tokenRepository.findByToken(token);
    }


}
