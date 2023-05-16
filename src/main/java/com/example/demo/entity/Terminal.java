package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Setter
@Entity
@Table(name = "terminal")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "terminal_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private Airport airportId;

    @Column(name = "num", nullable = false)
    private int num;

}
