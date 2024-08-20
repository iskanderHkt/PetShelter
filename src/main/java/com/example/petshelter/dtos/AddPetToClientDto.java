package com.example.petshelter.dtos;

import lombok.Data;

@Data
public class AddPetToClientDto {
    private Long clientId;
    private Long petId;
}
