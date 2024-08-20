package com.example.petshelter.dtos;

import com.example.petshelter.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);
}
