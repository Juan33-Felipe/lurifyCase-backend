package com.iurify.casebackend.infrastructure.persistence;

import com.iurify.casebackend.domain.model.CanvasVersion;
import com.iurify.casebackend.domain.repository.CanvasVersionRepository;
import com.iurify.casebackend.infrastructure.persistence.entity.CanvasVersionEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SpringDataJpaCanvasVersionRepository implements CanvasVersionRepository {

    private final JpaCanvasVersionRepository jpaRepository;

    public SpringDataJpaCanvasVersionRepository(JpaCanvasVersionRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<CanvasVersion> findLatestByCaseId(UUID caseId) {
        return jpaRepository.findFirstByCaseIdOrderByVersionNumberDesc(caseId)
                .map(this::toDomain);
    }

    private CanvasVersion toDomain(CanvasVersionEntity entity) {
        return new CanvasVersion(
                entity.getId(),
                entity.getCaseId(),
                entity.getVersionNumber(),
                entity.getParentVersionId(),
                entity.getOrigin(),
                entity.getGraphData(),
                entity.getCreatedAt()
        );
    }
}
