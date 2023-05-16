package com.example.demo.repository;

import com.example.demo.dto.AirportDTO;
import com.example.demo.entity.Airport;
import com.example.demo.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Set<Flight> findByDepartureAirport(Airport airport);
}
