package com.example.demo.controller;

import com.example.demo.DTO.EmployeeAndProjectDTO;
import com.example.demo.service.EmployeeAndProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeAndProjects")
public class EmployeeAndProjectController {

    @Autowired
    private EmployeeAndProjectService employeeAndProjectService;

    // Create operation
    @PostMapping("/create")
    public EmployeeAndProjectDTO createEmployeeAndProject(@RequestBody EmployeeAndProjectDTO employeeAndProjectDTO) {
        return employeeAndProjectService.createEmployeeAndProject(employeeAndProjectDTO);
    }

    // Read operations
    @GetMapping
    public List<EmployeeAndProjectDTO> getAllEmployeeAndProjects() {
        return employeeAndProjectService.getAllEmployeeAndProjects();
    }

    @GetMapping("/getEmployeeAndProject/{id}")
    public EmployeeAndProjectDTO getEmployeeAndProjectById(@PathVariable Long id) {
        return employeeAndProjectService.findById(id);
    }

    // Update operation
    @PutMapping("/update/{id}")
    public EmployeeAndProjectDTO updateEmployeeAndProject(@PathVariable Long id, @RequestBody EmployeeAndProjectDTO employeeAndProjectDTO) {
        return employeeAndProjectService.updateEmployeeAndProject(id, employeeAndProjectDTO);
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeAndProject(@PathVariable Long id) {
        employeeAndProjectService.deleteEmployeeAndProject(id);
    }
}
