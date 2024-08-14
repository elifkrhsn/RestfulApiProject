package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.validation.UniqueEmployeeDetails;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@UniqueEmployeeDetails
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 30, message = "First name cannot be longer than 30 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 30, message = "Last name cannot be longer than 30 characters")
    private String lastName;

    private String level;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d-\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "Phone number must be in the format X-XXX-XXX-XX-XX")
    private String phoneNumber;

    @Email(message = "Email must be a valid email address")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[\\w-.]+@felece\\.com$", message = "Email must end with @felece.com")
    private String email;

    private LocalDate birthDate;
    private String workMode;
    private String contractType;
    private String team;
    private LocalDate startDate;
    private LocalDate endDate;
    private PersonalInformationDTO personalInformation;
    private OtherInformationDTO otherInformation;
    private List<ProjectDTO> project;


}
