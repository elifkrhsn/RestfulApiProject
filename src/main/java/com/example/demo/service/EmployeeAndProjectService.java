package com.example.demo.service;

import com.example.demo.model.EmployeeAndProject;
import com.example.demo.DTO.EmployeeAndProjectDTO;
import com.example.demo.mapper.EmployeeAndProjectMapper;
import com.example.demo.repository.EmployeeAndProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAndProjectService {

    @Autowired
    private EmployeeAndProjectRepository employeeAndProjectRepository;
    private EmployeeAndProjectMapper employeeAndProjectMapper;

    // Create operation
    @Transactional
    public EmployeeAndProjectDTO createEmployeeAndProject(EmployeeAndProjectDTO employeeAndProjectDTO) {
        EmployeeAndProject employeeAndProject = employeeAndProjectMapper.toEntity(employeeAndProjectDTO);
        EmployeeAndProject savedEmployeeAndProject = employeeAndProjectRepository.save(employeeAndProject);
        return employeeAndProjectMapper.toDTO(savedEmployeeAndProject);
    }

    // Read operation
    public List<EmployeeAndProjectDTO> getAllEmployeeAndProjects() {
        return employeeAndProjectRepository.findAll().stream()
                .map(employeeAndProjectMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeAndProjectDTO findById(Long id) {
        EmployeeAndProject employeeAndProject = employeeAndProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project was not found for employee with id " + id));
        return employeeAndProjectMapper.toDTO(employeeAndProject);
    }

    // Update operation
    @Transactional
    public EmployeeAndProjectDTO updateEmployeeAndProject(Long id, EmployeeAndProjectDTO employeeAndProjectDetails) {
        EmployeeAndProject existingEmployeeAndProject = employeeAndProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project was not found for employee with id  " + id));

        existingEmployeeAndProject.setFirstName(employeeAndProjectDetails.getFirstName());
        existingEmployeeAndProject.setLastName(employeeAndProjectDetails.getLastName());
        existingEmployeeAndProject.setProjectName(employeeAndProjectDetails.getProjectName());
        existingEmployeeAndProject.setProjectType(employeeAndProjectDetails.getProjectType());
        existingEmployeeAndProject.setDepartment(employeeAndProjectDetails.getDepartment());

        EmployeeAndProject savedEmployeeAndProject = employeeAndProjectRepository.save(existingEmployeeAndProject);
        return employeeAndProjectMapper.toDTO(savedEmployeeAndProject);
    }

    // Delete operation
    @Transactional
    public void deleteEmployeeAndProject(Long id) {
        if (!employeeAndProjectRepository.existsById(id)) {
            throw new RuntimeException("Project was not found for employee with id " + id);
        }
        employeeAndProjectRepository.deleteById(id);
    }
}
