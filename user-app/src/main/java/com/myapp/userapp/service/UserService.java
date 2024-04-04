package com.myapp.userapp.service;

import com.myapp.userapp.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(int userId);

    UserDTO saveUser(UserDTO user);

    UserDTO updateUser(int userId, UserDTO user);

    void deleteUser(int userId);

    UserDTO getUserByName(String username);

    List<UserDTO> getAllUsers();



}
