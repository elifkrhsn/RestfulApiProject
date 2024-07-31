package com.example.demo.mapper;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDTO dto);
    EmployeeDTO toDTO(Employee employee);
}
