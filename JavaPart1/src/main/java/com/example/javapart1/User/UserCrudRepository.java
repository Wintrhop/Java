package com.example.javapart1.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<UserModel,String> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findById(String id);
}
