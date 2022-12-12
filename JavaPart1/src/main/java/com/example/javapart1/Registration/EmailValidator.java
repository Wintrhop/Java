package com.example.javapart1.Registration;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service

public class EmailValidator  {

    public static String regex = "[a-z0-9]+@[a-z]+.[a-z]{2,3}";
    public static Boolean isMatches(String email){
        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }
}
