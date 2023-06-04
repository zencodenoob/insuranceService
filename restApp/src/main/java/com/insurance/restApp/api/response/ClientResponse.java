package com.insurance.restApp.api.response;

import com.insurance.restApp.api.request.InsuranceRequest;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.entity.InsurancePolicy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientResponse {

    private UUID Id;
    private String name;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;

    private List<InsuranceResponse> insuranceResponseList;

    public ClientResponse(UUID id, String name, LocalDate dob, String address,
                          String email, String phone, List<InsuranceResponse> insuranceResponseList) {
        Id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.insuranceResponseList = insuranceResponseList;
    }


    public ClientResponse(Client client) {
        this.Id = client.getClientId();
        this.dob = client.getDob();
        this.address = client.getAddress();
        this.name = client.getName();
        this.phone = client.getPhone();
        this.email = client.getEmail();
        if(client.getInsuranceList() != null){
            List<InsuranceResponse> insuranceResponseList= new ArrayList<InsuranceResponse>();
            for(InsurancePolicy insurance : client.getInsuranceList()){
                InsuranceResponse response = new InsuranceResponse();
                response.setInsuranceId(insurance.getInsuranceId());
                response.setPolicyNumber(insurance.getPolicyNumber());
                response.setCoverageAmount(insurance.getCoverageAmount());
                response.setEndDate(insurance.getEndDate());
                response.setPremium(insurance.getPremium());
                response.setStartDate(insurance.getStartDate());
                response.setType(insurance.getType());
                insuranceResponseList.add(response);
            }
            this.setInsuranceResponseList(insuranceResponseList);
        }

    }

    public ClientResponse() {
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

    public List<InsuranceResponse> getInsuranceResponseList() {
        return insuranceResponseList;
    }

    public void setInsuranceResponseList(List<InsuranceResponse> insuranceResponseList) {
        this.insuranceResponseList = insuranceResponseList;
    }
}
