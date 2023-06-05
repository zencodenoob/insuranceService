package com.insurance.restApp.controller;

import com.insurance.restApp.api.request.ClaimRequest;
import com.insurance.restApp.api.response.ClaimsResponse;
import com.insurance.restApp.api.response.InsuranceResponse;
import com.insurance.restApp.entity.Claim;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.entity.InsurancePolicy;
import com.insurance.restApp.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ClaimsController {

    private InsuranceService insuranceService;

    @Autowired
    public ClaimsController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping({"/api/claims","/api/claims/{claimId}"})
    ResponseEntity<List<ClaimsResponse>> getClaims(@PathVariable(required = false,name = "claimId")String claimId){

        List<Claim> claims = insuranceService.getClaims(claimId);
        List<ClaimsResponse> responseList= new ArrayList<ClaimsResponse>();
        for(Claim claim : claims){
            responseList.add(new ClaimsResponse(claim));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PostMapping("/api/claims")
    ResponseEntity<InsuranceResponse> setClaim(@RequestBody ClaimRequest request){
        Claim claim = request.mapToEntityClaim();
        InsurancePolicy policy = insuranceService.getInsurance(request.getInsuranceId());
        policy.setInsuranceClaim(claim);
        policy = insuranceService.addInsurance(policy);
        InsuranceResponse response = new InsuranceResponse(policy);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/api/claims")
    ResponseEntity<ClaimsResponse> updateClaim(@RequestBody ClaimRequest request){
        Claim claim = insuranceService.getClaim(request.getClaimId());
        claim.setClaimStatus(request.isClaimStatus());
        claim.setClaimNumber(request.getClaimNumber());
        claim.setClaimDate(request.getClaimDate());
        claim.setDescription(request.getDescription());
        claim = insuranceService.addClaim(claim);
        return ResponseEntity.status(HttpStatus.OK).body(new ClaimsResponse(claim));
    }
}
