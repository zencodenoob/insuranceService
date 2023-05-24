package com.insurance.restApp.controller;

import com.insurance.restApp.api.response.ClientResponse;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.service.InsuranceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InsuranceRestController {

    private InsuranceService insuranceService;

    @Autowired
    public InsuranceRestController(InsuranceService service){
        this.insuranceService = service;
    }
    @GetMapping({"/api/clients","/api/clients/{clientId}"})
   ResponseEntity<List<ClientResponse>> getClients(@PathVariable(required = false,name = "clientId") String clientId){
        List<Client> clients = insuranceService.getClients(clientId);
        var responseList = mapToClientResponse(clients);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

    private static List<ClientResponse> mapToClientResponse(List<Client> clients){
        List<ClientResponse> responseList = new ArrayList<ClientResponse>();
        for (Client client : clients){
            //map the clients
        }
        return  responseList;
    }

}
