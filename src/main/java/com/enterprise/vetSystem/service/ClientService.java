package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.mapper.ConsultAllClientsMapper;
import com.enterprise.vetSystem.model.dtos.ConsultAllClientsDto;
import com.enterprise.vetSystem.model.dtos.ConsultClientByNameDto;
import com.enterprise.vetSystem.repository.ClientRepository;
import com.enterprise.vetSystem.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ConsultAllClientsMapper mapper;

    public List<ConsultAllClientsDto> consultClients() {
        return repository.findAll().stream().map(client -> mapper.clientToConsultClientDto(client)).toList();
    }

    public ConsultAllClientsDto consultClientById(Long id) {
        return repository.findById(id)
                .map(mapper::clientToConsultClientDto).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<ConsultClientByNameDto> consultClientByName(String name) {
        return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name).
                stream().map(client -> ConsultClientByNameDto.builder()
                        .id(client.getId())
                        .firstName(client.getFirstName())
                        .lastName(client.getLastName())
                        .build()).toList();
    }

}
