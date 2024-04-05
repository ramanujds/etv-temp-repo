package com.myapp.userapp.api;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.dto.UserResource;
import com.myapp.userapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.core.WebHandler.linkTo;


@RestController
@RequestMapping("/api/v1/users")
public  class UserRestController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO user){
        UserDTO savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResource getUserById(@PathVariable("id") int userId) {
        UserDTO user = userService.getUserById(userId);


        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
                        .getUserById(userId))
                        .withSelfRel();



        UserResource userResource = new UserResource(selfLink,user.userId(),user.username(),user.email(),user.dob());




        return userResource;



    }




    @GetMapping("/search")
    public UserDTO searchUserByName(@RequestParam("username") String username){
        return userService.getUserByName(username);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable("id") int userId, @RequestBody UserDTO user){
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int userId){
        userService.deleteUser(userId);
    }



}
