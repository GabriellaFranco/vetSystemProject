package com.enterprise.vetSystem.model.dtos;

import com.enterprise.vetSystem.enums.Specialization;
import lombok.Builder;

@Builder
public record ConsultAllVeterinariansDto(
        Long id,
        String name,
        String crv,
        Specialization Specialization
) {}
