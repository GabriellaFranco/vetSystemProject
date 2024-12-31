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
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

        //CLIENTS INSTANTIATION
        Client client1 = createClient(null, "Linda", "Johnson",
                "4795430-7612", "1233 Brooklyn Street, PC: 98765");

        Client client2 = createClient(null, "Marcus", "Silva",
                "4590876-1254", "34 Langston Road");

        Client client3 = createClient(null, "Travis", "Jill",
                "9835678-0845", "765 Kingston Avenue, PC: 14590");

        clientRepository.saveAll(Arrays.asList(client1, client2, client3));

        //ANIMALS INSTANTIATION
        Animal animal1 = createAnimal(null, "Mel", Species.CANINE,
                "SRD", 16, Gender.FEMALE, client1, true);

        Animal animal2 = createAnimal(null, "Lacey", Species.BOVINE, "Holandese",
                9, Gender.FEMALE, client2, false);

        Animal animal3 = createAnimal(null, "Dexter", Species.RODENTS, "Chinese hamster",
                1, Gender.MALE, client1, false);

        Animal animal4 = createAnimal(null, "Naevia", Species.FELINE, "Angora",
                6, Gender.FEMALE, client3, true);

        Animal animal5 = createAnimal(null, "Bob", Species.REPTILE, "Iguana",
                4, Gender.MALE, client3, false);

        animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3, animal4, animal5));

        //VETERINARIANS INSTANTIATION
        Veterinarian vet1 = createVeterinarian(null, "Maria Perez", "CRV-8763",
                Specialization.OBSTETRICS);

        Veterinarian vet2 = createVeterinarian(null, "Luigi Duncan", "CRV-13543",
                Specialization.GENERAL_PRACTITIONER);

        Veterinarian vet3 = createVeterinarian(null, "Juliana Aguilera", "CRV-37144",
                Specialization.ONCOLOGIST);

        veterinarianRepository.saveAll(Arrays.asList(vet1, vet2, vet3));

        //CONSULTATIONS INSTANTIATION
        Consultation con1 = createConsultation(null, LocalDate.parse("02/03/2022 14:40", dtf),
                "Start of chemo", ConsultationStatus.CONCLUDED, vet3, animal1, client1);

        Consultation con2 = createConsultation(null, LocalDate.parse("31/03/2022 17:30", dtf),
                "General checkup", ConsultationStatus.CANCELED, vet2, animal1, client1);

        Consultation con3 = createConsultation(null, LocalDate.parse("04/01/2025 19:00", dtf),
                "Pacient not eating properly", ConsultationStatus.SCHEDULED, vet2, animal5, client3);

        Consultation con4 = createConsultation(null, LocalDate.parse("27/08/2023 10:00", dtf),
                "Reproduction advice", ConsultationStatus.CONCLUDED, vet1, animal2, client2);

        Consultation con5 = createConsultation(null, LocalDate.parse("14/10/2023 13:30", dtf),
                "Suspicion of cancer", ConsultationStatus.CANCELED, vet3, animal4, client3);

        Consultation con6 = createConsultation(null, LocalDate.parse("12/11/2023 15:45", dtf),
                "Problems breathing", ConsultationStatus.CONCLUDED, vet2, animal3, client1);

        consultationRepository.saveAll(Arrays.asList(con1, con2, con3, con4, con5, con6));
    }

    @Builder
    private Client createClient(Long id, String firstName, String lastName, String phone, String address) {
        return Client.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .address(address)
                .build();
    }


    @Builder
    private Animal createAnimal(Long id, String name, Species species, String breed, Integer age,
                                Gender gender, Client owner, Boolean isCastrated) {

        return Animal.builder()
                .id(id)
                .name(name)
                .species(species)
                .breed(breed)
                .age(age)
                .gender(gender)
                .owner(owner)
                .isCastrated(isCastrated)
                .build();
    }

    @Builder
    private Veterinarian createVeterinarian(Long id, String name, String crv,
                                            Specialization specialization) {

        return Veterinarian.builder()
                .id(id)
                .name(name)
                .crv(crv)
                .specialization(specialization)
                .build();
    }

    @Builder
    public Consultation createConsultation(Long id, LocalDate dateAndTime, String description,
                                           ConsultationStatus status, Veterinarian veterinarian,
                                           Animal animal, Client client) {

        return Consultation.builder()
                .id(id)
                .dateAndTime(dateAndTime)
                .description(description)
                .status(status)
                .veterinarian(veterinarian)
                .animal(animal)
                .client(client)
                .build();
    }

}




