package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.enums.Species;
import com.enterprise.vetSystem.mapper.ConsultAllAnimalsMapper;
import com.enterprise.vetSystem.model.dtos.ConsultAllAnimalsDto;
import com.enterprise.vetSystem.model.dtos.ConsultAnimalByNameDto;
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

    public List<ConsultAnimalByNameDto> consultAnimalByFilter(String name, Species species) {
        return repository.findByFilters(name, species).stream()
                .map(animal -> ConsultAnimalByNameDto.builder()
                        .id(animal.getId())
                        .name(animal.getName())
                        .age(animal.getAge())
                        .species(animal.getSpecies())
                        .breed(animal.getBreed())
                        .gender(animal.getGender())
                        .ownerId(animal.getOwner().getId())
                        .isCastrated(animal.getIsCastrated())
                        .build()).toList();
    }

    public List<ConsultAnimalBySpeciesDto> consultAnimalBySpecies(String species) {
        return repository.findBySpeciesIgnoreCase(species).stream()
                .map(animal -> ConsultAnimalBySpeciesDto.builder()
                        .id(animal.getId())
                        .species(animal.getSpecies())
                        .breed(animal.getBreed())
                        .build()).toList();
    }

}
