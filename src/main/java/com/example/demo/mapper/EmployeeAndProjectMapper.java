package com.example.demo.mapper;

import com.example.demo.DTO.EmployeeAndProjectDTO;
import com.example.demo.model.EmployeeAndProject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmployeeAndProjectMapper {
    EmployeeAndProjectMapper INSTANCE = Mappers.getMapper(EmployeeAndProjectMapper.class);

    EmployeeAndProject toEntity(EmployeeAndProjectDTO dto);
    EmployeeAndProjectDTO toDTO(EmployeeAndProject employeeAndProject);
}