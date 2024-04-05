package com.myapp.userapp.dto;

import com.myapp.userapp.api.UserRestController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;


import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



public class UserResource extends RepresentationModel<UserResource> {

    private int userId;
    private String username;
    private String email;
    private LocalDate dob;

    public UserResource(int userId, String username, String email, LocalDate dob) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dob = dob;
    }

    public UserResource(Link initialLink, int userId, String username, String email, LocalDate dob) {
        super(initialLink);
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dob = dob;
    }

    public UserResource(Iterable<Link> initialLinks, int userId, String username, String email, LocalDate dob) {
        super(initialLinks);
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dob = dob;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
