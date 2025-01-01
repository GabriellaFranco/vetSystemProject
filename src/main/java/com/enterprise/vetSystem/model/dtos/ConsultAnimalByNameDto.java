package com.enterprise.vetSystem.model.dtos;

import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Species;
import lombok.Builder;

@Builder
public record ConsultAnimalByNameDto (
        Long id,
        String name,
        Species species,
        String breed,
        Integer age,
        Gender gender,
        Long ownerId,
        Boolean isCastrated
){}
