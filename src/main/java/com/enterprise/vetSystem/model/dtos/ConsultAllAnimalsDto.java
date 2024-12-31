package com.enterprise.vetSystem.model.dtos;

import com.enterprise.vetSystem.enums.ConsultationStatus;
import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Species;
import com.enterprise.vetSystem.model.Client;
import com.enterprise.vetSystem.model.Consultation;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ConsultAllAnimalsDto (
        Long id,
        String name,
        Species species,
        String breed,
        Integer age,
        Gender gender,
        Long ownerId,
        Boolean isCastrated,
        List<ConsultAllAnimalsDto.ConsultationDto> consultations
){
    @Builder
    public record ClientDto(
            Long id,
            String firstName,
            String lastName
    ){}

    @Builder
    public record ConsultationDto(
            Long id,
            ConsultationStatus status
    ){}
}
