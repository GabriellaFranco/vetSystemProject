package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.model.dtos.ConsultAllConsultationsDto;
import com.enterprise.vetSystem.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService service;

    @GetMapping
    public ResponseEntity<List<ConsultAllConsultationsDto>> consultAllConsultations() {
        return ResponseEntity.ok(service.consultAllConsultations());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsultAllConsultationsDto> consultConsultationById(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultConsultationById(id));
    }


}
