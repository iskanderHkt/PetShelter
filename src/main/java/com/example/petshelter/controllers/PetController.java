package com.example.petshelter.controllers;

import com.example.petshelter.dtos.PetDto;
import com.example.petshelter.models.Pet;
import com.example.petshelter.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/all")
    public List<PetDto> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public PetDto getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PostMapping("/add")
    public PetDto createPet(@RequestBody PetDto petDto) {
        return petService.savePet(petDto);
    }

    @PutMapping("/{id}")
    public PetDto updatePet(@PathVariable Long id, @RequestBody PetDto petDto) {
        petDto.setId(id);
        return petService.savePet(petDto);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}
