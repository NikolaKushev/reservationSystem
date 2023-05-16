package com.example.demo.service;

import com.example.demo.entity.Airline;
import com.example.demo.exception.AirlineNotFoundException;
import com.example.demo.mapper.AirlineMapper;
import com.example.demo.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService{

    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline getAirlineById(int id) {
        Optional<Airline> optionalAirline = airlineRepository.findById(id);
        if(optionalAirline.isPresent()){
            Airline airline = optionalAirline.get();
            return airline;
        }
        throw new AirlineNotFoundException("There isn't an airline with this id.");
    }
}
