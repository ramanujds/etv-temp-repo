package com.userapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users_info")
public class Users {
    @Id
    private  int userId;

    private  String username;

    private String email;

    private LocalDate dob;

}
