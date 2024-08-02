package com.example.demo.service;

import com.example.demo.mapper.OtherInformationMapper;
import com.example.demo.mapper.PersonalInformationMapper;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.model.*;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private PersonalInformationMapper personalInformationMapper;
    private OtherInformationMapper otherInformationMapper;
    private ProjectMapper projectMapper;


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
            Project project = projectMapper.toEntity(employeeDTO.getProject());
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

        if (employeeDetails.getPersonalInformation() != null) {
            PersonalInformation personalInfo = PersonalInformationMapper.INSTANCE.toEntity(employeeDetails.getPersonalInformation());
            existingEmployee.setPersonalInformation(personalInfo);
        }

        if (employeeDetails.getOtherInformation() != null) {
            OtherInformation otherInfo = OtherInformationMapper.INSTANCE.toEntity(employeeDetails.getOtherInformation());
            existingEmployee.setOtherInformation(otherInfo);
        }

        if (employeeDetails.getProject() != null) {
            Project project = ProjectMapper.INSTANCE.toEntity(employeeDetails.getProject());
            existingEmployee.setProject(project);
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

}
