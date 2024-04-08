package com.secureuserapp.service;

import com.secureuserapp.dto.UserCredentialDTO;
import com.secureuserapp.model.UserEntity;
import com.secureuserapp.repository.UserRepository;
import com.secureuserapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository repository;

    @Autowired
    JwtUtil jwtUtil;

    public String login(UserCredentialDTO userCredentials){
        UserEntity user=repository.findByUsername(userCredentials.username())
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        if(!passwordEncoder.matches(userCredentials.password(),user.getPassword())){
           throw new RuntimeException("Invalid Credentials");
        }

       return jwtUtil.generateToken(user.getUsername());

    }

}
