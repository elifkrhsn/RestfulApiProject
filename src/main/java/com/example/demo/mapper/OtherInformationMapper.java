package com.example.demo.mapper;

import com.example.demo.DTO.OtherInformationDTO;
import com.example.demo.model.OtherInformation;
import org.springframework.stereotype.Component;

@Component
public class OtherInformationMapper {


    public OtherInformation toEntity(OtherInformationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OtherInformation otherInformation = new OtherInformation();

        otherInformation.setId( dto.getId() );
        otherInformation.setFullAddress( dto.getFullAddress() );
        otherInformation.setBankName( dto.getBankName() );
        otherInformation.setIban( dto.getIban() );
        otherInformation.setEmergencyContactName( dto.getEmergencyContactName() );
        otherInformation.setEmergencyContactPhone( dto.getEmergencyContactPhone() );

        return otherInformation;
    }


    public OtherInformationDTO toDTO(OtherInformation otherInformation) {
        if ( otherInformation == null ) {
            return null;
        }

        OtherInformationDTO otherInformationDTO = new OtherInformationDTO();

        otherInformationDTO.setId( otherInformation.getId() );
        otherInformationDTO.setFullAddress( otherInformation.getFullAddress() );
        otherInformationDTO.setBankName( otherInformation.getBankName() );
        otherInformationDTO.setIban( otherInformation.getIban() );
        otherInformationDTO.setEmergencyContactName( otherInformation.getEmergencyContactName() );
        otherInformationDTO.setEmergencyContactPhone( otherInformation.getEmergencyContactPhone() );

        return otherInformationDTO;

    }
}
