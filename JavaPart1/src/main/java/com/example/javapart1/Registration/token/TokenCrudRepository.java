package com.example.javapart1.Registration.token;

import com.example.javapart1.User.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenCrudRepository extends MongoRepository<ConfirmationToken,String> {
    Optional<ConfirmationToken> findByToken(String token);



}
