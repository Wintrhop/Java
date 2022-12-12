package com.example.javapart1.Registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user/")
@AllArgsConstructor
public class RegistrationUser {


    private RegistrationService registrationService;
    @PostMapping("/signUp")
    public String signUp(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/confirm")
    public String confirmToken(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}

