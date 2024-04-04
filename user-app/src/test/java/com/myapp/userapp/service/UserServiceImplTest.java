package com.myapp.userapp.service;

import com.myapp.userapp.model.UserEntity;
import com.myapp.userapp.repository.UserRepository;
import com.myapp.userapp.util.UserEntityDtoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserServiceImpl service;

    @Test
    public void testGetUserById() {
        // Given
        var userId = 1;
        var user = new UserEntity(1,"abc","abc@yahoo.com", LocalDate.of(2000,10,10));
        // When
        Mockito.when(repository.getUserById(userId)).thenReturn(Optional.of(user));
        Assertions.assertEquals(UserEntityDtoUtil.convertToDto(user),
                                service.getUserById(userId));
        // Then
        Mockito.verify(repository,Mockito.times(1)).getUserById(userId);

    }

    @Test
    public void testSaveUser(){

        // Given
        var userEntity = new UserEntity(1,"abc","abc@yahoo.com", LocalDate.of(2000,10,10));
        var userDto = UserEntityDtoUtil.convertToDto(userEntity);
        // When
        Mockito.when(repository.saveUser(userEntity)).thenReturn(userEntity);

        // Then
        Assertions.assertEquals(userDto,
                service.saveUser(userDto));

        // Verify
        Mockito.verify(repository,Mockito.times(1)).saveUser(userEntity);

    }

    @Test
    public void testDeleteUser() {
        // Given
        var userId = 1;
        var user = new UserEntity(1,"abc","abc@yahoo.com", LocalDate.of(2000,10,10));
        // When

        Mockito.doNothing().when(repository).deleteUser(userId);
        Mockito.doThrow(new NoSuchElementException("User ID Not Available")).when(repository).deleteUser(2);

        // Then

        Assertions.assertDoesNotThrow(()->service.deleteUser(userId));

        Assertions.assertThrows(NoSuchElementException.class,()-> service.deleteUser(2));

        Mockito.verify(repository,Mockito.times(1)).deleteUser(userId);
        Mockito.verify(repository,Mockito.times(1)).deleteUser(2);

    }








}
