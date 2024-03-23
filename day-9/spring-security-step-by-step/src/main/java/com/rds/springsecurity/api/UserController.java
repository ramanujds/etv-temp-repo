package com.rds.springsecurity.api;

import com.rds.springsecurity.dto.UserCredentials;
import com.rds.springsecurity.model.UserEntity;
import com.rds.springsecurity.service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserCrudService userCrudService;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userCrudService.save(userEntity);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserCredentials userCredentials) {
        return userCrudService.loginUser(userCredentials);
    }



}
