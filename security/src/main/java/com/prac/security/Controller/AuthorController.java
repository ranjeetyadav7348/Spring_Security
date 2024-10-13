package com.prac.security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.security.Entity.Author;
import com.prac.security.Entity.User;
import com.prac.security.Service.AuthorService;
import com.prac.security.Service.UserService;

@RestController
@RequestMapping("/home/")
public class AuthorController {
    

    @Autowired
    private AuthorService authorService;



    @PostMapping("/registerAuthor")
    ResponseEntity<?> registerAuthor(@RequestBody Author author)
    {

        Author savedAuthor=authorService.registeAuthor(author);
        return new ResponseEntity(savedAuthor,HttpStatus.OK);
    }


    @GetMapping("/fetchAuthor")
    ResponseEntity<?> getAllAuthor()
    {

       List< Object[]> fetchAuthor=authorService.getAllAuthor();
        return new ResponseEntity(fetchAuthor,HttpStatus.OK);
    }

}
