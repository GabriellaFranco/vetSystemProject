package com.enterprise.vetSystem.config;

import com.enterprise.vetSystem.enums.ConsultationStatus;
import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Specialization;
import com.enterprise.vetSystem.enums.Species;
import com.enterprise.vetSystem.model.Animal;
import com.enterprise.vetSystem.model.Client;
import com.enterprise.vetSystem.model.Consultation;
import com.enterprise.vetSystem.model.Veterinarian;
import com.enterprise.vetSystem.repository.AnimalRepository;
import com.enterprise.vetSystem.repository.ClientRepository;
import com.enterprise.vetSystem.repository.ConsultationRepository;
import com.enterprise.vetSystem.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Override
    public void run(String... args) throws Exception {

        var vet1 = veterinarianRepository.save(Veterinarian.builder()
                .id(null)
                .name("Amanda Gonzalez")
                .crv("CRV-7658")
                .specialization(Specialization.FELINES)
                .build());

        var client1 = clientRepository.save(Client.builder()
                .id(null)
                .firstName("Linda")
                .lastName("Brown")
                .phone("4795430-7612")
                .address("1233 Brooklyn Street, PC: 98765")
                .build());

        var ani1 = animalRepository.save(Animal.builder()
                .id(null)
                .name("Bob")
                .species(Species.FELINE)
                .breed("SRD")
                .age(3)
                .gender(Gender.MALE)
                .owner(client1)
                .isCastrated(true)
                .build());

        var con1 = consultationRepository.save(Consultation.builder()
                .id(null)
                .dateAndTime(LocalDate.parse("03/05/2022 14:40", dtf))
                .description("Routine Checkup")
                .status(ConsultationStatus.CONCLUDED)
                .veterinarian(vet1)
                .animal(ani1)
                .client(client1)
                .build());


    }

}
