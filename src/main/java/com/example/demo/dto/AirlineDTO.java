package com.example.demo.dto;

import java.sql.Time;

public class AirlineDTO {

    private String name;
    private Time checkInDeadline;
    private String checkInOpens;
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
