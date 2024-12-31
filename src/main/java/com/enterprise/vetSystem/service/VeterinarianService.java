package com.enterprise.vetSystem.service;

import com.enterprise.vetSystem.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository repository;


}
