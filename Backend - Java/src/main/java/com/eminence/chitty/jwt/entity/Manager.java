package com.eminence.chitty.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manager")
@Getter
@Setter
//@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager {

    @Id
    @Column(name="emp_id")
    private Long emp_id;


    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String emp_lastname;

    @Column(name="email")
    private String email;

    @Column(name = "mobile")
    private Long mobileNumber;

    @Column(name = "password")
    private String passWord;

    @Column(name = "roleid")
    private Long roleId;

    @Column(name = "password_status")
    private String passWordStatus;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "manager",fetch = FetchType.LAZY)
    private Set<Chitty> chits= new HashSet<>();

    public Manager(Long emp_id, String firstName, String emp_lastname, String email, Long mobileNumber, String passWord, Long roleId, String passWordStatus, Set<Chitty> chits) {
        this.emp_id = emp_id;
        this.firstName = firstName;
        this.emp_lastname = emp_lastname;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.passWord = passWord;
        this.roleId = roleId;
        this.passWordStatus = passWordStatus;
        this.chits = chits;
    }

    public Manager() {
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmp_lastname() {
        return emp_lastname;
    }

    public void setEmp_lastname(String emp_lastname) {
        this.emp_lastname = emp_lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPassWordStatus() {
        return passWordStatus;
    }

    public void setPassWordStatus(String passWordStatus) {
        this.passWordStatus = passWordStatus;
    }

    public Set<Chitty> getChits() {
        return chits;
    }

    public void setChits(Set<Chitty> chits) {
        this.chits = chits;
    }
}
