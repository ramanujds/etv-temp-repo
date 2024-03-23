package com.rds.springsecurity.service;

import com.rds.springsecurity.dto.UserCredentials;
import com.rds.springsecurity.model.UserEntity;
import com.rds.springsecurity.repository.UserRepository;
import com.rds.springsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;


    public UserEntity save(UserEntity userEntity) {
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodedPassword);
        return userRepository.save(userEntity);
    }



    public String loginUser(UserCredentials userCredentials) {
        UserEntity userEntity = userRepository.findByUsername(userCredentials.username());
        if (userEntity == null) {
            throw new RuntimeException("User not found");
        }
        if(passwordEncoder.matches(userCredentials.password(), userEntity.getPassword())) {
            String token = jwtUtil.generateToken(userEntity.getUsername());
            return token;
        } else {
            throw new RuntimeException("Invalid password");
        }
    }


}
