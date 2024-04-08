package com.userapp.repository;

import com.userapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query("from Users where username=:username")
    public Optional<Users> findByName(String username);


}
