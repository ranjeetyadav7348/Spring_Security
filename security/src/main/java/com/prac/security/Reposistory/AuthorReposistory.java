package com.prac.security.Reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prac.security.Entity.Author;

public interface AuthorReposistory  extends JpaRepository  <Author,Integer> {




    @Query("SELECT a.name AS authorName, COUNT(b.id) AS bookCount " +
           "FROM Author a LEFT JOIN a.books b " +
           "GROUP BY a.name " +
           "ORDER BY bookCount DESC, a.name ASC")
    List<Object[]> findAuthorsWithBookCount();
    
    
}
