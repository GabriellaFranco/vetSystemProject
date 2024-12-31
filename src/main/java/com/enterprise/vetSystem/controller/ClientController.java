package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.model.dtos.ConsultAllClientsDto;
import com.enterprise.vetSystem.model.dtos.ConsultClientByNameDto;
import com.enterprise.vetSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ConsultAllClientsDto>> consultClients() {
        return ResponseEntity.ok(service.consultClients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsultAllClientsDto> consultClientById(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultClientById(id));
    }

    @GetMapping(value = "/byName")
    public ResponseEntity<List<ConsultClientByNameDto>> consultClientByNameDto(@RequestParam String name) {
        return ResponseEntity.ok(service.consultClientByName(name));
    }
}

