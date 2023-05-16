package com.example.demo.mapper;

import com.example.demo.dto.TravelDocumentDTO;
import com.example.demo.entity.TravelDocument;
import com.example.demo.enums.DocumentType;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TravelDocumentMapperTest {

    private final TravelDocumentMapper travelDocumentMapper = Mappers.getMapper(TravelDocumentMapper.class);

    @Test
    public void testMapTravelDocumentDTOToTravelDocument() {

        //given
        TravelDocumentDTO travelDocumentDTO = new TravelDocumentDTO();
        travelDocumentDTO.setDocumentType(DocumentType.passport);
        travelDocumentDTO.setExpirationDate(LocalDate.parse(("2023-04-04")));

        //when
        TravelDocument travelDocument = travelDocumentMapper.mapTravelDocumentDTOToTravelDocument(travelDocumentDTO);

        //then
        assertEquals(travelDocumentDTO.getDocumentType(), travelDocument.getDocumentType());
        assertEquals(travelDocumentDTO.getExpirationDate(), travelDocument.getExpirationDate());
    }


}