package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.model.dtos.ConsultAllVeterinariansDto;
import com.enterprise.vetSystem.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/veterinarians")
public class VeterinarianController {

    @Autowired
    private VeterinarianService service;

    @GetMapping
    public ResponseEntity<List<ConsultAllVeterinariansDto>> consultAllVeterinarians() {
        return ResponseEntity.ok(service.consultAllVeterinarians());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsultAllVeterinariansDto> findVeterinarianById(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultVeterinarianById(id));
    }

}
