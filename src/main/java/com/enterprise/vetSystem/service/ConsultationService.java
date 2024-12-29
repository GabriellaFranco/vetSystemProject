package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;
}
