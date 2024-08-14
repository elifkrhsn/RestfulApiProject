package com.example.demo.service;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.filter.FilterEmployee;
import com.example.demo.filter.FilterProject;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.model.Project;
import com.example.demo.model.Employee;
import com.example.demo.DTO.ProjectDTO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.specification.EmployeeSpecification;
import com.example.demo.specification.ProjectSpecification;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository ;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectMapper projectMapper;



    // Create operation
    @Transactional
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDTO(savedProject);
    }

    // Read operation
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProjectDTO findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found for id " + id));
        return projectMapper.toDTO(project);
    }

    // Update operation
    @Transactional
    public ProjectDTO updateProject(Long id, ProjectDTO projectDetails) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found for id " + id));

        existingProject.setProjectName(projectDetails.getProjectName());
        existingProject.setProjectType(projectDetails.getProjectType());
        existingProject.setDepartment(projectDetails.getDepartment());
        existingProject.setVpnUsername(projectDetails.getVpnUsername());
        existingProject.setVpnPassword(projectDetails.getVpnPassword());
        existingProject.setEnvironmentInfo(projectDetails.getEnvironmentInfo());

        Project savedProject = projectRepository.save(existingProject);
        return projectMapper.toDTO(savedProject);
    }

    // Delete operation
    @Transactional
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found for id: " + id);
        }
        projectRepository.deleteById(id);
    }

    public ProjectDTO joinProjectsAndEmployees(Long projectId, List<Long> employeeIds) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        if (employeeIds != null) {
            List<Employee> employees = employeeIds.stream()
                    .map(id -> employeeRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Employee not found")))
                    .collect(Collectors.toList());
            project.setEmployees(employees);
        }


        Project savedProject = projectRepository.save(project);
        return projectMapper.toDTO(savedProject);
    }

//include specification
    @Transactional
    public List<ProjectDTO> getFilteredProjects(FilterProject filter) {
        List<Project> projects = projectRepository.findAll(ProjectSpecification.filter(filter));
        return projects.stream().map(projectMapper::toDTO).collect(Collectors.toList());
    }

}

