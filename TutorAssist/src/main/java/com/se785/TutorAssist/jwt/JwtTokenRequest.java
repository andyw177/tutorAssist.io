package com.se785.TutorAssist.jwt;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password,UserDetails currentUser) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
