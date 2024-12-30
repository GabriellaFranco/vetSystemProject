package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.model.dtos.ConsultClientDto;
import com.enterprise.vetSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ConsultClientDto>> consultClients() {
        return ResponseEntity.ok(service.consultClients());
    }
}
