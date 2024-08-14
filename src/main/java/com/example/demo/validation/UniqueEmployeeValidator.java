package com.example.demo.validation;

import com.example.demo.exception.DuplicateResourceException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.DTO.EmployeeDTO;

public class UniqueEmployeeValidator implements ConstraintValidator<UniqueEmployeeDetails, EmployeeDTO> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(EmployeeDTO employeeDTO, ConstraintValidatorContext context) {
        boolean valid = true;
        if (employeeDTO.getEmail() != null && employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            throw new DuplicateResourceException("Email already exists: " + employeeDTO.getEmail());
        }

        if (employeeDTO.getPhoneNumber() != null && employeeRepository.existsByPhoneNumber(employeeDTO.getPhoneNumber())) {
            throw new DuplicateResourceException("Phone number already exists: " + employeeDTO.getPhoneNumber());
        }

        if (employeeDTO.getPersonalInformation() != null &&
                employeeRepository.existsByIdentityNumber(employeeDTO.getPersonalInformation().getIdentityNumber())) {
            throw new DuplicateResourceException("Identity number already exists: " + employeeDTO.getPersonalInformation().getIdentityNumber());
        }

        if (employeeDTO.getOtherInformation() != null &&
                employeeRepository.existsByIban(employeeDTO.getOtherInformation().getIban())) {
            throw new DuplicateResourceException("IBAN already exists: " + employeeDTO.getOtherInformation().getIban());
        }

        return valid;
    }
}
