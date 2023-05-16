package com.example.demo.mapper;

import com.example.demo.dto.TravelDocumentDTO;
import com.example.demo.entity.TravelDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TravelDocumentMapper {
    TravelDocumentDTO mapTravelDocumentToTravelDocumentDTO(TravelDocument travelDocument);

    TravelDocument mapTravelDocumentDTOToTravelDocument(TravelDocumentDTO travelDocumentDTO);
}
