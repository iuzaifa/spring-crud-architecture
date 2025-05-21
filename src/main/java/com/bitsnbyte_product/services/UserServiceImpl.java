package com.bitsnbyte_product.services;


import com.bitsnbyte_product.entities.User;
import com.bitsnbyte_product.repositories.UserRepository;
import com.bitsnbyte_product.security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService , UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setUserPassword(new BCryptPasswordEncoder(15).encode(user.getUserPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if (user.isEmpty()) throw new UsernameNotFoundException("User not Found");
        return new UserPrinciple(user.get());
    }


}
