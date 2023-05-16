package com.example.demo.controller;

import com.example.demo.entity.TravelDocument;
import com.example.demo.repository.TravelDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("travel_document")
public class TravelDocumentController {

    private final TravelDocumentRepository travelDocumentRepository;

    @Autowired
    public TravelDocumentController(TravelDocumentRepository travelDocumentRepository) {
        this.travelDocumentRepository = travelDocumentRepository;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TravelDocument>> getAllDocuments(){
        List<TravelDocument> travelDocuments = travelDocumentRepository.findAll();
        return new ResponseEntity<>(travelDocuments, HttpStatus.OK);
    }
}
