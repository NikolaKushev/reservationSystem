package com.example.demo.controller;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<List<PassengerDTO>> getAllPassengers(){
        List<PassengerDTO> allPassengers = passengerService.getAllPassengers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(allPassengers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable int id){
        PassengerDTO passengerDTO = passengerService.getPassengerById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(passengerDTO);
    }

    @PostMapping
    public ResponseEntity<PassengerDTO> createPassenger(@RequestBody PassengerDTO passengerDTO){
        PassengerDTO createdPassenger = passengerService.createPassenger(passengerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdPassenger);
    }

    @PutMapping("/{id}")
    public void updatePassenger(@PathVariable int id, @RequestBody PassengerDTO passengerDTO){
        passengerService.updatePassenger(passengerDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable int id){
        passengerService.deletePassenger(id);
    }
}
