package com.myapp.userapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private int userId;
    private String username;
    private String email;
    private LocalDate dob;
}
