package com.example.demo.service;

import com.example.demo.dto.FlightDTO;
import com.example.demo.entity.Airline;
import com.example.demo.entity.Airport;
import com.example.demo.entity.Flight;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FlightServiceImpl implements FlightService {

    private final AirportService airportService;
    private final AirlineService airlineService;
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public FlightServiceImpl(AirportService airportService,
                             AirlineService airlineService,
                             FlightRepository flightRepository,
                             FlightMapper flightMapper) {
        this.airportService = airportService;
        this.airlineService = airlineService;
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    /**
     * Retrieves all the flights based on the airport id.
     * @param id  The id of the airport.
     * @return  List of the flights which departure airport's matches the wanted airport id.
     */
    @Override
    public List<FlightDTO> getAllFlightsFromAirport(int id) {
        Airport airport = airportService.getAirportById(id);
        Set<Flight> flights = getAllDepartureFlights(airport);
        return flightMapper.mapDepartureFlightSetToDTO(flights)
                .stream()
                .toList();
    }

    /**
     * Creates a flight based on the data from the DTO.
     * @param requestedFlightDTO  the DTO containing the data for the wanted flight.
     * @return DTO representing the created flight.
     */
    @Override
    public FlightDTO createFlight(FlightDTO requestedFlightDTO) {
        Airport departureAirport = airportService.getAirportById(requestedFlightDTO.getDepartureAirportId());
        Airport arrivalAirport = airportService.getAirportById(requestedFlightDTO.getArrivalAirportId());
        Airline airline = airlineService.getAirlineById(requestedFlightDTO.getAirlineId());
        Flight flight = flightMapper.mapFlightDTToFlight(requestedFlightDTO);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setAirlineId(airline);
        flightRepository.save(flight);
        return flightMapper.mapFlightToDTO(flight);
    }

    /**
     * Retrieves the departure flight based on the airport.
     * @param airport  the airport that is looked for.
     * @return  Set of flights that have the wanted airport.
     */
    private Set<Flight> getAllDepartureFlights(Airport airport) {
        return flightRepository.findByDepartureAirport(airport);
    }
}
