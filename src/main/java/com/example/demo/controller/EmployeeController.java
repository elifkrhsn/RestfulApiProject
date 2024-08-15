package com.example.demo.controller;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.filter.FilterEmployee;
import com.example.demo.projection.EmployeeEmailProjection;
import com.example.demo.projection.EmployeeFullNameProjection;
import com.example.demo.projection.EmployeePhoneNumberProjection;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
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


    //projection for finding all information by employee's email
    @GetMapping("/projection/email/{email}")
    public EmployeeEmailProjection getEmployeeProjectionByEmail(@PathVariable String email){
        return employeeService.getEmployeeDetailsByEmail(email);
    }


    //projection for finding information by employee's phone number
    @GetMapping("/projection/phoneNumber/{phoneNumber}")
    public EmployeePhoneNumberProjection getEmployeeProjectionByPhoneNumber(@PathVariable String phoneNumber){
        return employeeService.getEmployeeDetailsByPhoneNumber(phoneNumber);
    }

    //projection for finding all information by employee's full name
    @GetMapping("/projection/fullName/{fullName}")
    public EmployeeFullNameProjection getEmployeeProjectionByFullName(@PathVariable String fullName){
        return employeeService.getEmployeeDetailsByFullName(fullName);
    }




}
