package com.insurance.restApp.api.response;

import com.insurance.restApp.entity.InsurancePolicy;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ClientResponse {

    private UUID Id;
    private String name;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;

    private List<InsurancePolicy> insurancePolicyList;

    public ClientResponse(UUID id, String name, LocalDate dob, String address,
                          String email, String phone, List<InsurancePolicy> insurancePolicyList) {
        Id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.insurancePolicyList = insurancePolicyList;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<InsurancePolicy> getInsurancePolicyList() {
        return insurancePolicyList;
    }

    public void setInsurancePolicyList(List<InsurancePolicy> insurancePolicyList) {
        this.insurancePolicyList = insurancePolicyList;
    }
}
