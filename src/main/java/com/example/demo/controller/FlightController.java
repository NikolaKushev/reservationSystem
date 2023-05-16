package com.example.demo.controller;

import com.example.demo.dto.FlightDTO;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FlightDTO>> getAllFLightsFromAirportById(@PathVariable int id){
        List<FlightDTO> flightDTOS = flightService.getAllFlightsFromAirport(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightDTOS);
    }

    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDTO){
        FlightDTO createdFlight = flightService.createFlight(flightDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdFlight);
    }

}
