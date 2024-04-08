package com.myapp.userapp.service;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.exception.UserNotFoundException;
import com.myapp.userapp.model.UserEntity;
import com.myapp.userapp.repository.UserDataJpaRepository;
import com.myapp.userapp.util.UserEntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@Slf4j
public class UserServiceImplForJpa implements UserService{

    @Autowired
    private UserDataJpaRepository repository;


    @Override
    public UserDTO getUserById(int userId) {

       return repository.findById(userId).map(e->{
                   log.info(e.toString());
                   return e;
               })
               .map(UserEntityDtoUtil::convertToDto)
               .orElseThrow(()->new UserNotFoundException("User with ID : "+userId+" Not Found"));
    }

    @Override
    public UserDTO saveUser(UserDTO userDto) {
        UserEntity userEntity = repository.save(UserEntityDtoUtil.convertToEntity(userDto));
        return UserEntityDtoUtil.convertToDto(userEntity);
    }

    @Override
    public UserDTO updateUser(int userId, UserDTO userDto) {

        if(!repository.existsById(userId)){
            throw new UserNotFoundException("User with ID : "+userId+" Not Found");
        }
     // repository.findById(userId).orElseThrow(()->new UserNotFoundException("User with ID : "+userId+" Not Found"));
        UserEntity userEntity = repository.save(UserEntityDtoUtil.convertToEntity(userDto));
        return UserEntityDtoUtil.convertToDto(userEntity);
    }

    @Override
    public void deleteUser(int userId) {
        if(!repository.existsById(userId)){
            throw new UserNotFoundException("User with ID : "+userId+" Not Found");
        }
        repository.deleteById(userId);
    }

    @Override
    public UserDTO getUserByName(String username) {
        return repository.findByUsername(username)
                .map(UserEntityDtoUtil::convertToDto)
                .orElseThrow(()->new UserNotFoundException("User with Name : "+username+" Not Found"));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserEntityDtoUtil::convertToDto)
                .toList();
    }
}
