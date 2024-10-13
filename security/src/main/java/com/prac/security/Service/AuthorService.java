package com.prac.security.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.security.Entity.Author;
import com.prac.security.Entity.Book;
import com.prac.security.Reposistory.AuthorReposistory;

@Service
public class AuthorService {


    @Autowired
    private AuthorReposistory authorReposistory;

    public Author registeAuthor(Author author)
    {

        List<Book> book= author.getBooks();

        
        return authorReposistory.save(author);
    }

    public List<Object[]> getAllAuthor()
    {
        return authorReposistory.findAuthorsWithBookCount();
    }

    







    
}
