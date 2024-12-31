package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService service;


}
