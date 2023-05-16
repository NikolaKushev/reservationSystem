package com.example.demo.service;

import com.example.demo.dto.FlightDTO;

import java.util.List;

public interface FlightService {

    List<FlightDTO> getAllFlightsFromAirport(int id);
    FlightDTO createFlight(FlightDTO flightDTO);
}
