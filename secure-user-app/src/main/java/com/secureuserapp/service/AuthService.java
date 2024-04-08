package com.secureuserapp.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String getMessage(){
        return "Hello Everyone";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getUserMessage(){
        return "Hello User";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminMessage(){
        return "Hello Admin";
    }



}
