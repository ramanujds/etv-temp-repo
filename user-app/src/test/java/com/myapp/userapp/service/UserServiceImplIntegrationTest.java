package com.myapp.userapp.service;

import com.myapp.userapp.model.UserEntity;
import com.myapp.userapp.repository.UserRepository;
import com.myapp.userapp.util.UserEntityDtoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
public class UserServiceImplIntegrationTest {


    @Autowired
    UserServiceImpl service;

//    @Test
//    @Disabled
    public void testGetUserById() {
        // Given
        var userId = 1;
        var user = new UserEntity(1,"abc","abc@yahoo.com", LocalDate.of(2000,10,10));
        var userDto = UserEntityDtoUtil.convertToDto(user);

        service.saveUser(userDto);

        Assertions.assertEquals(UserEntityDtoUtil.convertToDto(user),
                                service.getUserById(userId));

    }





}
