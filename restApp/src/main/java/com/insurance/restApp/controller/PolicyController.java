package com.insurance.restApp.controller;

import com.insurance.restApp.api.request.InsuranceRequest;
import com.insurance.restApp.api.response.ClientResponse;
import com.insurance.restApp.api.response.InsuranceResponse;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.entity.InsurancePolicy;
import com.insurance.restApp.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PolicyController {

    private InsuranceService insuranceService;

    @Autowired
    public PolicyController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping({"/api/insurance","/api/insurance/{insuranceId}"})
    ResponseEntity<List<InsuranceResponse>> getInsurance(@PathVariable(name = "insuranceId",required = false)String id){
        List<InsurancePolicy> insurancePolicyList = insuranceService.getInsurancePolicy(id);
        List<InsuranceResponse> responseList = new ArrayList<InsuranceResponse>();
        for (InsurancePolicy policy : insurancePolicyList){
            responseList.add(new InsuranceResponse(policy));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }
    @PostMapping("/api/insurance")
    ResponseEntity<ClientResponse> addInsurance(@RequestBody InsuranceRequest request){
        InsurancePolicy policy = request.mapToEntityInsurancePolicy();
        UUID clientId = request.getClientId();
        Client client = insuranceService.getClient(clientId);
        client.addToInsuranceList(policy);
        insuranceService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientResponse(client));
    }

    @PutMapping("/api/insurance")
    ResponseEntity<InsuranceResponse> updateInsurance(@RequestBody
                                                      InsuranceRequest request){
        InsurancePolicy policy = insuranceService.getInsurance(request.getInsuranceId());
        policy.setPolicyNumber(request.getPolicyNumber());
        policy.setType(request.getType());
        policy.setPremium(request.getPremium());
        policy.setCoverageAmount(request.getCoverageAmount());
        policy.setStartDate(request.getStartDate());
        policy.setEndDate(request.getEndDate());
        policy = insuranceService.addInsurance(policy);
        InsuranceResponse response = new InsuranceResponse(policy);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/api/insurance/{insuranceId}")
    ResponseEntity<InsuranceResponse> deleteInsurance(@PathVariable(name = "insuranceId") String insuranceId){
        InsurancePolicy policy = insuranceService.getInsurance(UUID.fromString(insuranceId));
        insuranceService.removeInsurance(policy);
        InsuranceResponse response = new InsuranceResponse(policy);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
