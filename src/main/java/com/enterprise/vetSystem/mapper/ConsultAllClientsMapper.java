package com.enterprise.vetSystem.mapper;

import com.enterprise.vetSystem.model.Animal;
import com.enterprise.vetSystem.model.Client;
import com.enterprise.vetSystem.model.Consultation;
import com.enterprise.vetSystem.model.Veterinarian;
import com.enterprise.vetSystem.model.dtos.ConsultAllClientsDto;
import org.springframework.stereotype.Component;

@Component
public class ConsultAllClientsMapper {

    public ConsultAllClientsDto clientToConsultClientDto (Client client) {
        return ConsultAllClientsDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phone(client.getPhone())
                .address(client.getAddress())
                .animalList(client.getAnimalList().stream().map(this::mapAnimalDto).toList())
                .consultationList(client.getConsultationsList().stream().map(this::mapConsultationsDto).toList())
                .build();
    }

    private ConsultAllClientsDto.AnimalDto mapAnimalDto(Animal animal) {
        return ConsultAllClientsDto.AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .age(animal.getAge())
                .species(animal.getSpecies())
                .breed(animal.getBreed())
                .gender(animal.getGender())
                .build();

    }

    private ConsultAllClientsDto.ConsultationDto mapConsultationsDto(Consultation consultation) {
        return ConsultAllClientsDto.ConsultationDto.builder()
                .id(consultation.getId())
                .dateAndTime(consultation.getDateAndTime())
                .description(consultation.getDescription())
                .status(consultation.getStatus())
                .animal(this.mapAnimalDto(consultation.getAnimal()))
                .veterinarian(this.mapVeterinarianDto(consultation.getVeterinarian()))
                .build();

    }

    private ConsultAllClientsDto.VeterinarianDto mapVeterinarianDto(Veterinarian veterinarian) {
        return ConsultAllClientsDto.VeterinarianDto.builder()
                .id(veterinarian.getId())
                .name(veterinarian.getName())
                .crv(veterinarian.getCrv())
                .specialization(veterinarian.getSpecialization())
                .build();
    }

}
