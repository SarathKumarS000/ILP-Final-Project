package com.eminence.chitty.jwt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ChittalPost {
    private Long chittalId;
    private Long userId;
    private String chittyId;
    private Integer age;
    private String address;
    private Long pinCode;
    private Long userPhone;
    private Date dob;
    private String status;
    private Long income;
    private Long aadhar;
}
