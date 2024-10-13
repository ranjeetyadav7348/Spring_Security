package com.prac.security.Controller;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.security.Entity.ApiRequest;
import com.prac.security.Entity.User;
import com.prac.security.Entity.jwtRequest;
import com.prac.security.Entity.jwtResponse;
import com.prac.security.Service.UserService;
import com.prac.security.jwthelper.JwtHelper;

@RestController
@RequestMapping("/home/")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    @Autowired
    private ModelMapper modelMapper;




    @GetMapping("/test")
    ResponseEntity<?> getResponse()
    {

        List<User> usersList= userService.getUsers();
        return new ResponseEntity(usersList,HttpStatus.OK);
    }

    @GetMapping("/current-user")
    ResponseEntity<?> getCurrentUser(Principal principal)
    {

       
        return new ResponseEntity(principal.getName(),HttpStatus.OK);
    }


    @PostMapping("/auth/signup")
    public ResponseEntity<jwtResponse> singupUser(@RequestBody User request) {


        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+request.getUsername());


        User user = userService.registerUser(request);



        return new ResponseEntity(user,HttpStatus.OK);




    }


















    @PostMapping("/auth/login")
    public ResponseEntity<jwtResponse> login(@RequestBody jwtRequest request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());

       

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        jwtResponse response = jwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {


       
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
       
        try {
            manager.authenticate(authentication);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

     @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    
    
}
