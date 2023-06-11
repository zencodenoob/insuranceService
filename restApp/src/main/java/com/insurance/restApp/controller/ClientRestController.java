package com.insurance.restApp.controller;

import com.insurance.restApp.api.request.ClientRequest;
import com.insurance.restApp.api.response.ClientResponse;
import com.insurance.restApp.entity.Client;
import com.insurance.restApp.service.InsuranceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ClientRestController {

    private InsuranceService insuranceService;

    @Autowired
    public ClientRestController(InsuranceService service){
        this.insuranceService = service;
    }

    @GetMapping({"/api/clients","/api/clients/{clientId}"})
    ResponseEntity<List<ClientResponse>> getClients(@PathVariable(required = false,name = "clientId") String clientId){

        List<Client> clients = insuranceService.getClients(clientId);
        List<ClientResponse> responseList = new ArrayList<ClientResponse>();
        for (Client client : clients){
            responseList.add(new ClientResponse(client));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseList);

    }
    @PostMapping("/api/clients")
    ResponseEntity<ClientResponse> saveClient(@RequestBody @Valid ClientRequest request){
        Client client = request.mapTOEntityClient();
        client = insuranceService.addClient(client);
        ClientResponse response = new ClientResponse(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/api/clients")
    ResponseEntity<ClientResponse> updateClient(@RequestBody @Valid ClientRequest request){
        Client client = new Client();
        client = insuranceService.getClient(request.getClientId());
        client.setAddress(request.getAddress());
        client.setDob(request.getDob());
        client.setEmail(request.getEmail());
        client.setName(request.getName());
        client.setPhone(request.getPhone());
        insuranceService.addClient(client);
        ClientResponse response = new ClientResponse(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/api/clients/{clientId}")
    ResponseEntity<ClientResponse> removeClient(@PathVariable(name = "clientId")String id){
        Client client = insuranceService.getClient(UUID.fromString(id));
        insuranceService.removeClient(client);
        return  ResponseEntity.status(HttpStatus.OK).body(new ClientResponse(client));
    }

    

}
