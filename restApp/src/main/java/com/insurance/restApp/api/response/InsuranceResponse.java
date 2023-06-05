package com.insurance.restApp.api.response;

import com.insurance.restApp.entity.Claim;
import com.insurance.restApp.entity.InsurancePolicy;

import java.time.LocalDate;
import java.util.UUID;

public class InsuranceResponse {

    private UUID insuranceId;
    private String policyNumber;
    private String type;
    private int coverageAmount;
    private int premium;
    private LocalDate startDate;
    private LocalDate endDate;

    private Claim claim;

    public InsuranceResponse(UUID insuranceId, String policyNumber, String type,
                             int coverageAmount, int premium, LocalDate startDate, LocalDate endDate, Claim claim) {
        this.insuranceId = insuranceId;
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.claim = claim;
    }


    public InsuranceResponse(InsurancePolicy policy) {

        this.insuranceId =policy.getInsuranceId();
        this.policyNumber = policy.getPolicyNumber();
        this.type = policy.getType();
        this.coverageAmount = policy.getCoverageAmount();
        this.premium = policy.getPremium();
        this.startDate = policy.getStartDate();
        this.endDate = policy.getEndDate();
        this.claim = policy.getInsuraceClaim();
    }
    public InsuranceResponse() {
    }

    public UUID getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(UUID insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
