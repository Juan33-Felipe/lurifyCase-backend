package com.iurify.casebackend.infrastructure.controller;

import com.iurify.casebackend.application.service.CanvasService;
import com.iurify.casebackend.application.service.CaseService;
import com.iurify.casebackend.domain.model.CanvasVersion;
import com.iurify.casebackend.domain.model.Case;
import com.iurify.casebackend.infrastructure.controller.dto.CanvasSnapshotDto;
import com.iurify.casebackend.infrastructure.controller.dto.CaseDto;
import com.iurify.casebackend.infrastructure.controller.dto.CaseListDto;
import com.iurify.casebackend.infrastructure.controller.dto.PageInfoDto;
import com.iurify.casebackend.infrastructure.controller.mapper.DtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {

    private final CaseService caseService;
    private final CanvasService canvasService;
    private final DtoMapper dtoMapper;

    public CaseController(CaseService caseService, CanvasService canvasService, DtoMapper dtoMapper) {
        this.caseService = caseService;
        this.canvasService = canvasService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public CaseListDto listCases() {
        List<Case> cases = caseService.listAllCases();
        List<CaseDto> caseDtos = cases.stream()
                .map(dtoMapper::toCaseDto)
                .collect(Collectors.toList());
        return new CaseListDto(caseDtos, new PageInfoDto(false, null));
    }

    @GetMapping("/{id}")
    public CaseDto getCase(@PathVariable UUID id) {
        Case caseModel = caseService.getCaseById(id);
        return dtoMapper.toCaseDto(caseModel);
    }

    @GetMapping("/{id}/canvas")
    public CanvasSnapshotDto getCanvas(@PathVariable UUID id) {
        CanvasVersion canvasVersion = canvasService.getLatestCanvasForCase(id);
        return dtoMapper.toCanvasSnapshotDto(canvasVersion);
    }
}
