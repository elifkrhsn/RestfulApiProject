package com.example.demo.DTO;


import com.example.demo.model.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectionDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String level;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
    private String workMode;
    private String contractType;
    private String team;
    private LocalDate startDate;
    private LocalDate endDate;

    private String identityNumber;
    private String militaryStatus;
    private String gender;
    private String maritalStatus;

    private String fullAddress;
    private String bankName;
    private String iban;
    private String emergencyContactName;
    private String emergencyContactPhone;

    private String projectName;
    private String projectType;
    private String department;
    private String vpnUsername;
    private String vpnPassword;
    private String environmentInfo;

}
