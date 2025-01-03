package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.mapper.ConsultAllConsultationsMapper;
import com.enterprise.vetSystem.model.dtos.ConsultAllConsultationsDto;
import com.enterprise.vetSystem.repository.ConsultationRepository;
import com.enterprise.vetSystem.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    @Autowired
    private ConsultAllConsultationsMapper mapper;

    public List<ConsultAllConsultationsDto> consultAllConsultations() {
        return repository.findAll().stream()
                .map(consultation -> mapper
                        .consultationToConsultAllConsultationsDto(consultation)).toList();
    }

    public ConsultAllConsultationsDto consultConsultationById(Long id) {
        return repository.findById(id).map(mapper::consultationToConsultAllConsultationsDto)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


}
