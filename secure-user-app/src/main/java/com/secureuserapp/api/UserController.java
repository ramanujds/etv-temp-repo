package com.secureuserapp.api;

import com.secureuserapp.dto.UserCredentialDTO;
import com.secureuserapp.model.UserEntity;
import com.secureuserapp.repository.UserRepository;
import com.secureuserapp.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserAuthService service;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user){
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody UserCredentialDTO userCredential){

        return service.login(userCredential);

    }

}
