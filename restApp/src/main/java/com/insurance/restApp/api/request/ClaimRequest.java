package com.insurance.restApp.api.request;

import java.time.LocalDate;
import java.util.UUID;

public class ClaimRequest {
    private UUID insuranceId;
    private UUID clientId;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;

    public ClaimRequest(UUID insuranceId, UUID clientId,
                        String claimNumber, String description, LocalDate claimDate) {
        this.insuranceId = insuranceId;
        this.clientId = clientId;
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
    }

    public UUID getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(UUID insuranceId) {
        this.insuranceId = insuranceId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }
}
