package com.example.petshelter.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class ClientDto {
    private Long id;
    @NotBlank(message = "First name is required!")
    @Size(max = 50, message = "First name must be less than 50 characters!")
    private String firstName;
    @NotBlank(message = "Last name is required!")
    @Size(max = 50, message = "Last name must be less than 50 characters!")
    private String lastName;
    @Size(max = 50, message = "Middle name must be less than 50 characters!")
    private String middleName;
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;
}
