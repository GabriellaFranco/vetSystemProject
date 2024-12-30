package com.enterprise.vetSystem.mapper;

import com.enterprise.vetSystem.model.Animal;
import com.enterprise.vetSystem.model.Client;
import com.enterprise.vetSystem.model.Consultation;
import com.enterprise.vetSystem.model.Veterinarian;
import com.enterprise.vetSystem.model.dtos.ConsultClientDto;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ConsultClientDto clientToConsultClientDto (Client client) {
        return ConsultClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phone(client.getPhone())
                .address(client.getAddress())
                .animalList(client.getAnimalList().stream().map(this::mapAnimalDto).toList())
                .build();
    }

    private ConsultClientDto.AnimalDto mapAnimalDto(Animal animal) {
        return ConsultClientDto.AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .species(animal.getSpecies())
                .breed(animal.getBreed())
                .gender(animal.getGender())
                .consultations(animal.getConsultations().stream().map(this::mapConsultationsDto).toList())
                .build();

    }

    private ConsultClientDto.ConsultationDto mapConsultationsDto(Consultation consultation) {
        return ConsultClientDto.ConsultationDto.builder()
                .id(consultation.getId())
                .dateAndTime(consultation.getDateAndTime())
                .description(consultation.getDescription())
                .status(consultation.getStatus())
                .animal(this.mapAnimalDto(consultation.getAnimal()))
                .veterinarian(this.mapVeterinarianDto(consultation.getVeterinarian()))
                .build();

    }

    private ConsultClientDto.VeterinarianDto mapVeterinarianDto(Veterinarian veterinarian) {
        return ConsultClientDto.VeterinarianDto.builder()
                .id(veterinarian.getId())
                .name(veterinarian.getName())
                .crv(veterinarian.getCrv())
                .specialization(veterinarian.getSpecialization())
                .build();
    }

}
