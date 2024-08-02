package com.example.demo.mapper;


import com.example.demo.DTO.OtherInformationDTO;
import com.example.demo.model.OtherInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OtherInformationMapper {

    OtherInformationMapper INSTANCE = Mappers.getMapper(OtherInformationMapper.class);

    OtherInformation toEntity(OtherInformationDTO dto);
    OtherInformationDTO toDTO(OtherInformation otherInformation);

}
