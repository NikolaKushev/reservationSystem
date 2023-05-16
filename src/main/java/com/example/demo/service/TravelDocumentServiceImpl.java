package com.example.demo.service;

import com.example.demo.dto.TravelDocumentDTO;
import com.example.demo.entity.TravelDocument;
import com.example.demo.mapper.TravelDocumentMapper;
import com.example.demo.repository.TravelDocumentRepository;
import org.springframework.stereotype.Service;

/**
 * Does the creating of the TravelDocument.
 */
@Service
public class TravelDocumentServiceImpl implements TravelDocumentService {

    private final TravelDocumentRepository travelDocumentRepository;
    private final TravelDocumentMapper travelDocumentMapper;

    public TravelDocumentServiceImpl(TravelDocumentRepository travelDocumentRepository,
                                     TravelDocumentMapper travelDocumentMapper) {
        this.travelDocumentRepository = travelDocumentRepository;
        this.travelDocumentMapper = travelDocumentMapper;
    }

    /**
     * Creates a TravelDocument based on the data from the DTO.
     *
     * @param requestedTravelDocumentDTO  the DTO containing the data for the new TravelDocument
     * @return TravelDocumentDTO containing the created travel document.
     */
    @Override
    public TravelDocumentDTO createTravelDocument(TravelDocumentDTO requestedTravelDocumentDTO) {
        TravelDocument respondedTravelDocument = travelDocumentMapper.mapTravelDocumentDTOToTravelDocument(requestedTravelDocumentDTO);
        travelDocumentRepository.save(respondedTravelDocument);
        return travelDocumentMapper.mapTravelDocumentToTravelDocumentDTO(respondedTravelDocument);
    }
}
