package com.example.demo.exception;

public class AirlineNotFoundException extends RuntimeException {
    public AirlineNotFoundException(String message) {
        super(message);
    }
}
