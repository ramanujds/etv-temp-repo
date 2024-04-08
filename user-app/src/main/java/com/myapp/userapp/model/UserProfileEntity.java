package com.myapp.userapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_profile")
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private String fullName;

//    @OneToOne
    @Transient
    private UserEntity user;


}
