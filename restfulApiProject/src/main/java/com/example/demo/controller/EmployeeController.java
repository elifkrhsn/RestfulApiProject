package com.example.demo.controller;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final EmployeeDTO employeeDTO;


    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, EmployeeDTO employeeDTO, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.employeeDTO = employeeDTO;
        this.employeeRepository = employeeRepository;
    }


    //create operation
    @PostMapping("/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
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
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }


//delete operation

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }



}
