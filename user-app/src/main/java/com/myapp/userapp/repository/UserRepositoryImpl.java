package com.myapp.userapp.repository;

import com.myapp.userapp.model.UserEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<Integer, UserEntity> users;

    @PostConstruct
    public void init(){
        users = new HashMap<>();
        users.put(1,new UserEntity(1,"John","john@yahoo.com", LocalDate.of(1990,10,10)));
        users.put(2,new UserEntity(2,"Smith","smith@yahoo.com", LocalDate.of(1991,11,11)));
        users.put(3,new UserEntity(3,"Peter","peter@gmail.com", LocalDate.of(1992,12,12)));

    }


    @Override
    public UserEntity saveUser(UserEntity user) {
        users.put(user.getUserId(),user);
        return user;
    }

    @Override
    public Optional<UserEntity> getUserById(int userId) {
        UserEntity user =  users.get(userId);
        return user!=null ? Optional.of(user) : Optional.empty();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return new ArrayList<>(users.values());
    }


    public void deleteUser(int userId) {
        getUserById(userId).orElseThrow();
        users.remove(userId);
    }

    @Override
    public UserEntity updateUser(int userId, UserEntity user) {
        getUserById(userId).orElseThrow();
        return users.put(userId,user);
    }

    public Optional<UserEntity> getUserByName(String username) {
        return users.values().stream()
                .filter(user->user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

}
