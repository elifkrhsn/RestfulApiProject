package com.example.demo.mapper;

import com.example.demo.DTO.PersonalInformationDTO;
import com.example.demo.model.Gender;
import com.example.demo.model.MaritalStatus;
import com.example.demo.model.MilitaryStatus;
import com.example.demo.model.PersonalInformation;
import org.springframework.stereotype.Component;

@Component
public class PersonalInformationMapper {

    public PersonalInformation toEntity(PersonalInformationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PersonalInformation personalInformation = new PersonalInformation();

        personalInformation.setId( dto.getId() );
        personalInformation.setBirthdate( dto.getBirthdate() );
        personalInformation.setIdentityNumber( dto.getIdentityNumber() );
        if ( dto.getMilitaryStatus() != null ) {
            personalInformation.setMilitaryStatus( Enum.valueOf( MilitaryStatus.class, dto.getMilitaryStatus() ) );
        }
        if ( dto.getGender() != null ) {
            personalInformation.setGender( Enum.valueOf( Gender.class, dto.getGender() ) );
        }
        if ( dto.getMaritalStatus() != null ) {
            personalInformation.setMaritalStatus( Enum.valueOf( MaritalStatus.class, dto.getMaritalStatus() ) );
        }

        return personalInformation;
    }

    public PersonalInformationDTO toDTO(PersonalInformation personalInformation) {
        if ( personalInformation == null ) {
            return null;
        }

        PersonalInformationDTO personalInformationDTO = new PersonalInformationDTO();

        personalInformationDTO.setId( personalInformation.getId() );
        personalInformationDTO.setBirthdate( personalInformation.getBirthdate() );
        personalInformationDTO.setIdentityNumber( personalInformation.getIdentityNumber() );
        if ( personalInformation.getMilitaryStatus() != null ) {
            personalInformationDTO.setMilitaryStatus( personalInformation.getMilitaryStatus().name() );
        }
        if ( personalInformation.getGender() != null ) {
            personalInformationDTO.setGender( personalInformation.getGender().name() );
        }
        if ( personalInformation.getMaritalStatus() != null ) {
            personalInformationDTO.setMaritalStatus( personalInformation.getMaritalStatus().name() );
        }

        return personalInformationDTO;
    }
}
