package com.example.demo.mapper;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.model.Project;
import javax.annotation.processing.Generated;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Project toEntity(ProjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( dto.getId() );
        project.setProjectName( dto.getProjectName() );
        project.setProjectType( dto.getProjectType() );
        project.setDepartment( dto.getDepartment() );
        project.setVpnUsername( dto.getVpnUsername() );
        project.setVpnPassword( dto.getVpnPassword() );
        project.setEnvironmentInfo( dto.getEnvironmentInfo() );
        if (dto.getEmployeeIds() != null) {
            List<Employee> employees = dto.getEmployeeIds().stream()
                    .map(id -> employeeRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Employee not found")))
                    .collect(Collectors.toList());
            project.setEmployees(employees);
        }

        return project;
    }


    public ProjectDTO toDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId( project.getId() );
        projectDTO.setProjectName( project.getProjectName() );
        projectDTO.setProjectType( project.getProjectType() );
        projectDTO.setDepartment( project.getDepartment() );
        projectDTO.setVpnUsername( project.getVpnUsername() );
        projectDTO.setVpnPassword( project.getVpnPassword() );
        projectDTO.setEnvironmentInfo( project.getEnvironmentInfo() );
        if (project.getEmployees() != null) {
            List<Long> employeeIds = project.getEmployees().stream()
                    .map(Employee::getId)
                    .collect(Collectors.toList());
            projectDTO.setEmployeeIds(employeeIds);
        }

        return projectDTO;
    }
}
