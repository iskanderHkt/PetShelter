package com.example.petshelter.controllers;

import com.example.petshelter.dtos.AddPetToClientDto;
import com.example.petshelter.services.PetAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pet-assignment")
public class PetAssignmentController {
    private final PetAssignmentService petAssignmentService;

    public PetAssignmentController(PetAssignmentService petAssignmentService) {
        this.petAssignmentService = petAssignmentService;
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignPetToClient(@RequestBody AddPetToClientDto dto){
        petAssignmentService.assignPetToClient(dto);
        return ResponseEntity.ok("Pet added to client successfully!");
    }

}
