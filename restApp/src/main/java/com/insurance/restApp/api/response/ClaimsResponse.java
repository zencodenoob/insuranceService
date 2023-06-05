package com.insurance.restApp.api.response;

import com.insurance.restApp.entity.Claim;

import java.time.LocalDate;
import java.util.UUID;

public class ClaimsResponse {
    private UUID id;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private boolean claimStatus;

    public ClaimsResponse(UUID id, String claimNumber, String description,
                          LocalDate claimDate, boolean claimStatus) {
        this.id = id;
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

    public ClaimsResponse(Claim claim) {
        this.id = claim.getId();
        this.claimNumber = claim.getClaimNumber();
        this.description = claim.getDescription();
        this.claimDate = claim.getClaimDate();
        this.claimStatus = claim.isClaimStatus();
    }

    public ClaimsResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public boolean isClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(boolean claimStatus) {
        this.claimStatus = claimStatus;
    }
}
