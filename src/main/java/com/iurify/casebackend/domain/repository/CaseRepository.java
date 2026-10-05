package com.iurify.casebackend.domain.repository;

import com.iurify.casebackend.domain.model.Case;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaseRepository {
    List<Case> findAll();
    Optional<Case> findById(UUID id);
}
