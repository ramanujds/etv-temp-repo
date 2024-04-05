package com.myapp.userapp.service;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.exception.UserNotFoundException;
import com.myapp.userapp.model.UserEntity;
import com.myapp.userapp.repository.UserRepository;
import com.myapp.userapp.util.UserEntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(int userId) {
        return userRepository.getUserById(userId)
                .map(UserEntityDtoUtil::convertToDto)
                .orElseThrow(()->new UserNotFoundException("User with id "+userId+" not found"));


    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        UserEntity entity = userRepository.saveUser(UserEntityDtoUtil.convertToEntity(user));
        return UserEntityDtoUtil.convertToDto(entity);
    }

    @Override
    public UserDTO updateUser(int userId, UserDTO user) {
        UserEntity entity = userRepository.updateUser(userId, UserEntityDtoUtil.convertToEntity(user));
        return UserEntityDtoUtil.convertToDto(entity);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    @Override
    public UserDTO getUserByName(String username) {
        return userRepository.getUserByName(username)
                .map(UserEntityDtoUtil::convertToDto)
                .orElseThrow();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserEntityDtoUtil::convertToDto)
                .collect(Collectors.toList());
    }
}
