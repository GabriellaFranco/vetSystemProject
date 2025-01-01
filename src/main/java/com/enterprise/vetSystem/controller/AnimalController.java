package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.enums.Species;
import com.enterprise.vetSystem.model.dtos.ConsultAllAnimalsDto;
import com.enterprise.vetSystem.model.dtos.ConsultAnimalByNameDto;
import com.enterprise.vetSystem.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/filter")
    public ResponseEntity<List<ConsultAnimalByNameDto>> consultAnimalByName(@RequestParam(required = false) String name,
                                                                            @RequestParam(required = false) Species species) {
        return ResponseEntity.ok(service.consultAnimalByFilter(name, species));
    }

}
