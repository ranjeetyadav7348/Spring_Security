package com.prac.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.prac.security.Entity.User;
import com.prac.security.Reposistory.UserReposistory;



@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserReposistory userReposistory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user= userReposistory.findByEmail(username).orElseThrow(null);
        return user;
    }
    
}
