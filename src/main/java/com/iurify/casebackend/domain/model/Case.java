package com.iurify.casebackend.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Case {
    private UUID id;
    private UUID userId;
    private String dossierNumber;
    private String title;
    private String jurisdiction;
    private String status;
    private BigDecimal trialReadinessScore;
    private Boolean isSealed;
    private Instant createdAt;

    public Case() {}

    public Case(UUID id, UUID userId, String dossierNumber, String title, 
                String jurisdiction, String status, BigDecimal trialReadinessScore, 
                Boolean isSealed, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.dossierNumber = dossierNumber;
        this.title = title;
        this.jurisdiction = jurisdiction;
        this.status = status;
        this.trialReadinessScore = trialReadinessScore;
        this.isSealed = isSealed;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public String getDossierNumber() { return dossierNumber; }
    public void setDossierNumber(String dossierNumber) { this.dossierNumber = dossierNumber; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getJurisdiction() { return jurisdiction; }
    public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public BigDecimal getTrialReadinessScore() { return trialReadinessScore; }
    public void setTrialReadinessScore(BigDecimal trialReadinessScore) { this.trialReadinessScore = trialReadinessScore; }
    public Boolean getIsSealed() { return isSealed; }
    public void setIsSealed(Boolean isSealed) { this.isSealed = isSealed; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
