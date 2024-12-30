package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.mapper.ClientMapper;
import com.enterprise.vetSystem.model.Client;
import com.enterprise.vetSystem.model.dtos.ConsultClientDto;
import com.enterprise.vetSystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    public List<ConsultClientDto> consultClients() {
        return repository.findAll().stream().map(client -> mapper.clientToConsultClientDto(client)).toList();
    }

}
