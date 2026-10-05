package com.iurify.casebackend.application.service;

import com.iurify.casebackend.application.exception.ResourceNotFoundException;
import com.iurify.casebackend.domain.model.CanvasVersion;
import com.iurify.casebackend.domain.repository.CanvasVersionRepository;
import com.iurify.casebackend.domain.repository.CaseRepository;

import java.util.UUID;

public class CanvasService {

    private final CaseRepository caseRepository;
    private final CanvasVersionRepository canvasVersionRepository;

    public CanvasService(CaseRepository caseRepository, CanvasVersionRepository canvasVersionRepository) {
        this.caseRepository = caseRepository;
        this.canvasVersionRepository = canvasVersionRepository;
    }

    public CanvasVersion getLatestCanvasForCase(UUID caseId) {
        // Validate case exists first (or we can just check canvas, but good to validate case to return proper error if case doesn't exist vs canvas doesn't exist)
        caseRepository.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("The requested case does not exist."));
        
        return canvasVersionRepository.findLatestByCaseId(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("No canvas found for this case."));
    }
}
