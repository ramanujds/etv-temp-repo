package com.rds.springsecurity.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage() {
        return "Hello from message";
    }
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdmin() {
        return "Hello from admin";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getUser() {
        return "Hello from user";
    }

    @PostAuthorize("returnObject == authentication.name")
    public String getUserInfo() {
        // is only returned if the `Account` belongs to the logged-in user
        return "Hello from user info";
    }


}
