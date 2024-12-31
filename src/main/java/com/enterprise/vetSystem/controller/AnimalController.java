package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.model.dtos.ConsultAllAnimalsDto;
import com.enterprise.vetSystem.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping
    public ResponseEntity<List<ConsultAllAnimalsDto>> consultAllAnimals() {
        return ResponseEntity.ok(service.consultAllAnimals());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsultAllAnimalsDto> consultAnimalById(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultAnimalById(id));
    }
}
