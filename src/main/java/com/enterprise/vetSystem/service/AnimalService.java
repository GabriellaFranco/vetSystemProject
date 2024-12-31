package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.mapper.ConsultAllAnimalsMapper;
import com.enterprise.vetSystem.model.dtos.ConsultAllAnimalsDto;
import com.enterprise.vetSystem.repository.AnimalRepository;
import com.enterprise.vetSystem.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private ConsultAllAnimalsMapper mapper;

    public List<ConsultAllAnimalsDto> consultAllAnimals() {
        return repository.findAll().stream().map(animal -> mapper.animalToConsultAllAnimalsDto(animal)).toList();
    }

    public ConsultAllAnimalsDto consultAnimalById(Long id) {
        return repository.findById(id).
                map(mapper::animalToConsultAllAnimalsDto).orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
