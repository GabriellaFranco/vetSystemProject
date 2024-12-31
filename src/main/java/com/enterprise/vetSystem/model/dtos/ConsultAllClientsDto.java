package com.enterprise.vetSystem.model.dtos;

import com.enterprise.vetSystem.enums.ConsultationStatus;
import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Specialization;
import com.enterprise.vetSystem.enums.Species;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ConsultAllClientsDto(
        Long id,
        String firstName,
        String lastName,
        String phone,
        String address,
        List<AnimalDto> animalList,
        List<ConsultationDto> consultationList
) {

    @Builder
    public record AnimalDto(
            Long id,
            String name,
            Species species,
            String breed,
            Integer age,
            Gender gender
    ) {}

    @Builder
    public record ConsultationDto(
            Long id,
            LocalDate dateAndTime,
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


