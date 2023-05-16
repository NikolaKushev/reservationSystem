package com.example.demo.mapper;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.entity.Passenger;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class PassengerMapperTest {

    private final PassengerMapper mapper = Mappers.getMapper(PassengerMapper.class);

    @Test
    public void testMappingPassengerToPassengerDTO() {

        //given
        Passenger passenger = new Passenger();
        passenger.setFirstName("nikola");
        passenger.setLastName("kushev");

        //when
        PassengerDTO passengerDTO = mapper.mapPassengerToPassengerDTO(passenger);

        //then
        assertEquals(passenger.getFirstName(), passengerDTO.getFirstName());
        assertEquals(passenger.getLastName(), passengerDTO.getLastName());
    }

    @Test
    public void testMappingPassengerDTOToPassenger() {

        //given
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName("nikola");
        passengerDTO.setLastName("kushev");

        //when
        Passenger passenger = mapper.mapPassengerDTOToPassenger(passengerDTO);

        //then
        assertEquals(passenger.getFirstName(), passengerDTO.getFirstName());
        assertEquals(passenger.getLastName(), passengerDTO.getLastName());
    }


}