package com.example.demo.mapper;

import com.example.demo.dto.AirportDTO;
import com.example.demo.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FlightMapper.class)
public interface AirportMapper {

    AirportDTO mapAirportToDTO(Airport airport);

    Airport mapAirportDTOToAirport(AirportDTO airportDTO);

}

