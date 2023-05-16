package com.example.demo.repository;

import com.example.demo.entity.TravelDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelDocumentRepository extends JpaRepository<TravelDocument, Integer> {
}
