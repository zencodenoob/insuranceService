package com.insurance.restApp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private boolean claimStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id")
    private InsurancePolicy insurance;

    public Claim(String claimNumber, String description, LocalDate claimDate,
                 boolean claimStatus, InsurancePolicy insurance) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.insurance = insurance;
    }

    public Claim() {
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

    public InsurancePolicy getInsurance() {
        return insurance;
    }

    public void setInsurance(InsurancePolicy insurance) {
        this.insurance = insurance;
    }
}
