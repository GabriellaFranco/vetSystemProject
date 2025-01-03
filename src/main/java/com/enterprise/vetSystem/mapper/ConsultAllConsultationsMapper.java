package com.enterprise.vetSystem.mapper;

import com.enterprise.vetSystem.model.Animal;
import com.enterprise.vetSystem.model.Consultation;
import com.enterprise.vetSystem.model.Veterinarian;
import com.enterprise.vetSystem.model.dtos.ConsultAllConsultationsDto;
import org.springframework.stereotype.Component;

@Component
public class ConsultAllConsultationsMapper {

    public ConsultAllConsultationsDto consultationToConsultAllConsultationsDto(Consultation consultation) {
        return ConsultAllConsultationsDto.builder()
                .id(consultation.getId())
                .description(consultation.getDescription())
                .status(consultation.getStatus())
                .dateAndTime(consultation.getDateAndTime())
                .clientId(consultation.getClient().getId())
                .animal(this.mapAnimalConsultAllConsultationsDto(consultation.getAnimal()))
                .veterinarian(this.mapVeterinarianConsultAllConsultationsDto(consultation.getVeterinarian()))
                .build();
    }

    private ConsultAllConsultationsDto.AnimalDto mapAnimalConsultAllConsultationsDto(Animal animal) {
        return ConsultAllConsultationsDto.AnimalDto.builder()
                .id(animal.getId())
                .species(animal.getSpecies())
                .age(animal.getAge())
                .gender(animal.getGender())
                .isCastrated(animal.getIsCastrated())
                .build();
    }

    private ConsultAllConsultationsDto.VeterinarianDto mapVeterinarianConsultAllConsultationsDto(
            Veterinarian veterinarian) {
        return ConsultAllConsultationsDto.VeterinarianDto.builder()
                .id(veterinarian.getId())
                .name(veterinarian.getName())
                .specialization(veterinarian.getSpecialization())
                .build();
    }
}
