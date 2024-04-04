package com.myapp.userapp.util;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.UserEntity;

public class UserEntityDtoUtil {

    public static UserDTO convertToDto(UserEntity entity){
        UserDTO dto = new UserDTO(
                entity.getUserId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getDob()
        );
        return dto;
    }

    public static UserEntity convertToEntity(UserDTO dto){
        UserEntity entity = new UserEntity(
                dto.userId(),
                dto.username(),
                dto.email(),
                dto.dob()
        );
        return entity;
    }

}
