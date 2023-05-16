package com.example.demo.service;

import com.example.demo.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {

    List<PassengerDTO> getAllPassengers();

    PassengerDTO getPassengerById(int id);

    PassengerDTO createPassenger(PassengerDTO passengerDTO);

    void updatePassenger(PassengerDTO passengerDTO, int id);

    void deletePassenger(int id);


}
