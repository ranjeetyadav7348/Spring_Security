package com.prac.security.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class jwtResponse {


    private String jwtToken;
    private String username;
    
}
