package com.se785.TutorAssist.jwt;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = 8317676219297719109L;

    private final String token;
    
    private final UserDetails currentUser;

    public JwtTokenResponse(String token, UserDetails current_user) {
        this.token = token;
        this.currentUser = current_user;
    }

    public String getToken() {
        return this.token;
    }
    
    public UserDetails getCurrentUser() {
        return this.currentUser;
    }
}