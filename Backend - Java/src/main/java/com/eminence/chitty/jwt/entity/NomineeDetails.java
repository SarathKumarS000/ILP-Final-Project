package com.eminence.chitty.jwt.entity;


import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="nominee_details")
public class NomineeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nominee_id")
    private Long nomineeId;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "chittal_id",nullable = false)
    @JsonIgnore
    private ChittalDetails chittalId;


    @Column(name="name")
    private String Name;

    @Column(name="age")
    private Integer age;

    @Column(name="dob")
    private Date dob;

    @Column(name="phone")
    private Long phone;

    @Column(name="address")
    private String address;

    @Column(name="pincode")
    private Long pincode;

    @Column(name="aadhar")
    private Long aadhar;

    public NomineeDetails(Long nomineeId, ChittalDetails chittalId, String Name, Integer age, Date dob, Long phone, String address, Long pincode, Long aadhar) {
        this.nomineeId = nomineeId;
        this.chittalId = chittalId;
        this.Name = Name;
        this.age = age;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.pincode = pincode;
        this.aadhar=aadhar;


    }

    public NomineeDetails() {
    }






}
