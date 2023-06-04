package com.insurance.restApp.api.request;

import com.insurance.restApp.entity.Client;
import com.insurance.restApp.entity.InsurancePolicy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientRequest {

    private UUID clientId;
    private String name;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;

    private List<InsuranceRequest> insuranceRequestList;

    public ClientRequest(UUID clientId, String name, LocalDate dob, String address, String email,
                            String phone, List<InsuranceRequest> insuranceRequestList) {
        this.clientId = clientId;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.insuranceRequestList = insuranceRequestList;
    }

    public ClientRequest(String name, LocalDate dob, String address,
                         String email, String phone, List<InsuranceRequest> insuranceRequestList) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.insuranceRequestList = insuranceRequestList;
    }

    public ClientRequest(String name, LocalDate dob, String address, String email, String phone) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public ClientRequest() {
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

    public List<InsuranceRequest> getInsuranceRequestList() {
        return insuranceRequestList;
    }

    public void setInsuranceRequestList(List<InsuranceRequest> insuranceRequestList) {
        this.insuranceRequestList = insuranceRequestList;
    }

    public UUID getClientId() {

        return clientId;
    }

    public void setClientId(UUID clientId) {

        this.clientId = clientId;
    }
    public Client mapTOEntityClient(){
        Client client = new Client();
        client.setName(this.getName());
        client.setPhone(this.getPhone());
        client.setDob(this.getDob());
        client.setAddress(this.getAddress());
        client.setEmail(this.getEmail());
        if(this.insuranceRequestList != null){
            List<InsurancePolicy> insurancePolicyList = new ArrayList<InsurancePolicy>();
            for(InsuranceRequest request : insuranceRequestList){
                InsurancePolicy policy = new InsurancePolicy();
                policy.setInsuranceId(request.getInsuranceId());
                policy.setPolicyNumber(request.getPolicyNumber());
                policy.setCoverageAmount(request.getCoverageAmount());
                policy.setEndDate(request.getEndDate());
                policy.setPremium(request.getPremium());
                policy.setStartDate(request.getStartDate());
                policy.setType(request.getType());
                insurancePolicyList.add(policy);
            }
            client.setInsuranceList(insurancePolicyList);
        }
        return client;
    }
}
