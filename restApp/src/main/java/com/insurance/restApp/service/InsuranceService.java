package com.insurance.restApp.service;

import com.insurance.restApp.entity.Claim;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.entity.InsurancePolicy;
import com.insurance.restApp.exception.InvalidClaimsException;
import com.insurance.restApp.exception.InvalidClientException;
import com.insurance.restApp.exception.InvalidPolicyException;
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
        try{
            List<Client> clientList = clientRepo.findAllById(List.of(UUID.fromString(clientId)));
            if (clientList.isEmpty()) throw new Exception("");
            return clientList;
        }
        catch (Exception e) {
            throw new InvalidClientException("Invalid Id");
        }
    }

    public Client addClient(Client client){

        return clientRepo.save(client);
    }
    public void removeClient(Client client){

        clientRepo.delete(client);
    }
    public List<InsurancePolicy> getInsurancePolicy(String insuranceId) throws InvalidPolicyException {
        if (insuranceId == null){
            return insuranceRepo.findAll();
        }
        try{
            List<InsurancePolicy> policyList = insuranceRepo.findAllById(List.of(UUID.fromString(insuranceId)));
            if(policyList.isEmpty()) throw new Exception("");
            return policyList;}
        catch (Exception e){
            throw new InvalidPolicyException("Invalid Insurance Id");
        }
    }
    public InsurancePolicy addInsurance(InsurancePolicy insurancePolicy){

        return insuranceRepo.save(insurancePolicy);
    }
    public void removeInsurance(InsurancePolicy insurancePolicy){

        insuranceRepo.delete(insurancePolicy);
    }

    public List<Claim> getClaims(String claimId) throws InvalidClaimsException{
        if (claimId == null){
            return claimsRepo.findAll();
        }
        try {
            List<Claim> claimList = claimsRepo.findAllById(List.of(UUID.fromString(claimId)));
            if(claimList.isEmpty()) throw new Exception("");
            return claimList;
        }
        catch (Exception e){
            throw new InvalidClaimsException("Invalid Claim Id");
        }
    }
    public Claim addClaim(Claim claim){

        return claimsRepo.save(claim);
    }
    public void removeClaim(Claim claim){

        claimsRepo.delete(claim);
    }

    public Client getClient(UUID clientId) throws  InvalidClientException{
        try{
            Client client = clientRepo.getById(clientId);
            if(client.getName() == null) throw new Exception("");
            return client;
        }
        catch (Exception e){
            throw new InvalidClientException("Invalid Client Id");
        }
    }

    public InsurancePolicy getInsurance(UUID insuranceId) throws InvalidPolicyException{
        try{
            InsurancePolicy policy = insuranceRepo.getById(insuranceId);
            if (policy.getPolicyNumber() == null) throw new Exception("");
            return policy;
        }
        catch (Exception e){
            throw new InvalidPolicyException("Invalid Insurance Id");
        }
    }

    public Claim getClaim(UUID claimId) throws InvalidClaimsException{
        try {
            Claim claim = claimsRepo.getById(claimId);
            if(claim.getClaimNumber() == null) throw new Exception("");
            return claim;
        }
        catch (Exception e){
            throw new InvalidClaimsException("Invalid Claim Id");
        }
    }
}
