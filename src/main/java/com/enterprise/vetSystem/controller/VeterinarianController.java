package com.enterprise.vetSystem.controller;

import com.enterprise.vetSystem.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/veterinarians")
public class VeterinarianController {

    @Autowired
    private VeterinarianService service;

}
