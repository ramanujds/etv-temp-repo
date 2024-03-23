package com.rds.springsecurity.api;

import com.rds.springsecurity.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public String getMessage() {
        return messageService.getMessage();
    }


    @GetMapping("/admin")
    public String getAdmin() {
        return messageService.getAdmin();
    }

    @GetMapping("/user")
    public String getUser() {
        return messageService.getUser();
    }



}
