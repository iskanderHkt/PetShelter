package com.example.petshelter.repositories;

import com.example.petshelter.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByIdAndAdoptedFalse(Long id);
}
