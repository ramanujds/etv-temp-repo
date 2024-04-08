package com.secureuserapp.service;

import com.secureuserapp.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private String role;

    public UserDetailsImpl(UserEntity user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.role=user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Arrays.stream(role.split(","))
               .map(String::trim)
               .map(String::toUpperCase)
               .map(r->"ROLE_"+r)
               .map(SimpleGrantedAuthority::new)
               .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
