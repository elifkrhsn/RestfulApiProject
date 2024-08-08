package com.example.demo.controller;


import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.ProjectDTO;
import com.example.demo.filter.FilterEmployee;
import com.example.demo.filter.FilterProject;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Create operation
    @PostMapping("/create")
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    // Read operations
    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/getproject/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    // Update operation
    @PutMapping("/update/{id}")
    public ProjectDTO updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
        return projectService.updateProject(id, projectDTO);
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    //join employees and project operation
    @PostMapping("/join/{id}")
    public ProjectDTO joinProjectsAndEmployees(
            @PathVariable Long id,
            @RequestBody List<Long> employeeIds) {

        return projectService.joinProjectsAndEmployees(id, employeeIds);
    }

    //filtered employees
    @PostMapping("/filtered")
    public List<ProjectDTO> filteredProjects(@RequestBody FilterProject filter) {
        return projectService.getFilteredProjects(filter);
    }


}
