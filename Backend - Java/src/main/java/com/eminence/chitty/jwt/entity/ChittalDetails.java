package com.eminence.chitty.jwt.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="chittal_details")
public class ChittalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chittal_id")
    private Long chittalId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",nullable = false)
    @JsonIgnore
    private UserRegistration userId;

//    @Column(name="userid")
//    private Long userId;
//

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "chitty_id",nullable = false)
    @JsonIgnore
    private Chitty chittyId;

    @Column(name="age")
    private Integer age;

    @Column(name="address")
    private String address;

    @Column(name="pincode")
    private Long pinCode;

    @Column(name="userPhone")
    private Long userPhone;

    @Column(name = "dob")
    private Date dob;

    @Column(name="status")
    private String status;

    @Column(name="income")
    private Long income;

    @Column(name="aadhar")
    private Long aadhar;

//    @JsonIgnore
//    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "chittalId",fetch = FetchType.LAZY)
//    private Set<NomineeDetails> chits= new HashSet<>();

//    @Column(name="nominee_id")
//    private Integer nomineeId;

    public ChittalDetails(Long chittalId, UserRegistration userId, Chitty chittyId, Integer age, String address, Long pinCode, Long userPhone, Date dob, String status, Long income, Long aadhar) {
        this.chittalId = chittalId;
        this.userId = userId;
        this.chittyId = chittyId;
        this.age = age;
        this.address = address;
        this.pinCode = pinCode;
        this.userPhone = userPhone;
        this.dob = dob;
        this.status=status;
        this.income=income;
        this.aadhar = aadhar;

    }

    public ChittalDetails() {
    }






}
