package com.insurance.restApp.service;

import com.insurance.restApp.entity.Claim;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.entity.InsurancePolicy;
import com.insurance.restApp.repository.ClaimsRepository;
import com.insurance.restApp.repository.ClientRepository;
import com.insurance.restApp.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InsuranceService {

    private ClientRepository clientRepo;
    private InsuranceRepository insuranceRepo;
    private ClaimsRepository claimsRepo;

    @Autowired
    public InsuranceService(ClientRepository clientRepo,InsuranceRepository insuranceRepo,
                            ClaimsRepository claimsRepo){
        this.claimsRepo = claimsRepo;
        this.insuranceRepo = insuranceRepo;
        this.clientRepo = clientRepo;
    }

    public List<Client> getClients(String clientId){
        if (clientId == null){
            return clientRepo.findAll();
        }
        return clientRepo.findAllById(List.of(UUID.fromString(clientId)));
    }

    public Client addClient(Client client){

        return clientRepo.save(client);
    }
    public void removeClient(Client client){

        clientRepo.delete(client);
    }
    public List<InsurancePolicy> getInsurancePolicy(String insuranceId){
        if (insuranceId.isEmpty()){
            return insuranceRepo.findAll();
        }
        return insuranceRepo.findAllById(List.of(UUID.fromString(insuranceId)));
    }
    public InsurancePolicy addInsurance(InsurancePolicy insurancePolicy){

        return insuranceRepo.save(insurancePolicy);
    }
    public void removeInsurance(InsurancePolicy insurancePolicy){

        insuranceRepo.delete(insurancePolicy);
    }

    public List<Claim> getClaims(String claimId){
        if (claimId.isEmpty()){
            return claimsRepo.findAll();
        }
        return claimsRepo.findAllById(List.of(UUID.fromString(claimId)));
    }
    public Claim addClaim(Claim claim){

        return claimsRepo.save(claim);
    }
    public void removeClaim(Claim claim){

        claimsRepo.delete(claim);
    }

    public Client getClient(UUID clientId) {
        return clientRepo.getById(clientId);
    }
}
