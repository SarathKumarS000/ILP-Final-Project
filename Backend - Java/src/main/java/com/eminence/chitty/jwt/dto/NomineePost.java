package com.eminence.chitty.jwt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NomineePost {

    private Long chittalId;
    private String name;
    private Integer age;
    private Date dob;
    private Long phone;
    private String address;
    private Long pincode;
    private Long aadhar;
}
