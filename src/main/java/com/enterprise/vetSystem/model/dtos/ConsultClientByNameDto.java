package com.enterprise.vetSystem.model.dtos;

import lombok.Builder;

@Builder
public record ConsultClientByNameDto (
        Long id,
        String firstName,
        String lastName
){}
