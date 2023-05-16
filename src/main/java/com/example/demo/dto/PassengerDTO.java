package com.example.demo.dto;

public class PassengerDTO {

    private String firstName;
    private String lastName;
    private TravelDocumentDTO travelDocumentId;

    public TravelDocumentDTO getTravelDocumentId() {
        return travelDocumentId;
    }

    public void setTravelDocumentId(TravelDocumentDTO travelDocumentId) {
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
