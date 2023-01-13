package com.eminence.chitty.jwt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chitty")
//@Data
@Getter
@Setter

public class Chitty {

    @Id
    @Column(name = "chit_number")
    private String chitNumber;

    @Column(name = "installment")
    private Long installment;

    @Column(name = "duration")
    private Long duration;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    @JsonIgnore
    private ChittyCategory category;

    @Column(name = "number_of_chittals")
    private int numberOfChittal;

    @Column(name = "current_number_of_chittals")
    private int currentNumberOfChittal;

    @Column(name = "total_amount")
    private Long totalAmount;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_emp_id",nullable = false)
    @JsonIgnore
    private Manager manager;

    @Column(name="launch_date")
    private LocalDate launchDate;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "chittalId",fetch = FetchType.LAZY)
    private Set<ChittalDetails> chittals= new HashSet<>();


    public Chitty(String chitNumber, Long installment, Long duration, ChittyCategory category, int numberOfChittal, int currentNumberOfChittal, Long totalAmount, Manager manager, LocalDate launchDate, LocalDate startDate, String status) {
        this.chitNumber = chitNumber;
        this.installment = installment;
        this.duration = duration;
        this.category = category;
        this.numberOfChittal = numberOfChittal;
        this.currentNumberOfChittal = currentNumberOfChittal;
        this.totalAmount = totalAmount;
        this.manager = manager;
        this.launchDate = launchDate;
        this.startDate = startDate;
        this.status = status;
    }

    public Chitty() {
    }

}
