package com.javavilnius10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity
@Setter
@Getter
@ToString

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String companyName;
    private String registrationNumber;
    private String vatNumber;
    private String telephoneNumber;
    private String address;
    private String email;
    private String bankData;
    private String username; //prisijungimo vardas
    private String password;
    private Boolean admin;
    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SalesLine>salesLineList;


    public User(String companyName, String registrationNumber, String vatNumber, String telephoneNumber, String address, String email, String bankData, String username, String password, Boolean admin, Boolean enabled, List<SalesLine> salesLineList) {
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.vatNumber = vatNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.email = email;
        this.bankData = bankData;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.enabled = enabled;
        this.salesLineList = salesLineList;
    }

    public User() {
    }
}