package com.example.demo.mapper;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project toEntity(ProjectDTO dto);
    ProjectDTO toDTO(Project project);

}
