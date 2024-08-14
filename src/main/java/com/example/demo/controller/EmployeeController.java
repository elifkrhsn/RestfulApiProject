package com.example.demo.controller;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.EmployeeProjectionDTO;
import com.example.demo.filter.FilterEmployee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //create operation
    @PostMapping("/create")
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }


    //read operations

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemployee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }


// update operation
    @PutMapping("/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }


//delete operation

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


    //filtered employees
    @PostMapping("/filtered")
    public List<EmployeeDTO> filteredEmployees(@RequestBody FilterEmployee filter) {
        return employeeService.getFilteredEmployees(filter);
    }

/*
    //projection for finding requested information (specified in repository) by employee's .....
    @GetMapping("/projection/{lastName}")
    public List<EmployeeProjectionDTO> getEmployeeProjectionByLastName(@PathVariable String lastName) {
        return employeeService.getEmployeesByLastName(lastName);
    }
*/
/*
    //projection for finding all information by employee's id
    @GetMapping("/projection/{id}")
    public EmployeeProjectionDTO getEmployeeProjectionById(@PathVariable Long id){
        return employeeService.getEmployeeProjectionById(id);
    }
*/
/*

    //projection for finding requested information (specified in repository) by employee's email
    @GetMapping("/projection/{email}")
    public EmployeeProjectionDTO getEmployeeProjectionByEmail(@PathVariable String email){
        return employeeService.getEmployeeProjectionByEmail(email);
    }
*/

/*
    //projection for finding requested information (specified in repository) by employee's .....
    @GetMapping("/projection/{lastName}")
    public List<EmployeeProjectionDTO> getEmployeeProjectionByLastName(@PathVariable String lastName) {
        return employeeService.getEmployeesByLastName(lastName);
    }

 */

    @GetMapping("/projection")
    public List<EmployeeProjection> getAllEmployeeProjections() {
        return employeeService.getAllEmployeeProjections();
    }


}
