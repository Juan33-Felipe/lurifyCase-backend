package com.iurify.casebackend.infrastructure.controller.mapper;

import com.iurify.casebackend.domain.model.CanvasVersion;
import com.iurify.casebackend.domain.model.Case;
import com.iurify.casebackend.infrastructure.controller.dto.CanvasSnapshotDto;
import com.iurify.casebackend.infrastructure.controller.dto.CaseDto;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    public CaseDto toCaseDto(Case caseModel) {
        CaseDto dto = new CaseDto();
        dto.setId(caseModel.getId());
        dto.setTitle(caseModel.getTitle());
        dto.setStatus(caseModel.getStatus());
        dto.setCreatedAt(caseModel.getCreatedAt());
        return dto;
    }

    public CanvasSnapshotDto toCanvasSnapshotDto(CanvasVersion canvasVersion) {
        CanvasSnapshotDto dto = new CanvasSnapshotDto();
        dto.setCaseId(canvasVersion.getCaseId());
        dto.setVersion(canvasVersion.getVersionNumber());
        dto.setUpdatedAt(canvasVersion.getCreatedAt());
        dto.setCanvas(canvasVersion.getGraphData());
        return dto;
    }
}
