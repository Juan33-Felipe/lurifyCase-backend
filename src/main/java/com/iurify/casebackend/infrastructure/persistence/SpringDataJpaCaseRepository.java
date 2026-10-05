package com.iurify.casebackend.infrastructure.persistence;

import com.iurify.casebackend.domain.model.Case;
import com.iurify.casebackend.domain.repository.CaseRepository;
import com.iurify.casebackend.infrastructure.persistence.entity.CaseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SpringDataJpaCaseRepository implements CaseRepository {

    private final JpaCaseRepository jpaRepository;

    public SpringDataJpaCaseRepository(JpaCaseRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Case> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Case> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    private Case toDomain(CaseEntity entity) {
        return new Case(
                entity.getId(),
                entity.getUserId(),
                entity.getDossierNumber(),
                entity.getTitle(),
                entity.getJurisdiction(),
                entity.getStatus(),
                entity.getTrialReadinessScore(),
                entity.getIsSealed(),
                entity.getCreatedAt()
        );
    }
}
