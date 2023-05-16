package com.example.demo.service;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.dto.TravelDocumentDTO;
import com.example.demo.entity.Passenger;
import com.example.demo.entity.TravelDocument;
import com.example.demo.enums.DocumentType;
import com.example.demo.exception.PassengerNotFoundException;
import com.example.demo.mapper.PassengerMapper;
import com.example.demo.mapper.TravelDocumentMapper;
import com.example.demo.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PassengerServiceImplTest {

    private PassengerRepository passengerRepository;
    private PassengerMapper passengerMapper;
    private TravelDocumentMapper travelDocumentMapper;
    private PassengerServiceImpl passengerService;

    @BeforeEach
    void setUp() {
        passengerMapper = mock(PassengerMapper.class);
        travelDocumentMapper = mock(TravelDocumentMapper.class);
        passengerRepository = mock(PassengerRepository.class);
        passengerService = new PassengerServiceImpl(passengerRepository, passengerMapper);
    }

    @Test
    public void testGetAllPassengers() {

        //given
        Passenger passenger1 = createPassenger("John", "Doe");

        Passenger passenger2 = createPassenger("Jane", "Doe");

        PassengerDTO passengerDTO1 = createPassengerDTO("John", "Doe");

        PassengerDTO passengerDTO2 = createPassengerDTO("Jane", "Doe");

        List<Passenger> passengers = Arrays.asList(passenger1, passenger2);
        List<PassengerDTO> expectedPassengerDTOs = Arrays.asList(passengerDTO1, passengerDTO2);

        when(passengerRepository.findAll()).thenReturn(passengers);
        when(passengerMapper.mapPassengerToPassengerDTO(passenger1)).thenReturn(passengerDTO1);
        when(passengerMapper.mapPassengerToPassengerDTO(passenger2)).thenReturn(passengerDTO2);

        //when
        List<PassengerDTO> actualPassengerDTOs = passengerService.getAllPassengers();

        //then
        assertEquals(expectedPassengerDTOs, actualPassengerDTOs);
        verify(passengerRepository).findAll();
        verifyNoMoreInteractions(passengerRepository);
    }

    @Test
    public void testGetPassengerById() {

        //given
        Passenger passenger = new Passenger();
        passenger.setId(1);
        passenger.setFirstName("John");
        passenger.setLastName("Doe");

        TravelDocument travelDocument = new TravelDocument();
        travelDocument.setDocumentType(DocumentType.passport);
        travelDocument.setExpirationDate(LocalDate.parse("2023-02-21"));
        passenger.setTravelDocumentId(travelDocument);

        PassengerDTO expectedPassengerDTO = new PassengerDTO();
        expectedPassengerDTO.setFirstName("John");
        expectedPassengerDTO.setLastName("Doe");

        TravelDocumentDTO travelDocumentDTO = new TravelDocumentDTO();
        travelDocumentDTO.setDocumentType(DocumentType.passport);
        travelDocumentDTO.setExpirationDate(LocalDate.parse("2023-02-21"));
        expectedPassengerDTO.setTravelDocumentId(travelDocumentDTO);

        when(passengerRepository.findById(1)).thenReturn(Optional.of(passenger));
        when(passengerMapper.mapPassengerToPassengerDTO(passenger)).thenReturn(expectedPassengerDTO);
        when(travelDocumentMapper.mapTravelDocumentToTravelDocumentDTO(travelDocument)).thenReturn(travelDocumentDTO);

        //when
        PassengerDTO actualPassengerDTO = passengerService.getPassengerById(1);

        //then
        assertEquals(expectedPassengerDTO.getTravelDocumentId().getExpirationDate(),
                actualPassengerDTO.getTravelDocumentId().getExpirationDate());
        verify(passengerRepository).findById(1);
        verifyNoMoreInteractions(passengerRepository);
    }

    @Test
    public void testGetPassengerByIdNotFound() {
        when(passengerRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(PassengerNotFoundException.class, () -> {
            passengerService.getPassengerById(1);
        });
        assertEquals("There isn't a passenger with this id.", exception.getMessage());
        verify(passengerRepository).findById(1);
        verifyNoMoreInteractions(passengerRepository);
    }

    @Test
    public void testCreatePassenger() {

        //given
        PassengerDTO requestedPassengerDTO = new PassengerDTO();
        requestedPassengerDTO.setFirstName("John");
        requestedPassengerDTO.setLastName("Doe");

        Passenger passenger = new Passenger();
        passenger.setFirstName("John");
        passenger.setLastName("Doe");

        when(passengerMapper.mapPassengerDTOToPassenger(requestedPassengerDTO)).thenReturn(passenger);
        when(passengerRepository.save(passenger)).thenReturn(passenger);
        when(passengerMapper.mapPassengerToPassengerDTO(passenger)).thenReturn(requestedPassengerDTO);

        //when
        PassengerDTO createdPassenger = passengerService.createPassenger(requestedPassengerDTO);

        //then
        assertEquals(passenger.getFirstName(), createdPassenger.getFirstName());
        assertEquals(passenger.getLastName(), createdPassenger.getLastName());
        verify(passengerRepository).save(passenger);
        verifyNoMoreInteractions(passengerRepository);
    }

    @Test
    public void testUpdatePassenger() {

        //given
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName("John");
        passengerDTO.setLastName("Doe");

        Passenger existingPassenger = new Passenger();
        existingPassenger.setFirstName("John");
        existingPassenger.setFirstName("Doe");

        when(passengerMapper.mapPassengerDTOToPassenger(passengerDTO)).thenReturn(existingPassenger);
        when(passengerRepository.findById(1)).thenReturn(Optional.of(existingPassenger));
        when(passengerRepository.save(existingPassenger)).thenReturn(existingPassenger);

        //when
        passengerService.updatePassenger(passengerDTO, 1);

        //then
        assertEquals(passengerDTO.getFirstName(), existingPassenger.getFirstName());
        assertEquals(passengerDTO.getLastName(), existingPassenger.getLastName());
        verify(passengerRepository).findById(1);
        verify(passengerRepository).save(existingPassenger);
    }

    @Test
    public void testUpdatePassengerByIdNotFound() {

        //given
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName("John");
        passengerDTO.setLastName("Doe");

        when(passengerRepository.findById(1)).thenReturn(Optional.empty());

        //when and then
        Exception exception = assertThrows(PassengerNotFoundException.class, () -> {
            passengerService.updatePassenger(passengerDTO, 1);
        });
        assertEquals("There isn't a passenger with this id.", exception.getMessage());
        verify(passengerRepository).findById(1);
        verifyNoMoreInteractions(passengerRepository);
    }

    @Test
    public void testDeletePassenger() {

        //given
        Passenger existingPassenger = new Passenger();
        existingPassenger.setId(1);
        existingPassenger.setFirstName("John");
        existingPassenger.setFirstName("Doe");

        when(passengerRepository.findById(1)).thenReturn(Optional.of(existingPassenger));

        //when
        passengerService.deletePassenger(1);

        //then
        verify(passengerRepository).findById(1);
        verify(passengerRepository).deleteById(1);
        verifyNoMoreInteractions(passengerRepository);
    }

    @Test
    public void testDeletePassengerByIdNotFound() {

        //given
        when(passengerRepository.findById(1)).thenReturn(Optional.empty());

        //when and then
        Exception exception = assertThrows(PassengerNotFoundException.class, () -> {
            passengerService.deletePassenger(1);
        });
        assertEquals("There isn't a passenger with this id.", exception.getMessage());
        verify(passengerRepository).findById(1);
        verifyNoMoreInteractions(passengerRepository);
    }

    private Passenger createPassenger(String firstName, String lastName) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        return passenger;
    }

    private PassengerDTO createPassengerDTO(String firstName, String lastName) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName(firstName);
        passengerDTO.setLastName(lastName);
        return passengerDTO;
    }


}
