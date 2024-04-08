package com.myapp.userapp.model;

import jakarta.persistence.*;
import lombok.Data;

//@Entity
@Data
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId;

    private String content;

    @ManyToOne
    private UserEntity user;

}
