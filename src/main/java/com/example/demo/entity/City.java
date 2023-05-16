package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country countryId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "cityId")
    private List<Airport> airports;
}