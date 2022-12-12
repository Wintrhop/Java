package com.example.javapart1.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class UserRepository {

    @Autowired
    UserCrudRepository userCrudRepository;

    public Optional<UserModel> findByEmail(String email){
        return userCrudRepository.findByEmail(email);}

    public void save(UserModel user) {
        userCrudRepository.save(user);
    }
    public Optional<UserModel> findById(String id){
        return userCrudRepository.findById(id);
    }

}
