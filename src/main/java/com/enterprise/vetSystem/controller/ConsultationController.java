package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.model.dtos.ConsultClientDto;
import com.enterprise.vetSystem.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService service;


}
