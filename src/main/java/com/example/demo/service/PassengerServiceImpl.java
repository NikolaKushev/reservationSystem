package com.example.demo.service;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.entity.Passenger;
import com.example.demo.exception.PassengerNotFoundException;
import com.example.demo.mapper.PassengerMapper;
import com.example.demo.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Performs all the CRUD operations for the passenger entity.
 */
@Service
public class PassengerServiceImpl implements PassengerService{

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository,
                                PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    /**
     * Retrieves all passengers.
     *
     * @return A list of all the passengers in the database.
     */
    @Override
    public List<PassengerDTO> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        return passengers
                .stream()
                .map(passengerMapper::mapPassengerToPassengerDTO)
                .toList();
    }

    /**
     * Retrieves a passenger based on its id.
     *
     * @param id  the id of the passenger to be retrieved
     * @return The DTO with the matching id.
     * @throws PassengerNotFoundException if there isn't a passenger with this id.
     */

    @Override
    public PassengerDTO getPassengerById(int id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if(optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            return passengerMapper.mapPassengerToPassengerDTO(passenger);
        }
        throw new PassengerNotFoundException("There isn't a passenger with this id.");
    }


    /**
     * Creates a passenger based on the data from DTO.
     *
     * @param requestedPassengerDTO  the DTO containing the data for the new passenger
     * @return PassengerDTO representing the created passenger.
     */
    @Override
    public PassengerDTO createPassenger(PassengerDTO requestedPassengerDTO) {
        Passenger passenger = passengerMapper.mapPassengerDTOToPassenger(requestedPassengerDTO);
        passengerRepository.save(passenger);
        return passengerMapper.mapPassengerToPassengerDTO(passenger);
    }

    /**
     * Updates a passenger based on its id using the data from the DTO.
     *
     * @param passengerDTO  the DTO containing the updated data
     * @param id  the id of the passenger to update
     * @throws PassengerNotFoundException if there isn't a passenger with this id.
     */
    @Override
    public void updatePassenger(PassengerDTO passengerDTO, int id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if(optionalPassenger.isEmpty()) {
            throw new PassengerNotFoundException("There isn't a passenger with this id.");
        }
        Passenger passenger = optionalPassenger.get();
        passenger.setFirstName(passengerDTO.getFirstName());
        passenger.setLastName(passengerDTO.getLastName());
        passengerRepository.save(passenger);
    }

    /**
     * Deleting a passenger based on its id.
     *
     * @param id  the id of the passenger to delete
     * @throws PassengerNotFoundException if there isn't passenger with this id.
     */
    @Override
    public void deletePassenger(int id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if(optionalPassenger.isEmpty()){
            throw new PassengerNotFoundException("There isn't a passenger with this id.");
        }
        passengerRepository.deleteById(id);
    }

}
