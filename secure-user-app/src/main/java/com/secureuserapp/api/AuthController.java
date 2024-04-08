package com.secureuserapp.api;

import com.secureuserapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService service;

    @GetMapping("/hello")
    public String sayHello(){
        return service.getMessage();
    }

    @GetMapping("/user")
    public String sayHelloUser(){
        return service.getUserMessage();
    }

    @GetMapping("/admin")
    public String sayHelloAdmin(){
        return service.getAdminMessage();
    }


}
