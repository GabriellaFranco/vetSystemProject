package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.mapper.ConsultAllVeterinariansMapper;
import com.enterprise.vetSystem.model.dtos.ConsultAllAnimalsDto;
import com.enterprise.vetSystem.model.dtos.ConsultAllVeterinariansDto;
import com.enterprise.vetSystem.repository.VeterinarianRepository;
import com.enterprise.vetSystem.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository repository;

    @Autowired
    private ConsultAllVeterinariansMapper mapper;

    public List<ConsultAllVeterinariansDto> consultAllVeterinarians() {
        return repository.findAll().stream()
                .map(veterinarian -> mapper.veterinariansToConsultAllVeterinariansDto(veterinarian))
                .toList();
    }

    public ConsultAllVeterinariansDto consultVeterinarianById(Long id) {
        return repository.findById(id)
                .map(mapper::veterinariansToConsultAllVeterinariansDto)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


}
