package com.example.demo.mapper;

import com.example.demo.DTO.PersonalInformationDTO;
import com.example.demo.model.PersonalInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonalInformationMapper {
    PersonalInformationMapper INSTANCE = Mappers.getMapper(PersonalInformationMapper.class);

    PersonalInformation toEntity(PersonalInformationDTO dto);
    PersonalInformationDTO toDTO(PersonalInformation personalInformation);
}
