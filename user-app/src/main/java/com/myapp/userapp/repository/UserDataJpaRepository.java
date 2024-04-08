package com.myapp.userapp.repository;

import com.myapp.userapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDataJpaRepository extends JpaRepository<UserEntity,Integer> {

    @Query("from UserEntity where username=:username")
    Optional<UserEntity> findByUsername(@Param("username") String username);


}
