package com.example.demo.entity;

import com.example.demo.enums.CountryName;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CountryName name;

    @OneToMany(mappedBy = "countryId")
    private List<City> cities;
}
