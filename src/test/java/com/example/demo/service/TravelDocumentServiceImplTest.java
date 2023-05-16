package com.example.demo.service;

import com.example.demo.dto.TravelDocumentDTO;
import com.example.demo.entity.TravelDocument;
import com.example.demo.enums.DocumentType;
import com.example.demo.mapper.TravelDocumentMapper;
import com.example.demo.repository.TravelDocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TravelDocumentServiceImplTest {

    private TravelDocumentRepository travelDocumentRepository;
    private TravelDocumentMapper travelDocumentMapper;
    private TravelDocumentServiceImpl travelDocumentService;

    @BeforeEach
    void setUp() {
        travelDocumentMapper = mock(TravelDocumentMapper.class);
        travelDocumentRepository = mock(TravelDocumentRepository.class);
        travelDocumentService = new TravelDocumentServiceImpl(travelDocumentRepository, travelDocumentMapper);
    }

    @Test
    public void testCreateTravelDocument() {

        //given
        TravelDocumentDTO travelDocumentDTO = new TravelDocumentDTO();
        travelDocumentDTO.setDocumentType(DocumentType.passport);
        travelDocumentDTO.setExpirationDate(LocalDate.parse("2023-03-04"));

        TravelDocument travelDocument = new TravelDocument();
        travelDocument.setDocumentType(DocumentType.passport);
        travelDocument.setExpirationDate(LocalDate.parse("2023-03-04"));

        when(travelDocumentRepository.save(travelDocument)).thenReturn(travelDocument);
        when(travelDocumentMapper.mapTravelDocumentDTOToTravelDocument(travelDocumentDTO)).thenReturn(travelDocument);
        when(travelDocumentMapper.mapTravelDocumentToTravelDocumentDTO(travelDocument)).thenReturn(travelDocumentDTO);

        //when
        travelDocumentService.createTravelDocument(travelDocumentDTO);

        //then
        assertEquals(travelDocument.getDocumentType(), travelDocumentDTO.getDocumentType());
        assertEquals(travelDocument.getExpirationDate(), travelDocumentDTO.getExpirationDate());
        verify(travelDocumentRepository).save(travelDocument);
        verifyNoMoreInteractions(travelDocumentRepository);
    }
}