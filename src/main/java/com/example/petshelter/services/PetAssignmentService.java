package com.example.petshelter.services;

import com.example.petshelter.dtos.AddPetToClientDto;
import com.example.petshelter.models.Client;
import com.example.petshelter.models.Pet;
import com.example.petshelter.repositories.ClientRepository;
import com.example.petshelter.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetAssignmentService {
    private final ClientRepository clientRepository;
    private final PetRepository petRepository;

    @Autowired
    public PetAssignmentService(ClientRepository clientRepository, PetRepository petRepository) {
        this.clientRepository = clientRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public void assignPetToClient(AddPetToClientDto dto){
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        Pet pet = petRepository.findByIdAndAdoptedFalse(dto.getPetId())
                .orElseThrow(() -> new EntityNotFoundException(("Pet not found")));

        client.getClientPets().add(pet);
        pet.setClient(client);
        pet.setAdopted(true);

        clientRepository.save(client);
        petRepository.save(pet);
    }

}
