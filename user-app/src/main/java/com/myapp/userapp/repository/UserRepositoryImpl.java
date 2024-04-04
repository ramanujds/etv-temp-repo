package com.myapp.userapp.repository;

import com.myapp.userapp.model.UserEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<Integer, UserEntity> users;

    @PostConstruct
    public void init(){
        users = new HashMap<>();
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
