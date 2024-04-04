package com.jpm.app.service;

import com.jpm.app.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class UserService {

    @Autowired
 //   @Qualifier("userRepo2")
    private UserRepo repo;

    @PostConstruct
    public void init(){
        System.out.println("User Service Bean Initialized");
    }


    public void setRepo(UserRepo repo) {
        this.repo = repo;
    }

//    public UserService(){
//        System.out.println("User Service Bean Created");
//    }

    public String getMessage(){
        return "Hello Spring";
    }

}
