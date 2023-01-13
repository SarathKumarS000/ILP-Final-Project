package com.eminence.chitty.jwt.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long mobileNo;
    private String passWord;
    private Integer roleId;

}
