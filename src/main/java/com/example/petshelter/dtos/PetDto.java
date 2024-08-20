package com.example.petshelter.dtos;

import com.example.petshelter.dtos.enumValidation.EnumType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDto {
    private Long id;
    @NotBlank(message = "Name is required!")
    @Size(max = 30, message = "Name must be less than 30 characters!")
    private String name;
    @NotNull(message = "Type is required!")
    @EnumType(enumClass = PetType.class, message = "Invalid pet type!")
    private PetType type;
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;
    @PastOrPresent(message = "Date of birth must be in the past or present")
    private LocalDate dateOfBirth;
}


