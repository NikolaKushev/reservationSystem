package com.example.demo.mapper;

import com.example.demo.dto.AirlineDTO;
import com.example.demo.entity.Airline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineMapper {

    AirlineDTO mapAirlineToDTO(Airline airline);
    Airline mapAirlineDTOToAirline(AirlineDTO airlineDTO);

}
