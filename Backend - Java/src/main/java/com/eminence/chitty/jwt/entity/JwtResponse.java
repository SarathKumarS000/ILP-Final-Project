package com.eminence.chitty.jwt.entity;

import lombok.Data;

@Data
public class JwtResponse {

    private final Long userId;
    private final Long roleId;
    private final String role;
    private final String email;
    private final String jwtToken;

//    public JwtResponse(UserLogin user, String jwtToken) {
//        this.user = user;
//        this.jwtToken = jwtToken;
////        this.role = role;
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getJwtToken() {
//        return jwtToken;
//    }
//
//    public void setJwtToken(String jwtToken) {
//        this.jwtToken = jwtToken;
//    }
}
