package com.example.demo.mapper;

import com.example.demo.DTO.OtherInformationDTO;
import com.example.demo.model.OtherInformation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T11:53:03+0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class OtherInformationMapperImpl implements OtherInformationMapper {

    @Override
    public OtherInformation toEntity(OtherInformationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OtherInformation otherInformation = new OtherInformation();

        return otherInformation;
    }

    @Override
    public OtherInformationDTO toDTO(OtherInformation otherInformation) {
        if ( otherInformation == null ) {
            return null;
        }

        OtherInformationDTO otherInformationDTO = new OtherInformationDTO();

        return otherInformationDTO;
    }
}
