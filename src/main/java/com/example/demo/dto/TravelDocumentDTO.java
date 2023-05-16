package com.example.demo.dto;

import com.example.demo.enums.DocumentType;

import java.time.LocalDate;

public class TravelDocumentDTO {

    private LocalDate expirationDate;
    private DocumentType documentType;

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
