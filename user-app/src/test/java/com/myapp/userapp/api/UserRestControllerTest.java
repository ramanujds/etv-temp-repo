package com.myapp.userapp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.UserEntity;
import com.myapp.userapp.service.UserService;
import com.myapp.userapp.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springdoc.core.configuration.SpringDocSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;



@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @Autowired
    MockMvc mvc;


    @Autowired
    UserService service;

    @Test
    public void testGetUserById() throws Exception {
        // Given
        int userId = 1;
        var user = new UserDTO(1,"abc","abc@yahoo.com", LocalDate.of(2000,10,10));
        // When
      //  Mockito.when(service.getUserById(userId)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/users/"+userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
              //  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void testSaveUser() throws Exception {
        // Given
        var user = new UserDTO(1,"abc","abc@yahoo.com", LocalDate.of(2000,10,10));
        // When
      //  Mockito.when(service.saveUser(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                        .contentType("application/json")
                        .content(mapToJson(user))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json("""
                                    {
                                        "userId": 1,
                                        "username": "abc",
                                        "email": "abc@yahoo.com",
                                        "dob": "2000-10-10"
                                    }
                        """))
               // .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
    }




    public String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        return mapper.writeValueAsString(object);
    }






}
