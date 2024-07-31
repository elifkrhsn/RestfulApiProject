package com.example.demo.mapper;

import com.example.demo.DTO.PersonalInformationDTO;
import com.example.demo.model.PersonalInformation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T11:53:03+0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class PersonalInformationMapperImpl implements PersonalInformationMapper {

    @Override
    public PersonalInformation toEntity(PersonalInformationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PersonalInformation personalInformation = new PersonalInformation();

        return personalInformation;
    }

    @Override
    public PersonalInformationDTO toDTO(PersonalInformation personalInformation) {
        if ( personalInformation == null ) {
            return null;
        }

        PersonalInformationDTO personalInformationDTO = new PersonalInformationDTO();

        return personalInformationDTO;
    }
}
