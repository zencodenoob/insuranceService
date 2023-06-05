package com.insurance.restApp.api.request;


import com.insurance.restApp.entity.Claim;

import java.time.LocalDate;
import java.util.UUID;

public class ClaimRequest {
    private UUID insuranceId;

    private UUID claimId;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;

    private Boolean claimStatus;

    public ClaimRequest(UUID insuranceId, String claimNumber,
                        String description, LocalDate claimDate, Boolean claimStatus, UUID claimId) {
        this.insuranceId = insuranceId;
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.claimId = claimId;
    }

    public ClaimRequest() {
    }

    public UUID getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(UUID insuranceId) {
        this.insuranceId = insuranceId;
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

    public void setClaimStatus(Boolean claimStatus) {
        this.claimStatus = claimStatus;
    }

    public UUID getClaimId() {
        return claimId;
    }

    public void setClaimId(UUID claimId) {
        this.claimId = claimId;
    }

    public Claim mapToEntityClaim(){
        Claim claim = new Claim();
        claim.setClaimDate(this.claimDate);
        claim.setClaimNumber(this.claimNumber);
        claim.setDescription(this.description);
        if(this.claimStatus == null) claim.setClaimStatus(false);
        else claim.setClaimStatus(this.claimStatus);
        return claim;
    }


}
