package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;


@Setter
@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "check_in_deadline", nullable = false)
    private Time checkInDeadline;

    @Column(name = "check_in_opens", nullable = false)
    private String checkInOpens;

    @Column(name = "check_in_without_seat_selection", nullable = false)
    private String checkInWithoutSeat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getCheckInDeadline() {
        return checkInDeadline;
    }

    public void setCheckInDeadline(Time checkInDeadline) {
        this.checkInDeadline = checkInDeadline;
    }

    public String getCheckInOpens() {
        return checkInOpens;
    }

    public void setCheckInOpens(String checkInOpens) {
        this.checkInOpens = checkInOpens;
    }

    public String getCheckInWithoutSeat() {
        return checkInWithoutSeat;
    }

    public void setCheckInWithoutSeat(String checkInWithoutSeat) {
        this.checkInWithoutSeat = checkInWithoutSeat;
    }
}