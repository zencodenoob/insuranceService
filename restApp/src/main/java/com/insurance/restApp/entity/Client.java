package com.insurance.restApp.entity;

import com.insurance.restApp.api.request.InsuranceRequest;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID clientId;
    private String name;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<InsurancePolicy> insuranceList;

    public Client(String name, LocalDate dob, String address,
                  String email, String phone, List<InsurancePolicy> insuranceList) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.insuranceList = insuranceList;
    }

    public Client(String name, LocalDate dob, String address, String email, String phone) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Client() {
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

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public List<InsurancePolicy> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<InsurancePolicy> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public void addToInsuranceList(InsurancePolicy policy) {
        this.getInsuranceList().add(policy);
    }
}
