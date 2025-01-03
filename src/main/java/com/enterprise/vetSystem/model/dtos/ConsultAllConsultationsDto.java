package com.enterprise.vetSystem.model.dtos;

import com.enterprise.vetSystem.enums.ConsultationStatus;
import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Specialization;
import com.enterprise.vetSystem.enums.Species;
import com.enterprise.vetSystem.model.Animal;
import com.enterprise.vetSystem.model.Client;
import com.enterprise.vetSystem.model.Veterinarian;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ConsultAllConsultationsDto(
        Long id,
        String description,
        ConsultationStatus status,
        LocalDate dateAndTime,
        Long clientId,
        AnimalDto animal,
        VeterinarianDto veterinarian
) {
    @Builder
    public record AnimalDto(
            Long id,
            Species species,
            Integer age,
            Gender gender,
            Boolean isCastrated
    ) {}

    @Builder
    public record VeterinarianDto(
            Long id,
            String name,
            Specialization specialization
    ) {}
}
