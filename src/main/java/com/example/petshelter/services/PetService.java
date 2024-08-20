package com.example.petshelter.services;

import com.example.petshelter.dtos.PetDto;
import com.example.petshelter.dtos.PetMapper;
import com.example.petshelter.models.Pet;
import com.example.petshelter.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {
    private final PetRepository petRepo;
    private final PetMapper petMapper = PetMapper.INSTANCE;

    public PetService(PetRepository petRepo) {
        this.petRepo = petRepo;
    }

    public List<PetDto> getAllPets(){
        return petRepo.findAll().stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDto getPetById(Long petId){
        return petRepo.findById(petId)
                .map(petMapper::toDTO)
                .orElse(null);
    }

    public PetDto savePet(PetDto petDto){
        Pet pet = petMapper.toEntity(petDto);
        Pet savedPet = petRepo.save(pet);
        return petMapper.toDTO(savedPet);
    }

    public void deletePet(Long petId){
        petRepo.deleteById(petId);
    }
}
