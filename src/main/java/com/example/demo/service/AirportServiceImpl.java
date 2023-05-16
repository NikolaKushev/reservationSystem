package com.example.demo.service;

import com.example.demo.dto.AirportDTO;
import com.example.demo.entity.Airport;
import com.example.demo.exception.AirportNotFoundException;
import com.example.demo.mapper.AirportMapper;
import com.example.demo.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public AirportServiceImpl(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    /**
     * Retrieves the airport with the wanted id.
     *
     * @param id The id of the airports to be retrieved.
     * @return DTO with the matching id.
     * @throws AirportNotFoundException when there isn't an airport with the wanted id.
     */
    @Override
    public Airport getAirportById(int id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);
        if(optionalAirport.isPresent()){
            return optionalAirport.get();
        }
        throw new AirportNotFoundException("There isn't an airport with this id.");
    }

    @Override
    public AirportDTO createAirport(AirportDTO airportDTO){
        Airport airport = airportMapper.mapAirportDTOToAirport(airportDTO);
        airportRepository.save(airport);
        return airportMapper.mapAirportToDTO(airport);
    }
}
