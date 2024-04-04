package com.jpm.app.repo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository("userRepo2")
@Primary
public class UserRepo {

    @Value("${USERNAME:abc}")
    private String datasource;
    @Value("${repo.username}")
    private String username;
    @Value("${repo.password}")
    private String password;


    @PostConstruct
    public void init(){
        System.out.println("User Repo Bean Initialized");
        System.out.println("Username : "+username);
        System.out.println("Datasource : "+datasource);
        System.out.println("Password : " +password);
    }

    public String userInfo(){
        return "Username : Yash";
    }
}
