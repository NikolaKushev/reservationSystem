package com.example.demo.mapper;

import com.example.demo.dto.FlightDTO;
import com.example.demo.entity.Airline;
import com.example.demo.entity.Flight;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring", imports = Airline.class)
public interface FlightMapper {

    @Named("mapFlightToDTO")
    @Mapping(target = "departureAirportId", ignore = true)
    @Mapping(target = "arrivalAirportId", ignore = true)
    @Mapping(target = "airlineId", ignore = true)
    FlightDTO mapFlightToDTO(Flight flight);

    @Mapping(target = "departureAirport", ignore = true)
    @Mapping(target = "arrivalAirport", ignore = true)
    @Mapping(target = "airlineId", ignore = true)
    Flight mapFlightDTToFlight(FlightDTO flightDTO);

    @IterableMapping(qualifiedByName = "mapFlightToDTO")
    Set<FlightDTO> mapDepartureFlightSetToDTO(Set<Flight> flights);


}

