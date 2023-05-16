package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City cityId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airportId")
    private List<Terminal> terminals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
