package com.prac.security.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.security.Entity.Book;

public interface BookReposistory extends JpaRepository   <Book,Integer> {
    
}
