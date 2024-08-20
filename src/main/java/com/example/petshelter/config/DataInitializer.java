package com.example.petshelter.config;

import com.example.petshelter.dtos.PetType;
import com.example.petshelter.models.Client;
import com.example.petshelter.models.Pet;
import com.example.petshelter.repositories.ClientRepository;
import com.example.petshelter.repositories.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final PetRepository petRepository;

    public DataInitializer(ClientRepository clientRepository, PetRepository petRepository) {
        this.clientRepository = clientRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add initial data for clients
        Client client1 = new Client();
        client1.setFirstName("John");
        client1.setLastName("Doe");
        client1.setMiddleName("A");
        client1.setAge(30);

        Client client2 = new Client();
        client2.setFirstName("Jane");
        client2.setLastName("Smith");
        client2.setMiddleName("B");
        client2.setAge(25);

        clientRepository.save(client1);
        clientRepository.save(client2);

        // Add initial data for pets
        Pet pet1 = new Pet();
        pet1.setName("Fluffy");
        pet1.setType(PetType.CAT);
        pet1.setAge(3);
        pet1.setDateOfBirth(LocalDate.of(2021, 5, 15));
        pet1.setAdopted(false);

        Pet pet2 = new Pet();
        pet2.setName("Rover");
        pet2.setType(PetType.DOG);
        pet2.setAge(2);
        pet2.setDateOfBirth(LocalDate.of(2022, 1, 22));
        pet2.setAdopted(false);

        petRepository.save(pet1);
        petRepository.save(pet2);
    }
}

