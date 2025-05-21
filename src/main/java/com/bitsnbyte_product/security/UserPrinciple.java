package com.bitsnbyte_product.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.bitsnbyte_product.entities.User;

import java.util.Collection;
import java.util.List;


public class UserPrinciple implements UserDetails {

    private User user;
    public UserPrinciple(User user){
        this.user = user;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
