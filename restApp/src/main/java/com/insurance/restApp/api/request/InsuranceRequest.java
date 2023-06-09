package com.insurance.restApp.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.insurance.restApp.entity.InsurancePolicy;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.util.UUID;

public class InsuranceRequest {



    private UUID insuranceId;

    private UUID clientId;

    @Size(min = 9,max = 15)
    private String policyNumber;

    @NotNull
    private String type;

    @Range(min = 50000, max = 10000000)
    private int coverageAmount;


    @Min(1000)
    private int premium;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public InsuranceRequest(UUID insuranceId, UUID clientId, String policyNumber, String type, int coverageAmount,
                            int premium, LocalDate startDate, LocalDate endDate) {
        this.insuranceId = insuranceId;
        this.clientId = clientId;
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public InsuranceRequest(UUID clientId, String policyNumber, String type, int coverageAmount,
                            int premium, LocalDate startDate, LocalDate endDate) {
        this.clientId = clientId;
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public InsuranceRequest(String policyNumber, String type,
                            int coverageAmount, int premium, LocalDate startDate, LocalDate endDate) {
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public InsuranceRequest() {
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
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

    public UUID getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(UUID insuranceId) {
        this.insuranceId = insuranceId;
    }

    public InsurancePolicy mapToEntityInsurancePolicy(){
        InsurancePolicy policy = new InsurancePolicy();
        policy.setCoverageAmount(this.coverageAmount);
        policy.setPolicyNumber(this.policyNumber);
        policy.setStartDate(this.startDate);
        policy.setEndDate(this.endDate);
        policy.setType(this.type);
        policy.setPremium(this.premium);
        return policy;
    }
}
