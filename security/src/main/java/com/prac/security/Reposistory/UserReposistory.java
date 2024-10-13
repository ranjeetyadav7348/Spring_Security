package com.prac.security.Reposistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.security.Entity.User;
import java.util.List;


public interface UserReposistory extends JpaRepository<User,Integer> {

    Optional<User>  findByEmail(String email);
    
}
