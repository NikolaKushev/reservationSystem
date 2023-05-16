package com.example.demo.service;

import com.example.demo.dto.AirportDTO;
import com.example.demo.entity.Airport;

public interface AirportService {

    Airport getAirportById(int id);
    AirportDTO createAirport(AirportDTO airportDTO);
}
