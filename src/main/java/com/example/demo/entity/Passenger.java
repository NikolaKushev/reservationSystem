package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id", nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "travel_document_id", nullable = false)
    private TravelDocument travelDocumentId;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany(mappedBy = "passengers")
    private Set<Reservation> reservations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TravelDocument getTravelDocumentId() {
        return travelDocumentId;
    }

    public void setTravelDocumentId(TravelDocument travelDocumentId) {
        this.travelDocumentId = travelDocumentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
