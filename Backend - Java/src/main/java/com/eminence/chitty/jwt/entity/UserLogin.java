package com.eminence.chitty.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
@Table(name = "userlogin")
public class UserLogin {

    @Id
    @Column(name = "id")
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JsonIgnore
    @JoinColumn (name = "roleid",nullable=false)
    private Role role;
}
