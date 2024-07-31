package com.example.demo.mapper;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.model.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T11:53:03+0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toEntity(ProjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Project project = new Project();

        return project;
    }

    @Override
    public ProjectDTO toDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        return projectDTO;
    }
}
