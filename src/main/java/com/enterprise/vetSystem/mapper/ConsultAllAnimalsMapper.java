package com.enterprise.vetSystem.mapper;

import com.enterprise.vetSystem.model.Animal;
import com.enterprise.vetSystem.model.Consultation;
import com.enterprise.vetSystem.model.dtos.ConsultAllAnimalsDto;
import org.springframework.stereotype.Component;

@Component
public class ConsultAllAnimalsMapper {

    public ConsultAllAnimalsDto animalToConsultAllAnimalsDto(Animal animal) {
        return ConsultAllAnimalsDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .age(animal.getAge())
                .species(animal.getSpecies())
                .breed(animal.getBreed())
                .gender(animal.getGender())
                .isCastrated(animal.getIsCastrated())
                .ownerId(animal.getOwner().getId())
                .consultations(animal.getConsultations().stream()
                        .map(this::mapConsultationsAllAnimalsDto)
                        .toList())
                .build();
    }

    private ConsultAllAnimalsDto.ConsultationDto mapConsultationsAllAnimalsDto(Consultation consultation) {
        return new ConsultAllAnimalsDto.ConsultationDto(
                consultation.getId(),
                consultation.getStatus()
        );
    }
}
