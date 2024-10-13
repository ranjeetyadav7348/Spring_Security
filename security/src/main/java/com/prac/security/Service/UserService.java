package com.prac.security.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prac.security.Entity.User;
import com.prac.security.Reposistory.UserReposistory;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserReposistory userReposistory;

    @Autowired
    private ModelMapper modelMapper;

    private List<User> store = new ArrayList<>();

    public List<User> getUsers() {
        return store;
    }

    public User registerUser(User u) {

        u.setPassword(passwordEncoder.encode(u.getPassword()));

        User user = userReposistory.save(u);
        return user;

    }


    

}
