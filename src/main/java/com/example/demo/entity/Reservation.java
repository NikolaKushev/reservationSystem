package com.example.demo.entity;

import com.example.demo.enums.Status;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flightId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account accountId;

    @Column(name = "date_of_reservation", nullable = false)
    private Date reservationDate;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservationId")
    private List<Ticket> tickets;

    @ManyToMany
    @JoinTable(
            name = "reservation_passenger",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private Set<Passenger> passengers;
}
