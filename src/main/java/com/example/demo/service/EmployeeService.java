package com.example.demo.service;

import com.example.demo.DTO.*;
import com.example.demo.filter.FilterEmployee;
import com.example.demo.mapper.OtherInformationMapper;
import com.example.demo.mapper.PersonalInformationMapper;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.model.*;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.projection.EmployeeProjection;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.specification.EmployeeSpecification;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper ;
    @Autowired
    private PersonalInformationMapper personalInformationMapper;
    @Autowired
    private OtherInformationMapper otherInformationMapper;
    @Autowired
    private ProjectMapper projectMapper ;


    //for create operation
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        if (employeeDTO.getPersonalInformation() != null) {
            PersonalInformation personalInformation = personalInformationMapper.toEntity(employeeDTO.getPersonalInformation());
            employee.setPersonalInformation(personalInformation);
        }
        if (employeeDTO.getOtherInformation() != null) {
            OtherInformation otherInformation = otherInformationMapper.toEntity(employeeDTO.getOtherInformation());
            employee.setOtherInformation(otherInformation);
        }
        if (employeeDTO.getProject() != null) {
            List<Project> project = Collections.singletonList(projectMapper.toEntity((ProjectDTO) employeeDTO.getProject()));
            employee.setProject(project);
        }

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }


    //for read operation
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }


    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found for id " + id));
        return employeeMapper.toDTO(employee);
    }


    //update operation implementation
    @Transactional
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDetails) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found for id " + id));

        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        existingEmployee.setLevel(Level.valueOf(employeeDetails.getLevel()));
        existingEmployee.setWorkMode(WorkMode.valueOf(employeeDetails.getWorkMode()));
        existingEmployee.setContractType(ContractType.valueOf(employeeDetails.getContractType()));
        existingEmployee.setTeam(employeeDetails.getTeam());
        existingEmployee.setBirthDate(employeeDetails.getBirthDate());
        existingEmployee.setStartDate(employeeDetails.getStartDate());
        existingEmployee.setEndDate(employeeDetails.getEndDate());


        if (existingEmployee.getPersonalInformation()== null){
            existingEmployee.setPersonalInformation(new PersonalInformation());
        }

        PersonalInformationDTO personalInformationDTO = employeeDetails.getPersonalInformation();
        existingEmployee.getPersonalInformation().setBirthdate(personalInformationDTO.getBirthdate());
        existingEmployee.getPersonalInformation().setIdentityNumber(personalInformationDTO.getIdentityNumber());
        existingEmployee.getPersonalInformation().setMilitaryStatus(MilitaryStatus.valueOf(personalInformationDTO.getMilitaryStatus()));
        existingEmployee.getPersonalInformation().setGender(Gender.valueOf(personalInformationDTO.getGender()));
        existingEmployee.getPersonalInformation().setMaritalStatus(MaritalStatus.valueOf(personalInformationDTO.getMaritalStatus()));


        if (existingEmployee.getOtherInformation()== null){
            existingEmployee.setOtherInformation(new OtherInformation());
        }

        OtherInformationDTO otherInformationDTO = employeeDetails.getOtherInformation();
        existingEmployee.getOtherInformation().setFullAddress(otherInformationDTO.getFullAddress());
        existingEmployee.getOtherInformation().setBankName(otherInformationDTO.getBankName());
        existingEmployee.getOtherInformation().setIban(otherInformationDTO.getIban());
        existingEmployee.getOtherInformation().setEmergencyContactName(otherInformationDTO.getEmergencyContactName());
        existingEmployee.getOtherInformation().setEmergencyContactPhone(otherInformationDTO.getEmergencyContactPhone());


        List<ProjectDTO> projects = employeeDetails.getProject();
        if (projects != null) {
            List<Project> updatedProject = projects.stream()
                    .map(projectMapper::toEntity)
                    .collect(Collectors.toList());
            existingEmployee.setProject(updatedProject);
        }

        Employee savedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toDTO(savedEmployee);
    }

    //for delete operation
    @Transactional
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found for id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    //include specifications
    public List<EmployeeDTO> getFilteredEmployees(FilterEmployee filter) {
        List<Employee> employees = employeeRepository.findAll(EmployeeSpecification.filter(filter));
        return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

/*
    //projection for finding employee by their last name
    public List<EmployeeProjectionDTO> getEmployeesByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

 */

/*
    public EmployeeProjectionDTO getEmployeeProjectionById(Long id) {
        EmployeeProjection employeeProjection = employeeRepository.findEmployeeProjectionById(id);
        return employeeMapper.projectionToEmployeeProjectionDTO(employeeProjection);
    }


 */

/*

    public EmployeeProjectionDTO getEmployeeProjectionByEmail(String email) {
        EmployeeProjection employeeProjection = employeeRepository.findEmployeeProjectionByEmail(email);
        return employeeMapper.projectionToEmployeeProjectionDTO(employeeProjection);
    }
*/

    public List<EmployeeProjection> getAllEmployeeProjections() {
        return employeeRepository.findAllEmployees();

    }
}
