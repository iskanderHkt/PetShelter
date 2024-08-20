package com.example.petshelter.dtos;

import com.example.petshelter.models.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper {
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    PetDto toDTO(Pet pet);
    Pet toEntity(PetDto petDTO);
}
