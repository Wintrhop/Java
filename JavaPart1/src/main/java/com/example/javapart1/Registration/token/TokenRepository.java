package com.example.javapart1.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TokenRepository {

    private final TokenCrudRepository tokenCrudRepository;
    public Optional<ConfirmationToken> findByToken(String token){
        return tokenCrudRepository.findByToken(token);
    }

    public void save(ConfirmationToken token) {
        tokenCrudRepository.save(token);
    }

}
