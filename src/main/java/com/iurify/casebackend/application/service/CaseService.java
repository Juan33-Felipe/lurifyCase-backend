package com.iurify.casebackend.application.service;

import com.iurify.casebackend.application.exception.ResourceNotFoundException;
import com.iurify.casebackend.domain.model.Case;
import com.iurify.casebackend.domain.repository.CaseRepository;

import java.util.List;
import java.util.UUID;

public class CaseService {
    
    private final CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> listAllCases() {
        return caseRepository.findAll();
    }

    public Case getCaseById(UUID id) {
        return caseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The requested case does not exist."));
    }
}
