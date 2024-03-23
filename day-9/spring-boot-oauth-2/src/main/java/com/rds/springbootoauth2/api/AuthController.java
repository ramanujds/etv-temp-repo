package com.rds.springbootoauth2.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @GetMapping
    public String welcome() {
        return "Hello!";
    }




}
