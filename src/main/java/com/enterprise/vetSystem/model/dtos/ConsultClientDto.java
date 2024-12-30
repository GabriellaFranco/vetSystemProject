package com.enterprise.vetSystem.model.dtos;

import com.enterprise.vetSystem.enums.ConsultationStatus;
import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Specialization;
import com.enterprise.vetSystem.enums.Species;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
public record ConsultClientDto(
        Long id,
        String firstName,
        String lastName,
        String phone,
        String address,
        List<AnimalDto> animalList
) {

    @Builder
    public record AnimalDto(
            Long id,
            String name,
            Species species,
            String breed,
            int age,
            Gender gender,
            List<ConsultationDto> consultations
    ) {}

    @Builder
    public record ConsultationDto(
            Long id,
            Date dateAndTime,
            String description,
            ConsultationStatus status,
            AnimalDto animal,
            VeterinarianDto veterinarian
    ){}

    @Builder
    public record VeterinarianDto(
            Long id,
            String name,
            String crv,
            Specialization specialization
    ){}


}


