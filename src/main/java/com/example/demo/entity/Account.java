package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private int id;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "accountId")
    private List<Reservation> reservations;
}