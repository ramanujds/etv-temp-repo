package com.myapp.userapp.repository;

import com.myapp.userapp.model.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserRepository {

    public UserEntity saveUser(UserEntity user);
    public Optional<UserEntity> getUserById(int userId);

    public List<UserEntity> getAllUsers();

    public void deleteUser(int userId);

    public UserEntity updateUser(int userId, UserEntity user);

    public Optional<UserEntity> getUserByName(String username);

}
