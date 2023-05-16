package com.example.demo.mapper;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.entity.Passenger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerDTO mapPassengerToPassengerDTO(Passenger passenger);
    Passenger mapPassengerDTOToPassenger(PassengerDTO passengerDTO);
}
