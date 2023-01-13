package com.eminence.chitty.jwt.entity;

import lombok.Data;

import javax.persistence.Entity;


@Data
public class JwtRequest {

    private String email;
    private String password;

}
