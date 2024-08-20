package com.example.petshelter.services;

import com.example.petshelter.dtos.ClientDto;
import com.example.petshelter.dtos.ClientMapper;
import com.example.petshelter.models.Client;
import com.example.petshelter.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepo;
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<ClientDto> getAllClients() {
        return clientRepo.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto getClientById(Long clientId) {
        return clientRepo.findById(clientId)
                .map(clientMapper::toDto)
                .orElse(null);
    }

    public ClientDto saveClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        Client savedClient = clientRepo.save(client);
        return clientMapper.toDto(savedClient);
    }

    public void deleteClient(Long clientId) {
        clientRepo.deleteById(clientId);
    }
}
